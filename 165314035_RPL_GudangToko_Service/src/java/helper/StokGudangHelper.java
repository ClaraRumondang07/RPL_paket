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
import pojos.TabelStokGudang;
import util.RPLHibernateUtil;

/**
 *
 * @author Windows
 */
public class StokGudangHelper {

    public StokGudangHelper() {
    }
    
    public List<TabelStokGudang> getAllStokGudang() {
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        String query = "from TabelStokGudang";
        Query q = session.createQuery(query);
        List<TabelStokGudang> list = q.list();
        session.close();
        return list;
    }
    
    public void tambahStokGudang(String namaBarang, 
            Integer jumlahBarang) {
        
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        TabelStokGudang stokGudang = new TabelStokGudang(namaBarang, jumlahBarang);
        session.saveOrUpdate(stokGudang);
        transaction.commit();
        session.close();
    }
}
