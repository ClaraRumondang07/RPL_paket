/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.TokoHelper;
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
import pojos.TabelToko;

/**
 * REST Web Service
 *
 * @author Windows
 */
@Path("toko")
public class TokoResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TokoResources
     */
    public TokoResources() {
    }

    /**
     * Retrieves representation of an instance of service.TokoResources
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    /**
     * PUT method for updating or creating an instance of TokoResources
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogin(@QueryParam("idtoko") Integer idtoko, 
            @QueryParam("namaToko") String namatoko,
            @QueryParam("alamatToko") String alamattoko) {
        
        TokoHelper helper = new TokoHelper();
        TabelToko toko = helper.LoginToko(idtoko);
        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(toko))
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
    
    @POST
    @Path("tambahToko")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tambahToko(String data) {
        Gson gson = new Gson();
        TabelToko toko = gson.fromJson(data, TabelToko.class);
        TokoHelper help = new TokoHelper();
        help.tambahToko(toko.getNamaToko(), toko.getAlamatToko());
        return Response.status(200).entity(toko).build();
    }
}
