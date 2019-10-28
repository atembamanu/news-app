package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Test
    public  void getTitle_returnsCorrectTitle(){
        News news = setupNews();
        assertEquals("Meeting", news.getTitle());

    }
    @Test
    public  void getContent_returnsCorrectContent(){
        News news = setupNews();
        assertEquals("There will be a board meeting today", news.getContent());

    }
    @Test
    public  void getCategory_returnsCorrectCategory(){
        News news = setupNews();
        assertEquals("Managerial", news.getCategory());

    }

    public  News setupNews(){
        return  new News("Meeting", "There will be a board meeting today", "Managerial");
    }


}