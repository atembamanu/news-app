package models.dao;

import dao.NewsDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import db.Credentials;
import models.News;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;
public class Sql2oNewsDaoTest {

    private static Connection conn;
    private static Sql2oNewsDao sql2oNewsDao;


    @Before
    public  void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organizational_api_test";
        Sql2o sql2o = new Sql2o(connectionString, Credentials.username, Credentials.pass);
        sql2oNewsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public  void tearDown() throws Exception {
        sql2oNewsDao.deleteAllNews();
    }

    @AfterClass
    public  static void shutDown() {
        conn.close();
    }
    @Test
    public void getAllNews_returnsAllNews() {
        News news = setupNews();
        News news1 = setupNews();
        assertEquals(2, sql2oNewsDao.getAllNews().size());
    }

    @Test
    public void addingNewsSetsId() {
        News news = setupNews();
        assertEquals(1, news.getId());
    }

    @Test
    public void getNewsByDept_returnsNewsInThatDept() {
        News news = setupNews();
        News news1 = setupNews2();
        News news2 = setupNews3();
        assertEquals(3, sql2oNewsDao.getAllNews().size());
        assertEquals(2, sql2oNewsDao.getNewsByDept("Sales").size());

    }

    @Test
    public void deleteById_deletesTheSelectedNews() {
        News news = setupNews();
        News news1 = setupNews2();
        assertEquals(2, sql2oNewsDao.getAllNews().size());
        sql2oNewsDao.deleteById(news.getId());
        assertEquals(1, sql2oNewsDao.getAllNews().size());
    }

    @Test
    public void deleteByDept_deletesSelectedNews() {
        News news = setupNews();
        News news1 = setupNews2();
        News news2 = setupNews3();
        assertEquals(3, sql2oNewsDao.getAllNews().size());
        sql2oNewsDao.deleteByDept("Sales");
        assertEquals(1, sql2oNewsDao.getAllNews().size());
    }

    @Test
    public void deleteAll_deletesAllNews() {
        News news = setupNews();
        News news1 = setupNews2();
        News news2 = setupNews3();
        assertEquals(3, sql2oNewsDao.getAllNews().size());
        sql2oNewsDao.deleteAllNews();
        assertEquals(0, sql2oNewsDao.getAllNews().size());
    }

    public News setupNews(){
        News news = new News("Meeting", "There will be a meeting at 4PM", "General");
        sql2oNewsDao.addNews(news);
        return  news;

    }
    public News setupNews2(){
        News news2 = new News("Workshop", "There will be a workshop soon", "Sales");
        sql2oNewsDao.addNews(news2);
        return  news2;
    }
    public News setupNews3(){
        News news2 = new News("Tour", "There will be a tour soon", "Sales");
        sql2oNewsDao.addNews(news2);
        return  news2;
    }


}