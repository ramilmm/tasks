package com.fujitsu.fs.javalab.poll.dao.hsqldb;

import com.fujitsu.fs.javalab.poll.dao.DataAccessException;
import com.fujitsu.fs.javalab.poll.model.Poll;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PollDaoHsqldb extends GenericDaoHsqldb<Poll> {

    private static final String SelectByID = "SELECT ID, TITLE, DESCRIPTION FROM POLL WHERE ID = ?";
    private static final String SelectALL = "SELECT ID, TITLE, DESCRIPTION FROM POLL";
    private static final String CountALL = "SELECT COUNT(*) FROM POLL";
    private static final String DeleteByID = "DELETE FROM POLL WHERE ID = ?";
    private static final String Update = "update poll set title = ?,description = ? where id = ?";

    @Override
    public Poll get(long id) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SelectByID)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return createPoll(rs);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error extract Poll with id " + id, e);
        }
        return null;
    }

    @Override
    public List<Poll> getAll() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SelectALL);
            List<Poll> polls = new ArrayList<>();
            while (rs.next()) {
                polls.add(createPoll(rs));
            }
            return polls;
        } catch (SQLException e) {
            throw new DataAccessException("Error extract polls", e);
        }
    }


    @Override
    public Poll update(Poll poll) {
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(Update)) {
            long id = poll.getId();
            String title = poll.getTitle();
            String description = poll.getDescription();
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error updating poll", e);
         }
        return poll;
    }


    @Override
    public long add(Poll poll) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO POLL(ID, TITLE, DESCRIPTION) VALUES (?,?,?)")) {
            long id = poll.getId();
            String title = poll.getTitle();
            String description = poll.getDescription();
            pstmt.setLong(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, description);
            pstmt.executeUpdate();
            return id;
        } catch (SQLException e) {
            throw new DataAccessException("Error adding poll", e);
        }
    }


    @Override
    public boolean remove(long id) {
        return super.remove(id, DeleteByID);
    }


    @Override
    public long getCount() {
        return super.getCount(CountALL);
    }

    protected Poll createPoll(ResultSet rs) {
        Poll poll = new Poll();
        try {
            poll.setId(rs.getLong("ID"));
            poll.setTitle(rs.getString("TITLE"));
            poll.setDescription(rs.getString("DESCRIPTION"));
        } catch (SQLException e) {
            throw new DataAccessException("Error creating Poll from the result set");
        }
        return poll;
    }

}
