package com.example.product_CRUD;

import org.hibernate.*;
import java.util.List;

public class ProductDAO {

    // STEP 2
    public static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 60000, 10));
        session.save(new Product("Mobile", "Electronics", 30000, 25));
        session.save(new Product("Headphones", "Accessories", 2000, 50));
        session.save(new Product("Keyboard", "Accessories", 1500, 40));
        session.save(new Product("Mouse", "Accessories", 800, 60));
        session.save(new Product("Monitor", "Electronics", 12000, 15));

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }

    // STEP 3
    public static void sortByPrice() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("\n--- Price ASCENDING ---");
        List<Product> asc = session
                .createQuery("from Product p order by p.price asc", Product.class)
                .list();
        asc.forEach(p -> System.out.println(p.getName() + " : " + p.getPrice()));

        System.out.println("\n--- Price DESCENDING ---");
        List<Product> desc = session
                .createQuery("from Product p order by p.price desc", Product.class)
                .list();
        desc.forEach(p -> System.out.println(p.getName() + " : " + p.getPrice()));

        session.close();
    }

    // STEP 4
    public static void paginationExample() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("\n--- First 3 Products ---");
        List<Product> first3 = session.createQuery("from Product", Product.class)
                .setFirstResult(0)
                .setMaxResults(3)
                .list();
        first3.forEach(p -> System.out.println(p.getName()));

        System.out.println("\n--- Next 3 Products ---");
        List<Product> next3 = session.createQuery("from Product", Product.class)
                .setFirstResult(3)
                .setMaxResults(3)
                .list();
        next3.forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    // STEP 5
    public static void aggregateQueries() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Long count = session
                .createQuery("select count(p) from Product p", Long.class)
                .uniqueResult();

        Double min = session
                .createQuery("select min(p.price) from Product p", Double.class)
                .uniqueResult();

        Double max = session
                .createQuery("select max(p.price) from Product p", Double.class)
                .uniqueResult();

        System.out.println("\nTotal Products : " + count);
        System.out.println("Min Price      : " + min);
        System.out.println("Max Price      : " + max);

        session.close();
    }
}
