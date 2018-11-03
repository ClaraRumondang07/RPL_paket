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
            String namaPengirim, 
            String namaPenerima, 
            String noHpPenerima, 
            String noHpPengirim, 
            String alamatTujuan, 
            String alamatPengirim, 
            Date tanggalMasuk, 
            String jenisPengiriman, 
            String statusBarang, 
            Integer totalHarga, 
            Date tanggalDiterima, 
            Date waktuDiterima, 
            String namaKurir
            ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        Barang barang = new Barang(namaPengirim, namaPenerima, noHpPenerima, noHpPengirim, alamatTujuan, alamatPengirim, tanggalMasuk, jenisPengiriman, statusBarang, totalHarga, tanggalDiterima, waktuDiterima, namaKurir);
        session.saveOrUpdate(barang);
        transaction.commit();
        session.close();
    }
}
