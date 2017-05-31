package by.htp.entitypublication;

import by.htp.author.Author;

public abstract class PrintedPublication {

	private int year;
	private Author author;
	private String title;

	public PrintedPublication(int year, Author author, String title) {
		super();
		this.year = year;
		this.author = author;
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public Author getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "YEAR - " + year + ", AUTHOR - " + author + ", TITLE - " + title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintedPublication other = (PrintedPublication) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
