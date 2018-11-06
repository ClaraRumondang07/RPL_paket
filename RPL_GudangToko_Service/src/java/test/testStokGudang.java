/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.StokGudangHelper;
import java.util.List;
import pojos.TabelStokGudang;

/**
 *
 * @author Windows
 */
public class testStokGudang {
    public static void main(String[] args) {
        StokGudangHelper hp = new StokGudangHelper();
        List<TabelStokGudang> list = hp.getAllStokGudang();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdbarang());
            System.out.println(list.get(i).getNamaBarang());
            System.out.println(list.get(i).getJumlahBarang());
        }
    }
}
