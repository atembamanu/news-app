package models;

import java.util.Objects;

public class News {
    private String title;
    private String content;
    private String Category;

    public News(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.Category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getTitle().equals(news.getTitle()) &&
                getContent().equals(news.getContent()) &&
                getCategory().equals(news.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getContent(), getCategory());
    }
}
