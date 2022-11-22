package vttp2022.day21.day21.Repository;

public class Queries {
    public static final String SQL_SELECT_BOOKS_BY_RATING = "SELECT book_id,title,description,rating,image_url FROM book2018 WHERE rating >= ? ORDER BY TITLE";
    
    public static final String SQL_SELECT_BOOKS_BY_TITLESEARCH = "SELECT book_id,title,description,rating,image_url FROM book2018 WHERE title LIKE CONCAT('%', ?, '%') ORDER BY TITLE LIMIT ?";
    
}