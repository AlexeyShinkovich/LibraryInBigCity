package by.htp.city;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.htp.entitylibrary.Library;
import by.htp.entitylibrary.LibraryType;
import by.htp.entitypublication.Book;
import by.htp.entitypublication.ChildrenBook;
import by.htp.entitypublication.PrintedPublication;
import by.htp.entitypublication.ScientificWork;
import by.htp.librarian.ChildrenLibrarianImpl;
import by.htp.librarian.CityLibrarianImpl;
import by.htp.librarian.ScientificLibrarianImpl;

public class City {

	private Map<LibraryType, ArrayList<Library>> allLibraryInCity = new HashMap<LibraryType, ArrayList<Library>>();
	private ChildrenLibrarianImpl childLibrarian = new ChildrenLibrarianImpl();
	private ScientificLibrarianImpl scientificLibrarian = new ScientificLibrarianImpl();
	private CityLibrarianImpl cityLibrarian = new CityLibrarianImpl();

	public void addLibrary(Library library) {
		ArrayList<Library> allLibrary = allLibraryInCity.get(library.getLibraryType());
		if (null == allLibrary) {
			allLibrary = new ArrayList<Library>();
			allLibrary.add(library);
			allLibraryInCity.put(library.getLibraryType(), allLibrary);
		} else {
			allLibrary.add(library);
			allLibraryInCity.put(library.getLibraryType(), allLibrary);
		}
		giveLibraryToLibrarian(library);
	}

	public void viewAllLib() {
		for (Entry<LibraryType, ArrayList<Library>> entry : allLibraryInCity.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public void delBook(String text) {
		childLibrarian.delPublicatioms(text);
		cityLibrarian.delPublicatioms(text);
		scientificLibrarian.delPublicatioms(text);

	}

	public void findBook(String text) {
		childLibrarian.searchByTitle(text);
		cityLibrarian.searchByTitle(text);
		scientificLibrarian.searchByTitle(text);

	}

	public void findBookByAuthorTitle(String... text) {
		childLibrarian.searchByAuthorAndTitle(text);
		cityLibrarian.searchByAuthorAndTitle(text);
		scientificLibrarian.searchByAuthorAndTitle(text);

	}

	public void viewCatalogBookToLibrary(String type) {
		for (Entry<LibraryType, ArrayList<Library>> mapEntry : allLibraryInCity.entrySet()) {
			ArrayList<Library> lib = mapEntry.getValue();
			for (Library library : lib) {
				if (library.getName().equals(type)) {
					library.viewBook();
				}
			}
		}
	}

	private void giveLibraryToLibrarian(Library library) {
		if (library.getLibraryType() == LibraryType.CHILDREN) {
			childLibrarian.saveLibrary(library);
		} else if (library.getLibraryType() == LibraryType.SCIENTIFIC) {
			scientificLibrarian.saveLibrary(library);
		} else if (library.getLibraryType() == LibraryType.CITY) {
			cityLibrarian.saveLibrary(library);
		}
	}

	public void giveBookToLibrarian(PrintedPublication text) {
		if (text instanceof ChildrenBook) {
			childLibrarian.addPublicatioms(text);
		} else if (text instanceof ScientificWork) {
			scientificLibrarian.addPublicatioms(text);
		} else if (text instanceof Book) {
			cityLibrarian.addPublicatioms(text);
		}

	}

	public void viewPublication(String type) {
		if (type.equals("Children")) {
			childLibrarian.viewPublicationToLibraryType();
		} else if (type.equals("Scientific")) {
			scientificLibrarian.viewPublicationToLibraryType();
		} else if (type.equals("City")) {
			cityLibrarian.viewPublicationToLibraryType();
		}
	}

	public void sortByTitle(String type) {
		if (type.equals("Children")) {
			childLibrarian.sortPublicatiomsByTitle();
		} else if (type.equals("Scientific")) {
			scientificLibrarian.sortPublicatiomsByTitle();
		} else if (type.equals("City")) {
			cityLibrarian.sortPublicatiomsByTitle();
		}
	}

	public void sortAll(String type) {
		if (type.equals("Children")) {
			childLibrarian.sortPublicationsByAll();
		} else if (type.equals("Scientific")) {
			scientificLibrarian.sortPublicationsByAll();
		} else if (type.equals("City")) {
			cityLibrarian.sortPublicationsByAll();
		}
	}
}
