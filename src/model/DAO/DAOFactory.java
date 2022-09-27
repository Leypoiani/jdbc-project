package model.DAO;

import db.DB;
import model.DAO.impl.SellerDAOImpl;

public class DAOFactory {

    public static SellerDAO createSellerDAO(){
        return new SellerDAOImpl(DB.getConnection());
    }
}
