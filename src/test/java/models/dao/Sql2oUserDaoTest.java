package models.dao;

import dao.Sql2oDepartmentDao;
import dao.Sql2oUserDao;
import models.Department;
import models.User;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;

public class Sql2oUserDaoTest {

    private static Connection conn;
    private  static Sql2oUserDao sql2oUserDao;
    private static Sql2oDepartmentDao sql2oDepartmentDao;

    @Before
    public  void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/organizational_api_test";
//        Sql2o sql2o = new Sql2o(connectionString, "postgres", "Atemba254!");
//        sql2oUserDao = new Sql2oUserDao(sql2o);
//        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
//        conn = sql2o.open();

        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        sql2oUserDao = new Sql2oUserDao(sql2o);
        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public  void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void getAllUsers() throws Exception {
        User user = setupUser();
        User user1 = setupUser();
        assertEquals(2, sql2oUserDao.getAllUsers().size());
    }

    @Test
    public void addingUserSetsId_id() {
        User user = setupUser();
        assertEquals(1, user.getId());
    }

    @Test
    public void deleteById_deletesUserById() {
        User user = setupUser();
        User user1 = setupUser();
        assertEquals(2, sql2oUserDao.getAllUsers().size());
        sql2oUserDao.deleteById(user.getId());
       assertEquals(1, sql2oUserDao.getAllUsers().size());

    }

    @Test
    public void deleteAllUsers_deletesAllRecordsInUsersTable() {
        User user = setupUser();
        User user1 = setupUser();
        assertEquals(2, sql2oUserDao.getAllUsers().size());
        sql2oUserDao.deleteAllUsers();
        assertEquals(0, sql2oUserDao.getAllUsers().size());
    }

    public Department setupDepartment() {
        Department department = new Department("Sales", "Organisational Sales", 12);
        sql2oDepartmentDao.addDepartment(department);
        return department;

    }

    public User setupUser() {
        Department department = setupDepartment();
        int deptId = department.getId();
        User user = new User("Fish", "Broadway", "atembaemm07@gmail.com", "Manager", "Making Decisions", deptId);
        sql2oUserDao.addUser(user);
        return user;
    }

}