package dao;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
public class Sql2oNewsDao implements  NewsDao {
    private  final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(News news){
        String sql ="INSERT INTO news (title, content, departId) VALUES (:title, :content, :departId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .throwOnMappingFailure(false)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }catch (Sql2oException error){
            throw  error;
        }
    }
    @Override
    public List<News> getAllNews(){
        String sql = "SELECT * FROM news";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .executeAndFetch(News.class);
        }catch (Sql2oException error){
            throw  error;
        }
    }
    @Override
    public News findById(int id) {
        String sql = "SELECT * FROM news WHERE id = :id";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }catch (Sql2oException error){
            throw  error;
        }
    }
    @Override
    public  List<News>  findNewsByDepart(int departId){
        String sql = "SELECT * FROM news WHERE departId = :departId";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .addParameter("departId", departId)
                    .executeAndFetch(News.class);
        }catch (Sql2oException error){
            throw  error;
        }
    }
}
