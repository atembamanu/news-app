package models;

import java.util.Objects;

public class User {
    private  int id;
    private String firstName;
    private String secondName;
    private String email;
    private String position;
    private String role;
    private int department_id;

    public User(String firstName, String secondName, String email, String position, String role, int department_id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.position = position;
        this.role = role;
        this.department_id = department_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getDepartment_id() == user.getDepartment_id() &&
                getFirstName().equals(user.getFirstName()) &&
                getSecondName().equals(user.getSecondName()) &&
                getEmail().equals(user.getEmail()) &&
                getPosition().equals(user.getPosition()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getSecondName(), getEmail(), getPosition(), getRole(), getDepartment_id());
    }
}
