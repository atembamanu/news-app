package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public  void  getFirstName_returnsCorrectFirstName(){
        User user = setupUser();
        assertEquals("Emmanuel", user.getFirstName());

    }

    @Test
    public void getSecondName_returnsCorrectSecondName() {
        User user = setupUser();
        assertEquals("Atemba", user.getSecondName());

    }

    @Test
    public  void  getEmail_returnsCorrectEmail(){
        User user = setupUser();
        assertEquals("atembaemm07@gmail.com", user.getEmail());

    }

    @Test
    public void getPosition_returnsCorrectPosition() {
        User user = setupUser();
        assertEquals("CEO", user.getPosition());

    }
    @Test
    public  void  getRole_returnsCorrectRole(){
        User user = setupUser();
        assertEquals("Making major corporate decisions", user.getRole());

    }

    @Test
    public void getDepartmentId_returnsCorrectDepartment() {
        User user = setupUser();
        assertEquals(1, user.getDepartment_id());

    }


    public User setupUser(){
        return  new User("Emmanuel", "Atemba", "atembaemm07@gmail.com", "CEO", "Making major corporate decisions", 1);
    }

}