package dao;

import models.Department;
import models.User;

import java.util.List;

public interface DepartmentDao {

    void addDepartment(Department user);
    List<Department> getAllDepartments();
    List<Department> getDepartmentById(int id);
    void deleteById(int id);
    void deleteAllDepartments();
}
