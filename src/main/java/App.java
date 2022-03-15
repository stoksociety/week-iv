import com.google.gson.Gson;
import dao.*;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import static spark.Spark.*;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        String connectmetodatabase = "jdbc:postgresql://localhost:5432/news_api";
        Sql2o sql2o = new Sql2o(connectmetodatabase, "postgres", "none");

        String connectionString = "jdbc:postgresql://rvatryeenwrner:f0ca4fe146a5c27c5b83e1170f02bb67539dee2de24c281737fd8dbe0a4dacf6@ec2-44-195-191-252.compute-1.amazonaws.com:5432/dcc6gu6976h9mk";

        sql2o = new Sql2o(connectionString, "rvatryeenwrner", "f0ca4fe146a5c27c5b83e1170f02bb67539dee2de24c281737fd8dbe0a4dacf6");
        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        sql2oUserDao sql2oUserDao = new sql2oUserDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);
        Gson gson = new Gson();

        //Root Route
        get("/", (request, response) -> {
            return
                 "hey there";
        });

        //Add new Departments
        post("/departments/new", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            sql2oDepartmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });

        //Get all Departments
        get("/departments", (request, response) -> {
            return gson.toJson(sql2oDepartmentDao.getAllDeparts());
        });

        //Get departments by id;
        get("/departments/:id", (req, res) -> {
            int departId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oDepartmentDao.findById(departId));
        });

        //Create new USer
        post("/users/new", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.add(user);
            response.status(201);
            return gson.toJson(user);
        });

        //Get all Users
        get("/users", (req, res) -> {
            return gson.toJson(sql2oUserDao.getAllUsers());
        });

        //Get USers by id;
        get("/users/:id", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oUserDao.findById(userId));
        });

        //Get USers by department;
        get("/users/departments/:departId", (req, res) -> {
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(sql2oUserDao.findUsersByDepart(departId));
        });

        //Create News
        post("/news/new", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.add(news);
            response.status(201);


            return gson.toJson(news);
        });

        //Get all news
        get("/news", (req, res) -> {
            return gson.toJson(sql2oNewsDao.getAllNews());
        });

        //Get News by id;
        get("/news/:id", (req, res) -> {
            int newsId = Integer.parseInt(req.params("id"));
            return gson.toJson(sql2oNewsDao.findById(newsId));
        });

        //Get News by department;
        get("/news/departments/:departId", (req, res) -> {
            int departId = Integer.parseInt(req.params("departId"));
            return gson.toJson(sql2oNewsDao.findNewsByDepart(departId));
        });
        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
