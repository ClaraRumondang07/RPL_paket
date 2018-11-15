/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.KirimBarangHelper;
import java.util.List;
import pojos.TabelKirimBarang;

/**
 *
 * @author Windows
 */
public class testKirimBarang {
    public static void main(String[] args) {
        KirimBarangHelper hp = new KirimBarangHelper();
        List<TabelKirimBarang> list = hp.getAllKirimBarang();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("id barang: "+list.get(i).getIdbarang());
            System.out.println("nama barang: "+list.get(i).getNamaBarang());
            System.out.println("jumlah barang: "+list.get(i).getJumlahBarang());
            System.out.println("tanggal: "+list.get(i).getTanggal());
        }
    }
}
