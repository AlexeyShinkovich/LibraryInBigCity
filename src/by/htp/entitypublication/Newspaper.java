package by.htp.entitypublication;

import by.htp.author.Author;

public class Newspaper extends Book {

	public Newspaper(int year, String title) {
		super(year, new Author("Komsomolka-Minsk"), title);
	}

}
