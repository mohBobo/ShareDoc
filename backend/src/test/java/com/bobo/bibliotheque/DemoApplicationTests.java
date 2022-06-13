package com.bobo.bibliotheque;

import com.bobo.bibliotheque.controller.BookController;
import com.bobo.bibliotheque.entities.Book;
import com.bobo.bibliotheque.entities.Category;
import com.bobo.bibliotheque.enumerer.BookStatus;
import com.bobo.bibliotheque.essaie.Calculator;
import com.bobo.bibliotheque.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookStatus bookStatus;

	@Autowired
	private BookController bookController;
/*
	@Test
	void contextLoads() {

		//Optional<Book> metTest = Book.builder()
//				//.title(.random(5))
//				//.category(getClass())
//				.user(getClass())
//				.status(BookStatus.BORROWED)
//				.build();
	}*/


	@Test
	void testAddTwoPositiveNumbers() {
		// ARRANGE
		int a = 2;
		int b = 3;
		Calculator calculator = new Calculator();

		// ACT
		int somme =  calculator.add(a, b);

		// ASSERT
		Assertions.assertEquals(5, somme);
	}

/*	@Test
	void setBookController() {

	}*/
/*
	@Test
	void findByStatusAndUserIdNotAndDeletedFalseBookRepositoryTest() {
//		// ARRANGE
//		Map<String, Integer> statut = new HashMap<>();
//
//		// ACT
//		List<Book> response = bookRepository.findByStatusAndUserIdNotAndDeletedFalse(BookStatus.BORROWED, 1);
//
//		// ASSERT
//		Assertions.assertSame(bookStatus.BORROWED, response);
	}*/

}
