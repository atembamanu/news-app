package models.dao;

import dao.Sql2oDepartmentDao;
import db.Credentials;
import models.Department;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {

    private static Connection conn;
    private static Sql2oDepartmentDao sql2oDepartmentDao;

    @Before
    public  void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organizational_api_test";
        Sql2o sql2o = new Sql2o(connectionString, Credentials.username, Credentials.pass);
        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public  void tearDown() throws Exception {
        sql2oDepartmentDao.deleteAllDepartments();
    }

    @AfterClass
    public  static void shutDown() {
        conn.close();
    }
    public Department setupDepartment() {
        Department department = new Department("Sales", "Organisational Sales", 12);
        sql2oDepartmentDao.addDepartment(department);
        return department;
    }

    @Test
    public void addingDepartment_setsId() {
        Department department = setupDepartment();
        assertEquals(1, department.getId());
    }

    @Test
    public void getDepartment_getsAllDepartments() {
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(2, sql2oDepartmentDao.getAllDepartments().size());

    }

    @Test
    public void DeleteById_deletesSelectedRecord() {
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(2, sql2oDepartmentDao.getAllDepartments().size());
        sql2oDepartmentDao.deleteById(department.getId());
        assertEquals(1, sql2oDepartmentDao.getAllDepartments().size());
    }

    @Test
    public void deleteAll_deletesAllDepartments() {
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(2, sql2oDepartmentDao.getAllDepartments().size());
        sql2oDepartmentDao.deleteAllDepartments();
        assertEquals(0, sql2oDepartmentDao.getAllDepartments().size());
    }
}