/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.TabelKirimBarang;
import pojos.TabelStokGudang;
import util.RPLHibernateUtil;

/**
 *
 * @author Windows
 */
public class KirimBarangHelper {

    public KirimBarangHelper() {
    }
    
    public List<TabelKirimBarang> getAllKirimBarang(){
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        String query = "from TabelKirimBarang";
        Query q = session.createQuery(query);
        List<TabelKirimBarang> list = q.list();
        session.close();
        return list;
    }
    
    public void kirimBarang(String namaBarang, 
            Integer jumlahBarang, Date tanggal){
        
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        TabelKirimBarang kirim = new TabelKirimBarang(namaBarang, jumlahBarang, tanggal);
        session.saveOrUpdate(kirim);
        transaction.commit();
        session.close();
    }
}
