package ait.cohort46.book.dao;

import ait.cohort46.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, String> {
    Stream<Book> findByAuthorsNameIgnoreCase(String author);

    Stream<Book> findByPublisherPublisherNameIgnoreCase(String publisher);

    void deleteByAuthorsNameIgnoreCase(String author);
}
