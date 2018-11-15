/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.GudangHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.TabelGudang;

/**
 * REST Web Service
 *
 * @author Windows
 */
@Path("gudang")
public class GudangResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GudangResource
     */
    public GudangResource() {
    }

    /**
     * Retrieves representation of an instance of service.GudangResource
     * @param idgudang
     * @param namaGudang
     * @param alamatGudang
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoginGudang(
            @QueryParam("idgudang") Integer idgudang,
            @QueryParam("namaGudang") String namaGudang,
            @QueryParam("alamatGudang") String alamatGudang) {
        //TODO return proper representation object
        GudangHelper helper = new GudangHelper();
//        TabelGudang gudang = (TabelGudang) helper.getAllGudang();
        List<TabelGudang> list = helper.getAllGudang();
        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(list))
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
     * PUT method for updating or creating an instance of GudangResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
