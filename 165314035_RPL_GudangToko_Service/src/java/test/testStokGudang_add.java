/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import helper.StokGudangHelper;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class testStokGudang_add {
    public static void main(String[] args) {
        try {
            StokGudangHelper gudang = new StokGudangHelper();
            gudang.tambahStokGudang("Dettol Tisu Basah", 400);
        } catch (Exception e) {
            Logger.getLogger(testStokGudang_add.class.getName());
        }
    }
}
