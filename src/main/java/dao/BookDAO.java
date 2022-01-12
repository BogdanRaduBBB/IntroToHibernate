package dao;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

public class BookDAO {
    Session session;
    SessionFactory factory;


    public BookDAO(){
        SessionFactory factory = HibernateUtils.getSessionFactory();
    }
    public Book getBookByID(long id){
        Session session = factory.openSession();
        Book book = (session.get(Book.class, id));
        session.close();
        return book;
    }

    public void insertIntoTable(Book book){
        session = factory.openSession();
        Transaction transaction = session.getTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void deleteFromTable(Long id){
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(this.getBookByID(id));
        transaction.commit();
        session.close();
    }
}
