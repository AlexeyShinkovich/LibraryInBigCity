package by.htp.entitypublication;

import by.htp.author.Author;

public class Magazine extends Book {

	public Magazine(int year, String title) {
		super(year, new Author("Ogonek-Moscow"), title);
	}

}
