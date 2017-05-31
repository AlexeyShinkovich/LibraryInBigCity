package by.htp.entitylibrary;

import by.htp.entitypublication.PrintedPublication;

public abstract class Library {
	private LibraryType libraryType;
	private String address;
	private String name;

	public Library(LibraryType type, String address, String name) {
		super();
		this.libraryType = type;
		this.address = address;
		this.name = name;
	}

	public LibraryType getLibraryType() {
		return libraryType;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public abstract void addBook(PrintedPublication book);

	public abstract void viewBook();

	public abstract void delBook(String text);

	@Override
	public String toString() {
		return "Type - " + libraryType + ", Address - " + address + ", Name - " + name;
	}

	public abstract void searchBook(String title);

	public abstract void searchBookByAuthorTitle(String... title);

	public abstract void sortByTitle();

	public abstract void sortByAll();

}
