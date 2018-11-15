/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.google.gson.Gson;
import helper.barangHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Barang;

/**
 * REST Web Service
 *
 * @author clara
 */
@Path("barang")
public class BarangResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BarangResource
     */
    public BarangResource() {
    }

    /**
     * Retrieves representation of an instance of Service.BarangResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        barangHelper test = new barangHelper();
        List<Barang> list = test.bacaSemuaBarang();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of BarangResource
     *
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    @POST
    @Path("addBarang")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPasien(String data) {
        Gson gson = new Gson();
        Barang barang = gson.fromJson(data, Barang.class);
        barangHelper helper = new barangHelper();
        helper.addNewBarang(
                barang.getNamaPengirim(),
                barang.getNamaPenerima(),
                barang.getNoHpPenerima(),
                barang.getNoHpPengirim(),
                barang.getAlamatTujuan(),
                barang.getAlamatPengirim(),
                barang.getTanggalMasuk(),
                barang.getJenisPengiriman(),
                barang.getStatusBarang(),
                barang.getTotalHarga(),
                barang.getTanggalDiterima(),
                barang.getWaktuDiterima(),
                barang.getNamaKurir(),
                barang.getTableRouting()
        );

        return Response
                .status(200)
                .entity(barang)
                .build();
    }
    
    @GET
    @Path("cariBarang")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(
            @QueryParam("idBarang") Integer idBarang){
        barangHelper helper = new barangHelper();
        Barang hasil = helper.cariBarang(idBarang);
//        boolean hasil = helper.login(email, password);
        Gson gson = new Gson();
        
         return Response.status(200)
                .entity(gson.toJson(hasil))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age","2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }
}
