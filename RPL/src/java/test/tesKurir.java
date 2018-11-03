/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.kurirHelper;
import java.util.List;
import pojos.Kurir;

/**
 *
 * @author willy
 */
public class tesKurir {
    public static void main(String[] args) {
        kurirHelper tes = new kurirHelper();
        List<Kurir> list = tes.bacaSemuaKurir();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
