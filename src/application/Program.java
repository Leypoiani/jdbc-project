package application;

import db.DB;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.Date;

public class Program {

    public static void main(String[] args) {

        Department obj = new Department(1, "books");
        System.out.println(obj);

        Seller seller = new Seller(21, "Bob", "bob@gmail.com",new Date(12/12/1998), 3000.00, obj);
        System.out.println(seller);
    }
}
