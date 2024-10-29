package ait.cohort46.book.service;

import ait.cohort46.book.dto.AuthorDto;
import ait.cohort46.book.dto.BookDto;

public interface BookService {
    Boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(String isbn);

    BookDto updateBookTitle(String isbn, String title);

    BookDto removeBook(String isbn);

    Iterable<BookDto> findBooksByAuthor(String author);

    Iterable<BookDto> findBooksByPublisher(String publisher);

    Iterable<AuthorDto> findBookAuthors(String isbn);

    Iterable<String> findPublishersByAuthor(String author);

    AuthorDto removeAuthor(String author);
}
