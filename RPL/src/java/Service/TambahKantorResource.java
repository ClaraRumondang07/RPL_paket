/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.google.gson.Gson;
import helper.tambahKantorHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.TambahKantor;

/**
 * REST Web Service
 *
 * @author clara
 */
@Path("TambahKantor")
public class TambahKantorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TambahKantorResource
     */
    public TambahKantorResource() {
    }

    /**
     * Retrieves representation of an instance of Service.TambahKantorResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
       //TODO return proper representation object
        tambahKantorHelper test = new tambahKantorHelper();
        List<TambahKantor> list = test.bacaSemuaKantor();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of TambahKantorResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    
    @POST
    @Path("addKantor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewKantor(String data) {
        Gson gson = new Gson();
        TambahKantor kantor = gson.fromJson(data, TambahKantor.class);
        tambahKantorHelper helper = new tambahKantorHelper();
        helper.addNewKantor(kantor.getIdKantor(), kantor.getJenis(), kantor.getTableRouting());

        return Response
                .status(200)
                .entity(kantor)
                .build();
    }
}
