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
import pojos.TabelTransaksi;
import util.RPLHibernateUtil;

/**
 *
 * @author Windows
 */
public class TransaksiHelper {

    public TransaksiHelper() {
    }
    
    public List<TabelTransaksi> getAllTransaksi(){
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        String query = "from TabelTransaksi";
        Query q = session.createQuery(query);
        List<TabelTransaksi> list = q.list();
        session.close();
        return list;
    }
    
    public void transaksiBaru(String namaBarang, 
            Integer hargaBarang, Integer jumlahBarang, Integer hargaTotal,
            Date tanggal) {
        
        Session session = RPLHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        TabelTransaksi transaksi = new TabelTransaksi(namaBarang, hargaBarang, 
                jumlahBarang, hargaTotal, tanggal);
        session.saveOrUpdate(transaksi);
        transaction.commit();
        session.close();
    }
}
