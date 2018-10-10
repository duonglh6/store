package com.hp.service;

import java.util.ArrayList;
import java.util.List;

import com.hp.converter.BookConvert;
import com.hp.dao.BookDAO;
import com.hp.entity.BookEntity;
import com.hp.model.BookModel;

public class BookService {

	private static BookDAO bookDAO = new BookDAO();
	private static BookConvert bookConvert = new BookConvert();

	public List<BookModel> getListBook() throws Exception {
		List<BookEntity> list = bookDAO.findBook();
		List<BookModel> bookModels = new ArrayList<>();
		for (BookEntity item : list) {
			bookModels.add(bookConvert.entity2Dto(item));

		}
		return bookModels;
	}

	public BookModel findBookById(long id) throws Exception {
		BookEntity book = bookDAO.findBookById(id);
		return bookConvert.entity2Dto(book);
	}

	public int generateId() throws Exception {
		return bookDAO.generateId();
	}
	public void addBook(BookEntity book) throws Exception{
		bookDAO.addBook(book);
	}
	public void deleteBook(int id) throws Exception{
		bookDAO.deleteBook(id);
	}
}
