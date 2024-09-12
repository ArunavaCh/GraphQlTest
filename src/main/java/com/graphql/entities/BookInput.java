package com.graphql.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookInput {
	private Integer bookId;
	private String bookTitle;
	private String bookAuthor;
	private double bookPrice;
	private int bookPages;
}
