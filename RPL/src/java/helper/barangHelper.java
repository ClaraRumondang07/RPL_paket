/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import pojos.Barang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;
/**
 *
 * @author clara
 */
public class barangHelper {
    public List<Barang> bacaSemuaBarang() {
        List<Barang> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Barang b");
        list = q.list();
        session.close();
        return list;
    }
    
    public void addNewBarang(
            int idBarang,
            String namaPengirim, 
            String namaPenerima, 
            String noHpPenerima, 
            String noHpPengirim, 
            String alamatTujuan, 
            String alamatPengirim, 
            Date tanggalMasuk, 
            String jenisPengiriman,
            int totalHarga
            ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        Barang barang = new Barang(idBarang,namaPengirim, namaPenerima, noHpPenerima, noHpPengirim, alamatTujuan, alamatPengirim, tanggalMasuk, jenisPengiriman, totalHarga);
        session.saveOrUpdate(barang);
        transaction.commit();
        session.close();
    }
    
    
    public Barang cariBarang(Integer idBarang) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Barang u where u.idBarang=:idBarang";
        Query q = session.createQuery(query);
        q.setParameter("idBarang", idBarang);
        List<Barang> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    public Barang updateBarang(Barang brg){
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Barang barang = (Barang) session.get(Barang.class, brg.getIdBarang());
       
        barang.setStatusBarang(brg.getStatusBarang());
        barang.setTanggalDiterima(brg.getTanggalDiterima());
        barang.setWaktuDiterima(brg.getWaktuDiterima());
        barang.setNamaKurir(brg.getNamaKurir());
       
        session.update(barang);
        tx.commit();
        session.close();
       
        return barang;
    }
}
