package application;

import model.DAO.DAOFactory;
import model.DAO.DepartmentDAO;
import model.DAO.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

;

public class ProgramDepartment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDAO dao = DAOFactory.createDepartmentDAO();
        System.out.println("-- TEST 1: department findByID --");
        Department department = dao.findById(1);
        System.out.println(department);

        System.out.println();
        System.out.println("-- TEST 2: department findAll --");
        List<Department> list = dao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("-- TEST 3: department insert --");
        Department dep = new Department(null, "IT");
        dao.insert(dep);
        System.out.println("Inserted.");
        System.out.println("New id = " + dep.getId());

        System.out.println();
        System.out.println("-- TEST 4: department update --");
        department = dao.findById(1);
        department.setName("Troca");
        dao.update(department);
        System.out.println("Update completed.");

        System.out.println();
        System.out.println("-- TEST 5: department delete --");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        dao.deleteById(id);
        System.out.println("Delete completed.");
        sc.close();
    }
}
