package com.hp.converter;

import com.hp.entity.BookEntity;
import com.hp.model.BookModel;

public class BookConvert {
	CategoryConvert categoy = new CategoryConvert();

	public BookEntity dto2Entity(BookModel bookModel) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setId(bookModel.getId());
		bookEntity.setName(bookModel.getName());
		bookEntity.setPrice(bookModel.getPrice());
		bookEntity.setSoldNumber(bookModel.getSoldNumber());
		bookEntity.setCategory(categoy.dto2Entity(bookModel.getCategory()));
		return bookEntity;
	}

	public BookModel entity2Dto(BookEntity bookEntity) {
		BookModel bookModel = new BookModel();
		bookModel.setId(bookEntity.getId());
		bookModel.setName(bookEntity.getName());
		bookModel.setPrice(bookEntity.getPrice());
		bookModel.setSoldNumber(bookEntity.getSoldNumber());
		bookModel.setCategory(categoy.entity2Dto(bookEntity.getCategory()));
		return bookModel;
	}

}
