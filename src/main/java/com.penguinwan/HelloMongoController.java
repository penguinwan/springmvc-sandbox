package com.penguinwan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book", consumes = "application/json", produces = "application/json")
public class HelloMongoController {

    @Autowired
    protected BookRepository bookRepository;


    @PostMapping(path = "/{title}")
    public ResponseEntity post(@PathVariable String title) {
        Book book = new Book();
        book.setTitle(title);
        bookRepository.save(book);
        return ResponseEntity.ok(jsonOf(book));
    }

    private String jsonOf(Book book) {
        String format = "{\"id\":\"%s\", \"title\":\"%s\"}";
        return String.format(format, book.getId(), book.getTitle());
    }
}
