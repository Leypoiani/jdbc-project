package model.DAO.impl;

import db.DB;
import db.DbException;
import model.DAO.DepartmentDAO;
import model.DAO.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDAOImpl implements SellerDAO {

    private Connection conn;

    public SellerDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName " +
                    "FROM seller INNER JOIN department " +
                    "ON seller.DepartmentId = department.Id " +
                    "Where seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department department = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, department);
                return obj;
            }
            return null;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBithDate(rs.getDate("BirthDate"));
        obj.setDepartment(department);

        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("DepName"));

        return department;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName " +
                    "FROM seller INNER JOIN department " +
                    "ON seller.DepartmentId = department.Id " +
                    "ORDER BY Name");

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>(); // controle para não haver mais de uma instancia para o mesmo departamento
            while (rs.next()) {
                Department d = map.get(rs.getInt("DepartmentId"));

                if (d == null){
                    d = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), d);
                }
                Seller obj = instantiateSeller(rs, d);
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as DepName " +
                                            "FROM seller INNER JOIN department " +
                                            "ON seller.DepartmentId = department.Id " +
                                            "Where DepartmentId = ? " +
                                            "ORDER BY Name");
            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>(); // controle para não haver mais de uma instancia para o mesmo departamento
            while (rs.next()) {
                Department d = map.get(rs.getInt("DepartmentId"));

                if (d == null){
                    d = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), d);
                }
                Seller obj = instantiateSeller(rs, d);
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
