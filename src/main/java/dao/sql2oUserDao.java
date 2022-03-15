package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (name, position, role, department, departId) VALUES (:name, :position, :role, :department, :departId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)

                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }catch (Sql2oException error){
            throw  error;
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(User.class);
        }catch (Sql2oException error){
            throw  error;
        }
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }catch (Sql2oException error){
            throw  error;
        }

    }
    @Override
    public List<User> findUsersByDepart(int departId) {
        String sql = "SELECT * FROM users WHERE departId = :departId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departId", departId)
                    .executeAndFetch(User.class);
        }catch (Sql2oException error){
            throw  error;
        }

    }


}

