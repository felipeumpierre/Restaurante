package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableDaoImpl extends Dao implements TableDao {

    private PreparedStatement ps;
    private Connection connect;
    private DateFormat dateFormat;
    
    public TableDaoImpl() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public int insert(Table t) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, t.getNumber());
            ps.setInt(2, t.getCapacity());
            ps.setString(3, this.dateFormat.format(new Date()));

            int result = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                t.setId(rs.getInt(1));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public int delete(Table t) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(DELETE);
            ps.setInt(1, t.getNumber());

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public int update(Table t) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement("UPDATE restaurante.table SET capacity = ?, number = ? WHERE id = ?");            
            ps.setInt(1, t.getCapacity());
            ps.setInt(2, t.getNumber());
            ps.setInt(3, t.getId());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public List<Table> findAll() {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_ALL);

            ResultSet rs = ps.executeQuery();
            List<Table> t = new ArrayList<Table>();

            while (rs.next()) {
                Table table = new Table(rs.getInt("number"), rs.getInt("capacity"));
                table.setId(rs.getInt("id"));

                t.add(table);
            }

            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public Table findById(int id) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Table table = new Table(rs.getInt("number"), rs.getInt("capacity"));
                table.setId(rs.getInt("id"));
                table.setAvailable(rs.getInt("available"));

                return table;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public Table findByNumber(int number) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_BY_NUMBER);
            ps.setInt(1, number);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Table table = new Table(rs.getInt("number"), rs.getInt("capacity"));
                table.setId(rs.getInt("id"));

                return table;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

}
