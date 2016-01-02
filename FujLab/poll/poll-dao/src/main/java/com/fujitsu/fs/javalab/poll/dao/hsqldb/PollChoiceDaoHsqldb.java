package com.fujitsu.fs.javalab.poll.dao.hsqldb;

import com.fujitsu.fs.javalab.poll.dao.DataAccessException;
import com.fujitsu.fs.javalab.poll.dao.PollChoiceDao;
import com.fujitsu.fs.javalab.poll.model.Poll;
import com.fujitsu.fs.javalab.poll.model.PollChoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PollChoiceDaoHsqldb extends GenericDaoHsqldb<PollChoice> implements PollChoiceDao {
    private static final String SelectByID = "SELECT ID,CHOICE_TEXT, VOTES,POLL_ID FROM POLL_CHOICE WHERE ID = ?";
    private static final String SelectALL = "SELECT ID,CHOICE_TEXT, VOTES,POLL_ID FROM POLL_CHOICE";
    private static final String CountALL = "SELECT COUNT(*) FROM POLL_CHOICE";
    private static final String DeleteByID = "DELETE FROM POLL_CHOICE WHERE ID = ?";
    private static final String Update = "update POLL_CHOICE set CHOICE_TEXT = ?,VOTES = ?,POLL_ID = ? where id = ?";

    @Override
    public PollChoice get(long id) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SelectByID)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return createPollChoice(rs);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error retrieving PollChoice with id " + id, e);
        }
        return null;
    }

    @Override
    public List<PollChoice> getAll() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SelectALL);
            List<PollChoice> polls = new ArrayList<>();
            while (rs.next()) {
                polls.add(createPollChoice(rs));
            }
            return polls;
        } catch (SQLException e) {
            throw new DataAccessException("Error retrieving poll choices", e);
        }
    }

    @Override
    public PollChoice update(PollChoice poll) {
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(Update)) {
            long id = poll.getId();
            String choiceText = poll.getChoiceText();
            int votes = poll.getVotes();
            long pollId = poll.getPollId();
            pstmt.setString(1, choiceText);
            pstmt.setInt(2, votes);
            pstmt.setLong(3, pollId);
            pstmt.setLong(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error updating poll choice", e);
        }
        return poll;
    }

    @Override
    public long add(PollChoice poll) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO POLL_CHOICE(ID, CHOICE_TEXT, VOTES, POLL_ID) VALUES (?,?,?,?)")) {
            long id = poll.getId();
            String choiceText = poll.getChoiceText();
            int votes = poll.getVotes();
            long pollId = poll.getPollId();
            pstmt.setLong(1, id);
            pstmt.setString(2, choiceText);
            pstmt.setInt(3, votes);
            pstmt.setLong(4, pollId);

            pstmt.executeUpdate();
            return id;
        } catch (SQLException e) {
            throw new DataAccessException("Error adding poll choice", e);
        }
    }

    @Override
    public boolean remove(long id) {
        return super.remove(id,DeleteByID);
    }

    @Override
    public long getCount() {
        return super.getCount(CountALL);
    }
    protected PollChoice createPollChoice(ResultSet rs) {
        PollChoice poll = new PollChoice();
        try {
            poll.setId(rs.getLong("ID"));
            poll.setChoiceText(rs.getString("CHOICE_TEXT"));
            poll.setVotes(rs.getInt("VOTES"));
            poll.setPollId(rs.getLong("POLL_ID"));
        } catch (SQLException e) {
            throw new DataAccessException("Error creating Poll Choice from the result set");
        }
        return poll;
    }

    @Override
    public Poll getPoll(long id) {
            PollChoice pollChoice = get(id);
            long pollId = pollChoice.getPollId();
            return new PollDaoHsqldb().get(pollId);
    }
}
