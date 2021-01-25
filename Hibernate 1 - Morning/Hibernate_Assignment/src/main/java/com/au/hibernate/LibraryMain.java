package com.au.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class LibraryMain {
	
	private static SessionFactory factory;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		LibraryMain libraryMain = new LibraryMain();
		
		//uncomment for adding the books
//		libraryMain.addBook("Grimus", "Salman Rushdie", "Victor Gollanz");
//		libraryMain.addBook("Revolution 2020", "Chetan Bhagat", "Rupa Publications");
//		libraryMain.addBook("A Thousand Spendid Suns", "Khaled Hosseini", "Riverhead Books");
//		libraryMain.addBook("The Kite Runner", "Khaled Hosseini", "Riverhead Books");
//		libraryMain.addBook("Shalimar The Clown", "Salman Rushdie", "Jonathan Cape");
//		
//		libraryMain.getBooks();//uncomment to get all books
//		libraryMain.updateBookByID(3);//uncomment to update book
//		libraryMain.deleteBookById(4);//uncomment to delete book
		
		int countOfBooks = libraryMain.getBooks();//uncomment to get count of books
		System.out.println(countOfBooks +" count of books");

	}
	
	private void deleteBookById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = session.get(Book.class,id);
			System.out.println("Deleted Book is: ");
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getAuthor()+"\t");
			System.out.print(book.getPublisher()+"\t");
			
			session.delete(book);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
		
	}
	private void updateBookByID(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = session.get(Book.class, id);
			
			book.setName("2 States");
			book.setAuthor("Chetan Bhagat");
			
			session.update(book);
			tx.commit();
			System.out.println("Updated Book is: ");
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getAuthor()+"\t");
			System.out.print(book.getPublisher()+"\t");
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	private int getBooks() {

		Session session = factory.openSession();
		Transaction tx = null;
		int count= 0;
		try {
			tx = session.beginTransaction();
			List<Book> Books = session.createQuery("FROM Book").list();
			System.out.println("All books: ");
			count = Books.size();
			
			for(Book book : Books) {
				System.out.print(book.getId()+"\t");
				System.out.print(book.getName()+"\t\t\t");
				System.out.print(book.getAuthor()+"\t\t\t");
				System.out.print(book.getPublisher()+"\t\t\t");
				System.out.println();
			}
			tx.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
		return count;
	}
	public void addBook(String Name, String Author, String Publisher) {
		Session session = factory.openSession();
		Transaction tx = null;
		
			try {
				tx = session.beginTransaction();
				Book book = new Book( Name ,Author , Publisher);
				session.save(book);
				tx.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
				if(tx!=null)
					tx.rollback();
			}finally {
				session.close();
								
			}
		
		
	}

}
