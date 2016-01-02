package com.fujitsu.fs.javalab.poll.dao.hsqldb;

import com.fujitsu.fs.javalab.poll.dao.JdbcConnectionPool;
import com.fujitsu.fs.javalab.poll.model.Poll;
import com.fujitsu.fs.javalab.poll.model.PollChoice;
import org.apache.commons.io.FileUtils;
import org.hsqldb.cmdline.SqlFile;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class PollChoiceDaoHsqldbTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        try (Connection conn = JdbcConnectionPool.getInstance().getConnection()) {
            for (String sqlResource : new String[]{"drop-schema.sql", "create-schema.sql",
                    "test-data2.sql"}) {
                InputStream in = getClass().getResourceAsStream("/" + sqlResource);
                File file = folder.newFile();
                FileUtils.copyInputStreamToFile(in, file);
                SqlFile sqlFile = new SqlFile(file, StandardCharsets.UTF_8.name());
                sqlFile.setConnection(conn);
                sqlFile.execute();
            }
        }
    }

    @Test
    public void testRemoveExciting() throws Exception {
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        assertTrue(pollChoiceDao.remove(1));
        assertNull("Found previously removed entry", pollChoiceDao.get(1));
    }

    @Test
    public void testRemoveNotExisting() throws Exception {
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        assertFalse(pollChoiceDao.remove(10001));
    }

    @Test
    public void testGet(){
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();

        PollChoice poll = pollChoiceDao.get(1);
        assertEquals(1L, poll.getId().longValue());
        assertEquals("Да", poll.getChoiceText());
        assertEquals(0, poll.getVotes());
        assertEquals(1L, poll.getPollId().longValue());
    }

    @Test
    public void testGetAll() throws Exception {
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        List<PollChoice> list = pollChoiceDao.getAll();
        PollChoice poll1 = list.get(0);
        assertEquals(1L, poll1.getId().longValue());
        assertEquals("Да", poll1.getChoiceText());
        assertEquals(0, poll1.getVotes());
        assertEquals(1L, poll1.getPollId().longValue());
        PollChoice poll2 = list.get(1);
        assertEquals(2L, poll2.getId().longValue());
        assertEquals("Нет", poll2.getChoiceText());
        assertEquals(3, poll2.getVotes());
        assertEquals(2L, poll2.getPollId().longValue());
    }

    @Test
    public void testUpdate() throws Exception {
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        PollChoice myPoll = new PollChoice(2L,"Да",1,2L);
        pollChoiceDao.update(myPoll);
        PollChoice poll = pollChoiceDao.get(myPoll.getId());
        assertEquals(myPoll.getId().longValue(),poll.getId().longValue());
        assertEquals(myPoll.getChoiceText(),poll.getChoiceText());
        assertEquals(myPoll.getVotes(),poll.getVotes());
        assertEquals(myPoll.getPollId(),poll.getPollId());
    }

    @Test
    public void testAdd() throws Exception {
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        PollChoice myPoll = new PollChoice(3L,"Да",1,2L);
        pollChoiceDao.add(myPoll);
        PollChoice poll = pollChoiceDao.get(3);
        assertEquals(myPoll.getId().longValue(),poll.getId().longValue());
        assertEquals(myPoll.getChoiceText(),poll.getChoiceText());
        assertEquals(myPoll.getVotes(),poll.getVotes());
        assertEquals(myPoll.getPollId(),poll.getPollId());
    }

    @Test
    public void testGetCount() throws Exception {
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        assertEquals(2,pollChoiceDao.getCount());
    }
    @Test
    public void testGetPoll(){
        PollChoiceDaoHsqldb pollChoiceDao = new PollChoiceDaoHsqldb();
        Poll poll = pollChoiceDao.getPoll(2);
        assertEquals(2L, poll.getId().longValue());
        assertEquals("Удовлетворенность курсом Oracle", poll.getTitle());
        assertEquals("Понравились ли вам занятия по Oracle", poll.getDescription());
    }
}