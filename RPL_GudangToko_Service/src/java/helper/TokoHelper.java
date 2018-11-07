/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.TabelToko;
import util.RPLHibernateUtil;

/**
 *
 * @author Windows
 */
public class TokoHelper {

    public TokoHelper() {
    }
    
    public List<TabelToko> getAllToko() {
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
//        String query = "from TabelToko tk where tk.idtoko=:idtoko";
        String query = "from TabelToko";
        Query q = session.createQuery(query);
        List<TabelToko> list = q.list();
        session.close();
        return list;
    }
    
    public TabelToko LoginToko (int idtoko) {
//        List<TabelToko> list = this.getAllToko();
        TabelToko toko = (TabelToko) this.getAllToko();
        
        if (toko != null) {
            if (toko.getIdtoko().equals(idtoko)) {
                return toko;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    public void tambahToko(String namaToko, String alamatToko) {
        
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        TabelToko toko = new TabelToko(namaToko, alamatToko);
        session.saveOrUpdate(toko);
        transaction.commit();
        session.close();
    }
}
