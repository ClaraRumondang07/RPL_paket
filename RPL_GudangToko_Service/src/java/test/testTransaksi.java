/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.TransaksiHelper;
import java.util.List;
import pojos.TabelTransaksi;

/**
 *
 * @author Windows
 */
public class testTransaksi {
    public static void main(String[] args) {
        TransaksiHelper help = new TransaksiHelper();
        List<TabelTransaksi> list = help.getAllTransaksi();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdbarang());
            System.out.println(list.get(i).getNamaBarang());
            System.out.println(list.get(i).getHargaBarang());
            System.out.println(list.get(i).getJumlahBarang());
            System.out.println(list.get(i).getHargaTotal());
            System.out.println(list.get(i).getTanggal());
        }
    }
}
