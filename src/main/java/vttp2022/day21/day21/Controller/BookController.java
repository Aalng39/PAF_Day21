package vttp2022.day21.day21.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.day21.day21.Models.Book;
import vttp2022.day21.day21.Repository.BookRepository;

@Controller
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepo;
    
    @GetMapping("/")
    public String search(Model model){
        List<Integer> limits = new ArrayList<>(Arrays.asList(5, 10, 15, 20));

        for (int limit : limits)
        logger.info(Integer.toString(limit));

        model.addAttribute("books", new Book());
        model.addAttribute("limits", limits);
        return "booksearchpage";
    }
    
    @GetMapping("/search")
    public String results(@RequestParam String query, @RequestParam int limit, Model model){

        List<Book> books = bookRepo.getBooksByTitleSearch(query, limit);
        
        model.addAttribute("query", query);   
        model.addAttribute("limit", books.size());
        model.addAttribute("book", books);
        model.addAttribute("hasResults", books.size() > 0);
        return "resultpage";

    }

}
