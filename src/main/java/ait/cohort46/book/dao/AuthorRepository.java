package ait.cohort46.book.dao;

import ait.cohort46.book.model.Author;
import ait.cohort46.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
