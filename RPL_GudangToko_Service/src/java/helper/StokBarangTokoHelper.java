/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.TabelStokBarangToko;
import util.RPLHibernateUtil;

/**
 *
 * @author Windows
 */
public class StokBarangTokoHelper {

    public StokBarangTokoHelper() {
    }
    
    public List<TabelStokBarangToko> getAllBarangToko() {
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        String query = "from TabelStokBarangToko";
        Query q = session.createQuery(query);
        List<TabelStokBarangToko> list = q.list();
        session.close();
        return list;
    }
}
