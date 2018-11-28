/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import pojos.Kantor;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author clara
 */
public class tambahKantorHelper {
    public List<Kantor> bacaSemuaKantor() {
        List<Kantor> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Kantor TB");
        list = q.list();
        session.close();
        return list;
    }
    
    public void addNewKantor(
            String idKantor, 
            String jenis, 
            String posisi
            ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        Kantor kantor = new Kantor(idKantor, jenis, posisi);
        session.saveOrUpdate(kantor);
        transaction.commit();
        session.close();
    }
}
