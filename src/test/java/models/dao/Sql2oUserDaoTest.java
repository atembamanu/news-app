package models.dao;

import dao.Sql2oDepartmentDao;
import dao.Sql2oUserDao;
import org.junit.BeforeClass;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oUserDaoTest {

    private static Connection conn;
    private  static Sql2oUserDao sql2oUserDao;
    private static Sql2oDepartmentDao sql2oDepartmentDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organizational_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "Atemba254!");
        sql2oUserDao = new Sql2oUserDao(sql2o);
        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

}