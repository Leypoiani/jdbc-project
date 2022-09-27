package application;

import model.DAO.DAOFactory;
import model.DAO.SellerDAO;
import model.entities.Department;
import model.entities.Seller;
;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        System.out.println("-- TEST 1: seller findByID --");
        Seller seller = sellerDAO.findById(1);
        System.out.println(seller);
        System.out.println();
        System.out.println("-- TEST 2: seller findByDepartment --");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println("-- TEST 3: seller findAll --");
        list = sellerDAO.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println("-- TEST 4: seller insert --");
        Seller sel = new Seller(null, "Greg", "gerg@gmail.com", new Date(), 4000.00, department);
        sellerDAO.insert(sel);
        System.out.println("Inserted.");
        System.out.println("New id = " + sel.getId());

    }
}
