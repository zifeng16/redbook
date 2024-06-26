package com.chuwa.chuwa.controller;

import com.chuwa.chuwa.payload.AuthorDto;
import com.chuwa.chuwa.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto response = authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@RequestBody AuthorDto authorDto, @PathVariable(name = "id") long id) {
        AuthorDto authorResponse = authorService.updateAuthor(authorDto, id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(name = "id") long id) {
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Author entity deleted successfully.", HttpStatus.OK);
    }
}
