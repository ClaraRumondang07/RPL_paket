/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.TokoHelper;
import java.util.List;
import pojos.TabelToko;

/**
 *
 * @author Windows
 */
public class testToko {
    public static void main(String[] args) {
        TokoHelper tk = new TokoHelper();
//        TabelToko toko = tk.getAllToko(Integer.BYTES)
        List<TabelToko> list = tk.getAllToko();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdtoko());
            System.out.println(list.get(i).getNamaToko());
            System.out.println(list.get(i).getAlamatToko());
        }
    }
}
