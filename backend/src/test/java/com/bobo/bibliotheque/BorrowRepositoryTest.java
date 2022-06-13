package com.bobo.bibliotheque;

import com.bobo.bibliotheque.repository.BorrowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DataJpaTest
@DirtiesContext
//@SpringBootTest
public class BorrowRepositoryTest {

    @Autowired
    BorrowRepository borrowRepository;

    @Test
    void should_not_throw_exception_when_find_by_book_id() {
        assertDoesNotThrow(() -> {
            borrowRepository.findByBookId(Integer.valueOf(1));
        });
    }
}
