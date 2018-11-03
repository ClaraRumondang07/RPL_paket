/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.KurirHelper;
import java.util.List;
import pojos.Kurir;

/**
 *
 * @author clara
 */
public class testKurir {
     public static void main(String[] args) {
        KurirHelper test = new KurirHelper();
        List<Kurir> list = test.getAllKurir();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
