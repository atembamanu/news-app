import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import db.Credentials;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import exceptions.ApiException;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao sql2oDepartmentDao;
        Sql2oNewsDao sql2oNewsDao;
        Sql2oUserDao sql2oUserDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/organizational_api";
        Sql2o sql2o = new Sql2o(connectionString, Credentials.username, Credentials.pass);

        sql2oUserDao = new Sql2oUserDao(sql2o);
        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        sql2oNewsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        //GET USERS
        get("/users", "application/json", (req, res) -> {
            System.out.println(sql2oUserDao.getAllUsers());
            System.out.println("Your data"+ sql2oUserDao.getAllUsers());
            if(sql2oUserDao.getAllUsers().size() > 0){
                return gson.toJson(sql2oUserDao.getAllUsers());
            }
            else {
                return "{\"message\":\"I'm sorry, but no users are currently listed in the database.\"}";
            }
        });

        //GET VIEW SPECIFIC USER
        get("/users/:id", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            System.out.println(sql2oUserDao.getUserById(userId));
            if(sql2oUserDao.getUserById(userId).size() > 0){
                return gson.toJson(sql2oUserDao.getUserById(userId));
            }
            else {
                return "{\"message\":\"I'm sorry, but no such user currently listed in the database.\"}";
            }
        });
        //GET VIEW SPECIFIC DEPARTMENT
        get("/departments/:id", "application/json", (req, res) -> {
            int deptId = Integer.parseInt(req.params("id"));
            System.out.println(sql2oDepartmentDao.getDepartmentById(deptId));
            if(sql2oDepartmentDao.getDepartmentById(deptId).size() > 0){
                return gson.toJson(sql2oDepartmentDao.getDepartmentById(deptId));
            }
            else {
                return "{\"message\":\"I'm sorry, but no department user currently listed in the database.\"}";
            }
        });
        //GET VIEW SPECIFIC NEWS
        get("/departments/:category", "application/json", (req, res) -> {
            String category = req.params("category");
            System.out.println(sql2oNewsDao.getNewsByDept(category));
            if(sql2oNewsDao.getNewsByDept(category).size() > 0){
                return gson.toJson(sql2oNewsDao.getNewsByDept(category));
            }
            else {
                return "{\"message\":\"I'm sorry, but no such news currently listed in the database.\"}";
            }
        });
        //GET Departments
        get("/departments", "application/json", (req, res) -> {
            System.out.println(sql2oDepartmentDao.getAllDepartments());
            if(sql2oDepartmentDao.getAllDepartments().size() > 0){
                return gson.toJson(sql2oDepartmentDao.getAllDepartments());
            }
            else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }
        });

        //GET news
        get("/news", "application/json", (req, res) -> {
            System.out.println(sql2oNewsDao.getAllNews());
            if(sql2oNewsDao.getAllNews().size() > 0){
                return gson.toJson(sql2oNewsDao.getAllNews());
            }
            else {
                return "{\"message\":\"I'm sorry, but no news are currently listed in the database.\"}";
            }
        });

        //CREATE USER
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            sql2oUserDao.addUser(user);
            res.status(201);
            return gson.toJson(user);
        });

        exception(ApiException.class, (exception, req, res) -> {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", exception.getStatusCode());
            jsonMap.put("errorMessage", exception.getMessage());
            res.type("application/json");
            res.status(exception.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) -> res.type("application/json"));
    }
}
