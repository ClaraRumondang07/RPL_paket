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

    public kurirHelper() {
    }

    public List<Kurir> getAllKurir() {
        List<Kurir> result = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Kurir k";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    
    public void addNewKurir(
            int nik, 
            String nama, 
            String alamat, 
            String status, 
            String noTelp, 
            String agama, 
            Date tanggalLahir) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Kurir kurir = new Kurir(nik, nama, alamat, status, noTelp, agama, tanggalLahir);
        session.saveOrUpdate(kurir);
        transaction.commit();
        session.close();
    }
}
