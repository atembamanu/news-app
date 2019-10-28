package models;

import java.util.Objects;

public class Department {
    private String name;
    private  String description;
    private int empNo;
    private  int id;

    public Department(String name, String description, int empNo) {
        this.name = name;
        this.description = description;
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setDepartmentName(String Name) {
        this.name = Name;
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
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getEmpNo(), getId());
    }
}
