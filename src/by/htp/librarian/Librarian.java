package by.htp.librarian;

import by.htp.entitypublication.PrintedPublication;

public interface Librarian {
	public void viewPublicationToLibraryType();

	public void searchByTitle(String text);

	public void searchByAuthorAndTitle(String... text);

	public void sortPublicatiomsByTitle();

	public void addPublicatioms(PrintedPublication text);

	public void delPublicatioms(String text);

	public void sortPublicationsByAll();

}
