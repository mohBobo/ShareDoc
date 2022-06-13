package com.bobo.bibliotheque;

import com.bobo.bibliotheque.enumerer.BookStatus;
import com.bobo.bibliotheque.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void should_not_throw_exception_when_find_book_by_id() {
        assertDoesNotThrow(() -> {
            bookRepository.findById(Integer.valueOf(10));
        });
    }

    @Test
    void should_not_throw_exception_when_find_by_status_and_user_id_not_and_deleted_false() {
        assertDoesNotThrow(() ->
            { bookRepository.findByStatusAndUserIdNotAndDeletedFalse(BookStatus.FREE, Integer.valueOf(1));
        });
    }

    @Test
    void should_not_throw_exception_when_find_all() {
        assertDoesNotThrow(() -> {
            bookRepository.findAll();
        });
    }
}
