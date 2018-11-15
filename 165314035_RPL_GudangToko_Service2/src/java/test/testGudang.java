/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.GudangHelper;
import java.util.List;
import pojos.TabelGudang;

/**
 *
 * @author Windows
 */
public class testGudang {
    public static void main(String[] args) {
        GudangHelper help = new GudangHelper();
        List<TabelGudang> list = help.getAllGudang();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdgudang());
            System.out.println(list.get(i).getNamaGudang());
            System.out.println(list.get(i).getAlamatGudang());
        }
    }
 
}
