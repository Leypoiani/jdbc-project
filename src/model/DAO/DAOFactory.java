package model.DAO;

import model.DAO.impl.SellerDAOImpl;

public class DAOFactory {

    public static SellerDAO createSellerDAO(){
        return new SellerDAOImpl();
    }
}
