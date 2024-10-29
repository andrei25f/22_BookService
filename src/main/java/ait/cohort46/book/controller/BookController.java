package ait.cohort46.book.controller;

import ait.cohort46.book.dto.AuthorDto;
import ait.cohort46.book.dto.BookDto;
import ait.cohort46.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public Boolean addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findPersonById(@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @PatchMapping("/book/{isbn}/title/{title}")
    public BookDto updateBookTitle(@PathVariable String isbn, @PathVariable String title) {
        return bookService.updateBookTitle(isbn, title);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto removeBook(@PathVariable String isbn) {
        return bookService.removeBook(isbn);
    }

    @GetMapping("/books/author/{author}")
    public Iterable<BookDto> findBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/books/publisher/{publisher}")
    public Iterable<BookDto> findBooksByPublisher(@PathVariable String publisher) {
        return bookService.findBooksByPublisher(publisher);
    }

    @GetMapping("/authors/book/{isbn}")
    public Iterable<AuthorDto> findBookAuthors(@PathVariable String isbn) {
        return bookService.findBookAuthors(isbn);
    }

    @GetMapping("/publishers/author/{author}")
    public Iterable<String> findPublishersByAuthor(@PathVariable String author) {
        return bookService.findPublishersByAuthor(author);
    }

    @DeleteMapping("/author/{author}")
    public AuthorDto removeAuthor(@PathVariable String author) {
        return bookService.removeAuthor(author);
    }
}
