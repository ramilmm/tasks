package com.fujitsu.fs.javalab.poll.cli;

import java.sql.*;
import java.util.Arrays;
import java.util.EmptyStackException;

public class PollCLI {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:hsqldb:file:c:/tmp/jdbc/polldb/poll";

        try (Connection conn = DriverManager.getConnection(url, "SA", "")) {
            list(conn);
        }
    }

    protected static void loadDemoData(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL VALUES " +
                "(1, 'Java Core', NULL)," +
                "(2, 'Logging', 'slf4j, log4j')," +
                "(3, 'JDBC', NULL);";
        try (Statement stmt = conn.createStatement()) {
            int rowsUpdated = stmt.executeUpdate(sql);
            System.out.println("Updated " + rowsUpdated + " rows");
        }
    }

    protected static void loadDemoData2(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, 4);
            pstmt.setString(2, "IO");
            pstmt.setString(3, null);
            pstmt.executeUpdate();

            pstmt.setLong(1, 5);
            pstmt.setString(2, "Maven");
            pstmt.setString(3, "Single module projects");
            pstmt.executeUpdate();
        }
    }

    protected static void loadDemoData3(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL VALUES (?, ?, ?)";

        boolean oldAutoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, 6);
            pstmt.setString(2, "Ant");
            pstmt.setString(3, null);
            pstmt.addBatch();

            pstmt.setLong(1, 7);
            pstmt.setString(2, "JDBC");
            pstmt.setString(3, "Transactions");
            pstmt.addBatch();

            int[] res = pstmt.executeBatch();
            System.out.println("Inserted " + Arrays.stream(res).sum() + " records");
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception ignored) {
                }
            }
            conn.setAutoCommit(oldAutoCommit);
        }
    }

    protected static void list(Connection conn) throws SQLException {
        final String sql = "SELECT ID, TITLE, DESCRIPTION FROM POLL";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("ID");
                String title = rs.getString("TITLE");
                String description = rs.getString("DESCRIPTION");
                System.out.printf("%2d | %-18s | %-30s\n", id, title, description);
            }
        }
    }

    protected static void count(Connection conn) throws SQLException {
        final String sql = "SELECT COUNT(*) FROM POLL";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Long count = rs.getLong(1);
                System.out.println("Count is " + count);
            } else {
                throw new EmptyStackException();
            }
        }
    }

    protected static void updateRS(Connection conn) throws SQLException {
        final String sql = "SELECT ID, TITLE, DESCRIPTION FROM POLL WHERE ID=1";
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                rs.updateString("DESCRIPTION", "Понравилось ли вам занятие?");
                rs.updateRow();
            } else {
                throw new EmptyStackException();
            }
        }
    }

    protected static void getAutoGenerated(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL_CHOICE(ID,CHOICE_TEXT, VOTES, POLL_ID) " +
                "VALUES (DEFAULT, ?, 0, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, "Да");
            pstmt.setLong(2, 1);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            System.out.println("Inserted row with ID " + rs.getLong(1));

            pstmt.setString(1, "Нет");
            pstmt.setLong(2, 1);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            rs.next();
            System.out.println("Inserted row with ID " + rs.getLong(1));
        }
    }

}
