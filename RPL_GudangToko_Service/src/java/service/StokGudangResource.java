/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.StokGudangHelper;
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
import pojos.TabelStokGudang;

/**
 * REST Web Service
 *
 * @author Windows
 */
@Path("stokGudang")
public class StokGudangResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StokGudangResource
     */
    public StokGudangResource() {
    }

    /**
     * Retrieves representation of an instance of service.StokGudangResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStokGudang(
            @QueryParam("idbarang") Integer idbarang,
            @QueryParam("namaBarang") String namaBarang,
            @QueryParam("jumlahBarang") Integer jumlahBarang) {
        //TODO return proper representation object
        StokGudangHelper helper = new StokGudangHelper();
        TabelStokGudang stokGudang = (TabelStokGudang) helper.getAllStokGudang();
        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(stokGudang))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of StokGudangResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Path("tambahStokGudang")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tambahStokGudang(String data){
        Gson gson = new Gson();
        TabelStokGudang stok = gson.fromJson(data, TabelStokGudang.class);
        StokGudangHelper help = new StokGudangHelper();
        help.tambahStokGudang(stok.getNamaBarang(), stok.getJumlahBarang());
        return Response.status(200).entity(stok).build();
    }
}
