package by.htp.librarian;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import by.htp.entitylibrary.Library;
import by.htp.entitypublication.PrintedPublication;

public class CityLibrarianImpl implements Librarian {

	private Queue<Library> cityLibrary = new PriorityQueue<Library>();

	@Override
	public void viewPublicationToLibraryType() {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.viewBook();
		}

	}

	@Override
	public void searchByTitle(String title) {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.searchBook(title);
		}
	}

	@Override
	public void searchByAuthorAndTitle(String... text) {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.searchBookByAuthorTitle(text);
		}
	}

	@Override
	public void sortPublicatiomsByTitle() {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.sortByTitle();
		}
	}

	@Override
	public void sortPublicationsByAll() {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.sortByAll();
		}
	}

	@Override
	public void addPublicatioms(PrintedPublication text) {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.addBook(text);
		}
	}

	@Override
	public void delPublicatioms(String title) {
		Iterator<Library> lib = cityLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.delBook(title);
		}
	}

	public void saveLibrary(Library lib) {
		cityLibrary.add(lib);
	}
}
