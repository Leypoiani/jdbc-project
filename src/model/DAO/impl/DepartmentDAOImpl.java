package model.DAO.impl;

import db.DB;
import db.DbException;
import model.DAO.DepartmentDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAOImpl implements DepartmentDAO {

    private Connection conn;

    public DepartmentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO department "+
                            "(Name) "+
                            " VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, department.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    department.setId(id);
                }DB.closeResultSet(rs);
            }else{
                throw new DbException("Unespected error, No rows affected.");
            }
        }catch (Exception e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);

        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE department "+
                    "SET Name = ? " +
                    "WHERE Id = ?");
            st.setString(1, department.getName());
            st.setInt(2, department.getId());

            st.executeUpdate();
        }catch (Exception e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);

        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1,id);

            int rows = st.executeUpdate();

            if(rows == 0){
                throw new DbException("ID not found.");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " +
                    "FROM department " +
                    "WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department obj = instantiateDepartment(rs);
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

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department ");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>(); // controle para não haver mais de uma instancia para o mesmo departamento
            while (rs.next()) {
                Department d = map.get(rs.getInt("Id"));

                if (d == null){
                    d = instantiateDepartment(rs);
                    map.put(rs.getInt("Id"), d);
                }
                Department obj = instantiateDepartment(rs);
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

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("Name"));

        return department;
    }
}
