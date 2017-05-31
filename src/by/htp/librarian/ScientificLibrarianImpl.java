package by.htp.librarian;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import by.htp.entitylibrary.Library;
import by.htp.entitypublication.PrintedPublication;

public class ScientificLibrarianImpl implements Librarian {
	private Set<Library> scientificLibrary = new TreeSet<Library>();

	@Override
	public void viewPublicationToLibraryType() {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.viewBook();
		}
	}

	@Override
	public void searchByTitle(String title) {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.searchBook(title);
		}
	}

	@Override
	public void sortPublicatiomsByTitle() {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.sortByTitle();
		}
	}

	public void sortPublicationsByAll() {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.sortByAll();
		}
	}

	@Override
	public void addPublicatioms(PrintedPublication text) {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.addBook(text);
		}
	}

	@Override
	public void delPublicatioms(String title) {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.delBook(title);
		}
	}

	public void saveLibrary(Library lib) {
		scientificLibrary.add(lib);
	}

	@Override
	public void searchByAuthorAndTitle(String... text) {
		Iterator<Library> lib = scientificLibrary.iterator();
		while (lib.hasNext()) {
			Library a = lib.next();
			a.searchBookByAuthorTitle(text);
		}
	}
}
