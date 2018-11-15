/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.TokoHelper;
import org.jboss.logging.Logger;

/**
 *
 * @author Windows
 */
public class testToko_add {
    public static void main(String[] args) {
        try {
            TokoHelper toko = new TokoHelper();
            toko.tambahToko("Toko Yanto", "Tasura 1");
        } catch (Exception ex) {
            Logger.getLogger(testToko_add.class.getName());
        }
 
    }
}
