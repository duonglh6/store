package com.hp.service;

import com.hp.dao.AuthorBookDAO;
import com.hp.entity.AuthorBookEntity;

public class AuthorBookService {
	public static AuthorBookDAO authorBook = new AuthorBookDAO();

	public int generateId() throws Exception {
		return authorBook.generateId();
	}
	public void deleteByBookId(int id) throws Exception{
		authorBook.deleteById(id);
	}
	public void addAuthorBook(AuthorBookEntity authorBook) throws Exception{
		AuthorBookService.authorBook.addNewAuthorBook(authorBook);
	}
	
}
