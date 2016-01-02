package com.fujitsu.fs.javalab.poll.dao.hsqldb;

import com.fujitsu.fs.javalab.poll.dao.JdbcConnectionPool;
import com.fujitsu.fs.javalab.poll.model.Poll;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hsqldb.cmdline.SqlFile;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PollDaoHsqldbTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * Initializes database.
     *
     * <ol>
     *     <li>Drop schema if exist.</li>
     *     <li>Create schema.</li>
     *     <li>Load test data.</li>
     * </ol>
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        try (Connection conn = JdbcConnectionPool.getInstance().getConnection()) {
            for (String sqlResource : new String[]{"drop-schema.sql", "create-schema.sql",
                    "test-data.sql"}) {
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
    public void testRemoveExisting() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();
        assertTrue(pollDao.remove(1));
        assertNull("Found previously removed entry", pollDao.get(1));
    }

    @Test
    public void testRemoveNotExisting() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();

        assertFalse(pollDao.remove(10001));
    }

    @Test
    public void testGet() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();

        Poll poll = pollDao.get(1);
        assertEquals(1L, poll.getId().longValue());
        assertEquals("Удовлетворенность курсом Java", poll.getTitle());
        assertEquals("Понравились ли вам занятия по Java", poll.getDescription());
    }
    @Test
    public void testGetNotExising() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();
        assertNull(pollDao.get(10001));
    }

    @Test
    public void testGetAll() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();
        List<Poll> list = pollDao.getAll();
        Poll poll1 = list.get(0);
        assertEquals(1L, poll1.getId().longValue());
        assertEquals("Удовлетворенность курсом Java", poll1.getTitle());
        assertEquals("Понравились ли вам занятия по Java", poll1.getDescription());
        Poll poll2 = list.get(1);
        assertEquals(2L, poll2.getId().longValue());
        assertEquals("Удовлетворенность курсом Oracle", poll2.getTitle());
        assertEquals("Понравились ли вам занятия по Oracle", poll2.getDescription());
    }

    @Test
    public void testUpdate() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();
        Poll myPoll = new Poll((long)2,"Удовлетворенность курсом DataBase","Понравились ли вам занятия по DB");
        pollDao.update(myPoll);
        Poll poll = pollDao.get(myPoll.getId());
        assertEquals(myPoll.getId().longValue(),poll.getId().longValue());
        assertEquals(myPoll.getTitle(),poll.getTitle());
        assertEquals(myPoll.getDescription(),poll.getDescription());
    }

    @Test
    public void testAdd() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();
        Poll myPoll = new Poll(3L,"Удовлетворенность курсом IO","Понравились ли вам занятия по IO");
        pollDao.add(myPoll);
        Poll poll = pollDao.get(3);
        assertEquals(3L,poll.getId().longValue());
        assertEquals("Удовлетворенность курсом IO",poll.getTitle());
        assertEquals("Понравились ли вам занятия по IO",poll.getDescription());
    }

    @Test
    public void testGetCount() throws Exception {
        PollDaoHsqldb pollDao = new PollDaoHsqldb();
        assertEquals(2,pollDao.getCount());
    }

}
