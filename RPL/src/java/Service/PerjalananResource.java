/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.google.gson.Gson;
import helper.perjalananHelper;
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
import pojos.Perjalanan;

/**
 * REST Web Service
 *
 * @author willy
 */
@Path("Perjalanan")
public class PerjalananResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PerjalananResource
     */
    public PerjalananResource() {
    }

    /**
     * Retrieves representation of an instance of Service.PerjalananResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {

        perjalananHelper test = new perjalananHelper();
        List<Perjalanan> list = test.bacaSemuaPerjalanan();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PerjalananResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addPerjalanan")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPerjalanan(String data) {
        Gson gson = new Gson();
        Perjalanan perjalanan = gson.fromJson(data, Perjalanan.class);
        perjalananHelper helper = new perjalananHelper();
        helper.addNewPerjalanan(
                perjalanan.getIdBarang(),
                perjalanan.getAsal(),
                perjalanan.getTujuan(),
                perjalanan.getWaktuDiterima(),
                perjalanan.getTanggalDiterima(),
                perjalanan.getNamaPenerima()
        );
        return Response
                .status(200)
                .entity(perjalanan)
                .build();
    }
    
    @GET
    @Path("cariPerjalananBarang")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(
            @QueryParam("idBarang") int idBarang){
        perjalananHelper helper = new perjalananHelper();
        Perjalanan hasil = helper.cariPerjalananBarang(idBarang);
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
