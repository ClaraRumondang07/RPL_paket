/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import helper.TransaksiHelper;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class testTransaksi_add {
    public static void main(String[] args) {
        try {
            TransaksiHelper transaksi = new TransaksiHelper();
            SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
            Date tgl = date.parse("20181106");
            transaksi.transaksiBaru("Dettol Tisu Basah", 8000, 1, 8000, tgl);
        } catch (Exception e) {
            Logger.getLogger(testTransaksi_add.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
