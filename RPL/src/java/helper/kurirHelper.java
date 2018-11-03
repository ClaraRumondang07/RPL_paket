/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Kurir;
import util.NewHibernateUtil;

/**
 *
 * @author willy
 */
public class kurirHelper {
    public List<Kurir> bacaSemuaKurir() {
        List<Kurir> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Kurir k");
        list = q.list();
        session.close();
        return list;
    }
    
    public void addNewKurir(String nama, 
            String alamat, 
            String status,
            String noTelp,
            String agama,
            Date tanggalLahir,
            int nik
            ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        Kurir kurir = new Kurir(nik, nama, alamat, status, noTelp, agama, tanggalLahir);
        session.saveOrUpdate(kurir);
        transaction.commit();
        session.close();
    }
}
