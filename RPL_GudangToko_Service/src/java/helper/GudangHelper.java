/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.TabelGudang;
import util.RPLHibernateUtil;

/**
 *
 * @author Windows
 */
public class GudangHelper {

    public GudangHelper() {
    }
    
    public List<TabelGudang> getAllGudang() {
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        String query = "from TabelGudang";
        Query q = session.createQuery(query);
        List<TabelGudang> list = q.list();
        session.close();
        return list;
    }
}
