package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Waiter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaiterDaoImpl extends Dao implements WaiterDao {

    private PreparedStatement ps;
    private Connection connect;
    private DateFormat dateFormat;
    
    public WaiterDaoImpl() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public int insert(Waiter w) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, w.getName());
            ps.setString(2, w.getCpf());
            ps.setDouble(3, w.getSalary());
            ps.setString(4, this.dateFormat.format(new Date()));

            int result = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                w.setId(rs.getInt(1));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public int delete(Waiter w) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(DELETE);
            ps.setString(1, w.getCpf());

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public int update(Waiter w) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(UPDATE);
            ps.setInt(1, w.getId());
            ps.setString(2, w.getName());
            ps.setString(3, w.getCpf());
            ps.setDouble(4, w.getSalary());

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public Waiter findByName(String name) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_BY_NAME);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Waiter waiter = new Waiter(rs.getString("name"), rs.getString("cpf"), rs.getDouble("salary"));
                waiter.setId(rs.getInt("id"));

                return waiter;
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

    public List<Waiter> findAll() {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_ALL);

            ResultSet rs = ps.executeQuery();
            List<Waiter> w = new ArrayList<Waiter>();

            while (rs.next()) {
                Waiter waiter = new Waiter(rs.getString("name"), rs.getString("cpf"), rs.getDouble("salary"));
                waiter.setId(rs.getInt("id"));

                w.add(waiter);
            }

            return w;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(connect);
        }
    }

    public Waiter findById(int id) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Waiter waiter = new Waiter(rs.getString("name"), rs.getString("cpf"), rs.getDouble("salary"));
                waiter.setId(rs.getInt("id"));

                return waiter;
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

    public Waiter findByCpf(String cpf) {
        try {
            connect = getConnection();
            ps = connect.prepareStatement(FIND_BY_CPF);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Waiter waiter = new Waiter(rs.getString("name"), rs.getString("cpf"), rs.getDouble("salary"));
                waiter.setId(rs.getInt("id"));

                return waiter;
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
