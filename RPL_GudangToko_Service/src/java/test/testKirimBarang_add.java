/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.KirimBarangHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.jboss.logging.Logger;

/**
 *
 * @author Windows
 */
public class testKirimBarang_add {
    public static void main(String[] args) {
        try {
            KirimBarangHelper kirim = new KirimBarangHelper();
            SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
            Date tgl = date.parse("20181106");
            kirim.kirimBarang("Dettol Tisu Basah", 100, (java.sql.Date) tgl);
        } catch (Exception ex) {
            Logger.getLogger(testKirimBarang_add.class.getName());
        }
    }
}
