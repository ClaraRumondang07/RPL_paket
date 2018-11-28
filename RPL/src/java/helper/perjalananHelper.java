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
import pojos.Perjalanan;
import util.NewHibernateUtil;

/**
 *
 * @author willy
 */
public class perjalananHelper {
    public List<Perjalanan> bacaSemuaPerjalanan() {
        List<Perjalanan> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Perjalanan b");
        list = q.list();
        session.close();
        return list;
    }
    
    public void addNewPerjalanan(
            int idBarang, 
            String asal, 
            String tujuan,
            String waktuDiterima, 
            Date tanggalDiterima, 
            String namaPenerima
            ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        Perjalanan perjalanan = new Perjalanan(idBarang, asal, tujuan, waktuDiterima, tanggalDiterima, namaPenerima);
        session.saveOrUpdate(perjalanan);
        transaction.commit();
        session.close();
    }
    
    public Perjalanan cariPerjalananBarang(int idBarang) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Perjalanan u where u.idBarang=:idBarang";
        Query q = session.createQuery(query);
        q.setParameter("idBarang", idBarang);
        List<Perjalanan> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
}
