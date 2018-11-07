/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.KirimBarangHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.jboss.logging.Logger;
import pojos.TabelKirimBarang;

/**
 *
 * @author Windows
 */
public class testKirimBarang_add {

    public static void main(String[] args) {
        try {
//            KirimBarangHelper kirim = new KirimBarangHelper();
//            List<TabelKirimBarang> list = kirim.getAllKirimBarang();
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println("id barang: " + list.get(i).getIdbarang());
//                System.out.println("nama barang: " + list.get(i).getNamaBarang());
//                System.out.println("jumlah barang: " + list.get(i).getJumlahBarang());
//                System.out.println("tanggal: " + list.get(i).getTanggal());
//            }
            KirimBarangHelper kirim = new KirimBarangHelper();
            SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
            Date tgl = date.parse("20181106");
            kirim.kirimBarang("Dettol Tisu Basah", 100, tgl);
//            List<TabelKirimBarang> list = kirim.getAllKirimBarang();
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println("id barang: " + list.get(i).getIdbarang());
//                System.out.println("nama barang: " + list.get(i).getNamaBarang());
//                System.out.println("jumlah barang: " + list.get(i).getJumlahBarang());
//                System.out.println("tanggal: " + list.get(i).getTanggal());
//            }
        } catch (Exception ex) {

//            Logger.getLogger(testKirimBarang_add.class.getName());
        }
    }
}
