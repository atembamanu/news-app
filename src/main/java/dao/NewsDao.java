package dao;

import models.News;

import java.util.List;

public interface NewsDao {
    void addNews(News news);
    List<News> getAllNews();
    List<News> getNewsByDept(String category);
    void deleteById(int id);
    void deleteByDept(String category);
    void deleteAllNews();

}
