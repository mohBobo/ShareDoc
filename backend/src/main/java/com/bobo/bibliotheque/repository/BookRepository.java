package com.bobo.bibliotheque.repository;

import com.bobo.bibliotheque.enumerer.BookStatus;
import com.bobo.bibliotheque.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByStatusAndUserIdNotAndDeletedFalse(BookStatus status, Integer userId);
    List<Book> findByUserIdAndDeletedFalse(Integer userId);
}
