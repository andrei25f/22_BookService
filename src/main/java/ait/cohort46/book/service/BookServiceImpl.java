package ait.cohort46.book.service;

import ait.cohort46.book.dao.AuthorRepository;
import ait.cohort46.book.dao.BookRepository;
import ait.cohort46.book.dao.PublisherRepository;
import ait.cohort46.book.dto.AuthorDto;
import ait.cohort46.book.dto.BookDto;
import ait.cohort46.book.dto.exception.EntityNotFoundException;
import ait.cohort46.book.model.Author;
import ait.cohort46.book.model.Book;
import ait.cohort46.book.model.Publisher;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public Boolean addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) {
            return false;
        }

        Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
                .orElse(publisherRepository.save(new Publisher(bookDto.getPublisher())));

        Set<Author> authors = bookDto.getAuthors().stream()
                .map(a -> authorRepository.findById(a.getName())
                        .orElse(authorRepository.save(new Author(a.getName(), a.getBirthDate()))))
                .collect(Collectors.toSet());

        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
        bookRepository.save(book);
        return true;
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookDto updateBookTitle(String isbn, String title) {
        return null;
    }

    @Override
    public BookDto removeBook(String isbn) {
        return null;
    }

    @Override
    public Iterable<BookDto> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    public Iterable<BookDto> findBooksByPublisher(String publisher) {
        return null;
    }

    @Override
    public Iterable<AuthorDto> findBookAuthors(String isbn) {
        return null;
    }

    @Override
    public Iterable<String> findPublishersByAuthor(String author) {
        return null;
    }

    @Override
    public AuthorDto removeAuthor(String author) {
        return null;
    }
}
