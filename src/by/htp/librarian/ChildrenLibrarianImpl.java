package by.htp.librarian;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import by.htp.entitylibrary.Library;
import by.htp.entitypublication.PrintedPublication;

public class ChildrenLibrarianImpl implements Librarian {
	private Set<Library> allChaildLibrary = new LinkedHashSet<Library>();

	@Override
	public void viewPublicationToLibraryType() {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.viewBook();
		}
	}

	@Override
	public void searchByTitle(String title) {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.searchBook(title);
		}
	}

	@Override
	public void searchByAuthorAndTitle(String... text) {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.searchBookByAuthorTitle(text);
		}
	}

	@Override
	public void sortPublicatiomsByTitle() {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.sortByTitle();
		}
	}

	@Override
	public void sortPublicationsByAll() {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.sortByAll();
		}
	}

	@Override
	public void addPublicatioms(PrintedPublication text) {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.addBook(text);
		}

	}

	@Override
	public void delPublicatioms(String title) {
		Iterator<Library> lib = allChaildLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.delBook(title);
		}
	}

	public void saveLibrary(Library lib) {
		allChaildLibrary.add(lib);
	}
}
