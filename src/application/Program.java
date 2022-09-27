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

        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        System.out.println("-- TEST 1: findByID --");
        Seller seller = sellerDAO.findById(1);
        System.out.println(seller);
    }
}
