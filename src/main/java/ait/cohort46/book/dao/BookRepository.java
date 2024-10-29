package ait.cohort46.book.dao;

import ait.cohort46.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
