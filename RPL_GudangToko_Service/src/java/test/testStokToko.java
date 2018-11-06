/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.StokBarangTokoHelper;
import java.util.List;
import pojos.TabelStokBarangToko;

/**
 *
 * @author Windows
 */
public class testStokToko {
    public static void main(String[] args) {
        StokBarangTokoHelper hp = new StokBarangTokoHelper();
        List<TabelStokBarangToko> list = hp.getAllBarangToko();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdbarang());
            System.out.println(list.get(i).getNamaBarang());
            System.out.println(list.get(i).getHargaBarang());
            System.out.println(list.get(i).getJumlahBarang());
        }
    }
}
