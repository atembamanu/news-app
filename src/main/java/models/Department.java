package models;

import java.util.Objects;

public class Department {
    private String departmentName;
    private  String description;
    private int empNo;
    private  int id;

    public Department(String departmentName, String description, int empNo) {
        this.departmentName = departmentName;
        this.description = description;
        this.empNo = empNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getEmpNo() == that.getEmpNo() &&
                getId() == that.getId() &&
                getDepartmentName().equals(that.getDepartmentName()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentName(), getDescription(), getEmpNo(), getId());
    }
}
