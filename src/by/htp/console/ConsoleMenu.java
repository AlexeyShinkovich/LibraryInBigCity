package by.htp.console;

import java.util.Scanner;

import by.htp.author.Author;
import by.htp.city.City;
import by.htp.entitylibrary.ChildrenLibrary;
import by.htp.entitylibrary.CityLibrary;
import by.htp.entitylibrary.ScientificLibrary;
import by.htp.entitypublication.Book;
import by.htp.entitypublication.ChildrenBook;
import by.htp.entitypublication.Magazine;
import by.htp.entitypublication.Newspaper;
import by.htp.entitypublication.ScientificWork;

public class ConsoleMenu {
	private int i;

	public void mainMenu() {

		 City minsk = new City();

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		minsk.addLibrary(new ChildrenLibrary("Gikalo", "Pushkina"));
		minsk.giveBookToLibrarian(new ChildrenBook(1950, new Author("Semen", "Petrov", 1919), "Azbuka"));
		minsk.addLibrary(new ScientificLibrary("Brovki,3", "BSUIR"));
		minsk.giveBookToLibrarian(new ScientificWork(1900, new Author("Dmitry", "Mendeleev", 1856), "Tablica"));
		minsk.addLibrary(new CityLibrary("Nezavisimosti, 116", "National"));
		minsk.giveBookToLibrarian(new Book(1980, new Author("Petr", "Ivanov", 1950), "In Minsk"));

		System.out.println(
				"1-Add  Library  2 - View All Library in City  3 - Add Book  4 - View Catalog Books in Library by ...  5 - Del Book ");
		System.out.println("6 - View publications by type library  7 - Sort by  Title  8 - Sort by Name, Author, Title"
				+ " 9 - Search by Title  10 - Search by Author,Title");
		do {
			System.out.println("Select method: ");
			int i = sc.nextInt();
			this.i = i;
			if (i >= 0 || i <= 10) {
				switch (i) {

				case 1:
					System.out.println("Select type Library: 1 - Children, 2 - Scientific, 3 - City");
					String a = sc1.nextLine();
					if (a.equals("1")) {
						System.out.println("Enter address:");
						String adress = sc1.nextLine();
						System.out.println("Enter Name:");
						String name = sc1.nextLine();
						minsk.addLibrary(new ChildrenLibrary(adress, name));

					} else if (a.equals("2")) {
						System.out.println("Enter address:");
						String adress = sc1.nextLine();
						System.out.println("Enter Name:");
						String name = sc1.nextLine();
						minsk.addLibrary(new ScientificLibrary(adress, name));

					} else if (a.equals("3")) {
						System.out.println("Enter address:");
						String adress = sc1.nextLine();
						System.out.println("Enter Name:");
						String name = sc1.nextLine();
						minsk.addLibrary(new CityLibrary(adress, name));
					}
					break;

				case 2:
					minsk.viewAllLib();
					break;
				case 3:
					System.out.println(
							"Chenge type book: 1 - Children, 2 - Scientific, 3 - Newspaper 4 - Book 5- Magazine");
					String type = sc1.nextLine();
					if (type.equals("1")) {
						System.out.println("Enter year");
						int year = sc.nextInt();
						System.out.println("Enter Author (Name, Surname, DateOfBirth):");
						String name = sc1.nextLine();
						String surname = sc1.nextLine();
						int yearPubl = sc.nextInt();
						System.out.println("Enter Title:");
						String title = sc1.nextLine();
						minsk.giveBookToLibrarian(new ChildrenBook(year, new Author(name, surname, yearPubl), title));

					} else if (type.equals("2")) {
						System.out.println("Enter year");
						int year = sc.nextInt();
						System.out.println("Enter Author (Name, Surname, DateOfBirth):");
						String name = sc1.nextLine();
						String surname = sc1.nextLine();
						int yearPubl = sc.nextInt();
						System.out.println("Enter Title:");
						String title = sc1.nextLine();
						minsk.giveBookToLibrarian(new ScientificWork(year, new Author(name, surname, yearPubl), title));

					} else if (type.equals("3")) {
						System.out.println("Enter year");
						int year = sc.nextInt();
						System.out.println("Enter Title:");
						String title = sc1.nextLine();
						minsk.giveBookToLibrarian(new Newspaper(year, title));

					} else if (type.equals("4")) {
						System.out.println("Enter year");
						int year = sc.nextInt();
						System.out.println("Enter Author (Name, Surname, DateOfBirth):");
						String name = sc1.nextLine();
						String surname = sc1.nextLine();
						int yearPubl = sc.nextInt();
						System.out.println("Enter Title:");
						String title = sc1.nextLine();
						minsk.giveBookToLibrarian(new Book(year, new Author(name, surname, yearPubl), title));

					} else if (type.equals("5")) {
						System.out.println("Enter year");
						int year = sc.nextInt();
						System.out.println("Enter Title:");
						String title = sc1.nextLine();
						minsk.giveBookToLibrarian(new Magazine(year, title));

					}
					break;

				case 4:
					System.out.println("Enter name library");
					String name = sc1.nextLine();
					minsk.viewCatalogBookToLibrary(name);
					break;

				case 5:
					System.out.println("Enter title:");
					String title = sc1.nextLine();
					minsk.delBook(title);
					break;

				case 6:
					System.out.println("Enter type Library: Children, Scientific, City");
					String typeLibrary = sc1.nextLine();
					minsk.viewPublication(typeLibrary);
					break;

				case 7:
					System.out.println("Enter type Library: Children, Scientific, City");
					String typeLib = sc1.nextLine();
					minsk.sortByTitle(typeLib);
					break;

				case 8:
					System.out.println("Enter type Library: Children, Scientific, City");
					String sortByAllInLib = sc1.nextLine();
					minsk.sortAll(sortByAllInLib);
					break;

				case 9:
					System.out.println("Enter title book for search");
					String searchTitle = sc1.nextLine();
					minsk.findBook(searchTitle);
					break;

				case 10:
					System.out.println("Enter Author and Title book for search    Example: Shekspir,Gamlet");
					String searchAuthorTitle = sc1.nextLine();
					minsk.findBookByAuthorTitle(searchAuthorTitle.split(","));
					break;
				}
			} else {
				continue;
			}
		} while (i != 0);
	}
}
