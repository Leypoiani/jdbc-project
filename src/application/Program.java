package application;

import db.DB;
import model.DAO.DAOFactory;
import model.DAO.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.Date;

public class Program {

    public static void main(String[] args) {

        Department obj = new Department(1, "books");
        System.out.println(obj);

        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        System.out.println(sellerDAO);
    }
}
