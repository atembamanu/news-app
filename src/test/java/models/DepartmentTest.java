package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public  void getDepartmentName_returnsCorrectDepartmentName(){
        Department department = setupDepartment();
        assertEquals("Managerial", department.getDepartmentName());

    }
    @Test
    public  void getDescription_returnsCorrectDescription(){
        Department department = setupDepartment();
        assertEquals("Organisations' decision making body", department.getDescription());

    }
    @Test
    public  void getEmpNo_returnsCorrectEmpNo(){
        Department department = setupDepartment();
        assertEquals(23, department.getEmpNo());

    }

    public  Department setupDepartment(){
        return  new Department("Managerial", "Organisations' decision making body", 23);
    }

}