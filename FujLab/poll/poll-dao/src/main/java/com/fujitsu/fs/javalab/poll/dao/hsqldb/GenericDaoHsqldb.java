package com.fujitsu.fs.javalab.poll.dao.hsqldb;

import com.fujitsu.fs.javalab.poll.dao.DataAccessException;
import com.fujitsu.fs.javalab.poll.dao.GenericDao;
import com.fujitsu.fs.javalab.poll.dao.JdbcConnectionPool;
import com.fujitsu.fs.javalab.poll.model.AbstractModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDaoHsqldb<T extends AbstractModel>
        implements GenericDao<T> {

    protected Connection getConnection() throws SQLException {
        return JdbcConnectionPool.getInstance().getConnection();
    }
    public boolean remove(long id, String sql){
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setLong(1, id);
                int rows = pstmt.executeUpdate();
            switch (rows){
                case 0:
                    return false;
                case 1:
                    return true;
                default:
                    throw new DataAccessException("Expected only 1 row updated, got " + rows);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error removing Poll with id " + id, e);
        }
    }
    public long getCount(String Request) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(Request)) {
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw new DataAccessException("Error counting polls", e);
        }
    }
}
