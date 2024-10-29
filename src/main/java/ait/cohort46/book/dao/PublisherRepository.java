package ait.cohort46.book.dao;

import ait.cohort46.book.model.Book;
import ait.cohort46.book.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
