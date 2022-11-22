package vttp2022.day21.day21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import vttp2022.day21.day21.Models.Book;
import vttp2022.day21.day21.Repository.BookRepository;

@RestController
@RequestMapping(path = "/api/rating",
                produces = MediaType.APPLICATION_JSON_VALUE)
public class BookRESTController {

    @Autowired
    private BookRepository bookRepo;
    
    @GetMapping(path = "{rating}")
    public ResponseEntity<String> getRating(@PathVariable Float rating){
        
        List<Book> books = bookRepo.getBooksByRating(rating);
        
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Book b : books)
            arrBuilder.add(b.toJSON());
        JsonArray result = arrBuilder.build();

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());
    }
}