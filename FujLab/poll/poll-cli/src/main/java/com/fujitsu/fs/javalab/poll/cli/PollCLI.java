package com.fujitsu.fs.javalab.poll.cli;

import java.sql.*;
import java.util.Arrays;

public class PollCLI {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:hsqldb:file:c:/tmp/Java/poll";
        try (Connection conn = DriverManager.getConnection(url, "sa", "")) {
            loadDemoData(conn);
//            loadDemoData2(conn);
//            loadDemoData3(conn);
            count(conn);
            list(conn);
        }
    }

    protected static void loadDemoData(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL VALUES" +
                "(1, 'Java Core', NULL)," +
                "(2,'Logging','slf4j,log4j')," +
                "(3,'JDBC', NULL );";
        try (Statement statement = conn.createStatement()) {
            int rowsUpdater = statement.executeUpdate(sql);
            System.out.println("Updated " + rowsUpdater + " rows");
        }
    }

    protected static void loadDemoData2(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL VALUES (?,?,?);";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, 4);
            statement.setString(2, "IO");
            statement.setString(3, null);
            statement.executeUpdate();

            statement.setLong(1, 5);
            statement.setString(2, "Maven");
            statement.setString(3, "Single module projects");
            statement.executeUpdate();
        }
    }

    protected static void loadDemoData3(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL VALUES (?,?,?);";

        boolean oldAutoConf = conn.getAutoCommit();
        conn.setAutoCommit(false);
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setLong(1, 4);
            statement.setString(2, "Ant");
            statement.setString(3, null);
            statement.executeUpdate();
            statement.addBatch();

            statement.setLong(1, 5);
            statement.setString(2, "JDBC");
            statement.setString(3, null);
            statement.executeUpdate();
            statement.addBatch();

            int[] res = statement.executeBatch();
            System.out.println("Inserted " + Arrays.stream(res).sum() + " records");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ignored) {
                }
            }
            conn.setAutoCommit(oldAutoConf);
        }

    }


    protected static void list(Connection conn) throws SQLException {
        final String sql = "SELECT ID,TITLE, DESCRIPTION FROM POLL";
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("ID");
                String tittle = rs.getString("TITLE");
                String description = rs.getString("DESCRIPTION");
                System.out.println(id + " | " + tittle + " | " + description);
            }
        }
    }


    protected static void updateRS(Connection conn) throws SQLException {
        final String sql = "SELECT ID,TITLE, DESCRIPTION FROM POLL WHERE ID = 1";
        try (Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()) {
                rs.updateString("DESCRIPTION","AZAZAZAZAAZ");
                rs.updateRow();
            }else{
                //throw exception
            }
        }
    }


    protected static void count(Connection conn) throws SQLException {
        final String sql = "SELECT COUNT(*) FROM POLL";
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                Long count = rs.getLong(1);
                System.out.println("Count is " + count);
            } else {
                //throw exeption
            }
        }
    }

    protected static void loadDemoData5(Connection conn) throws SQLException {
        final String sql = "INSERT INTO POLL_CHOICE(ID,CHOICE_TEXT,VOTES, POLL_ID) VALUES (DEFAULT , ?, 0, ?);";

        try(PreparedStatement statement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "Da");
            statement.setLong(2, 1);
            statement.executeUpdate();


            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            System.out.println("Inserted row with ID " + rs.getLong(1));

            statement.setString(1, "Net");
            statement.setLong(2, 1);
            statement.executeUpdate();


            rs = statement.getGeneratedKeys();
            rs.next();
            System.out.println("Inserted row with ID " + rs.getLong(1));

        }
    }

}
