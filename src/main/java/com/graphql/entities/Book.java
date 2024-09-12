package com.graphql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookId;
	private String bookTitle;
	private String bookAuthor;
	private double bookPrice;
	private int bookPages;
}
