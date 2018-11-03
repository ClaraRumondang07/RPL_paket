/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.google.gson.Gson;
import helper.kurirHelper;
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
import pojos.Kurir;

/**
 * REST Web Service
 *
 * @author clara
 */
@Path("kurir")
public class KurirResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KurirResource
     */
    public KurirResource() {
    }

    /**
     * Retrieves representation of an instance of Service.KurirResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        kurirHelper test = new kurirHelper();
        List<Kurir> list = test.bacaSemuaKurir();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of KurirResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    
     @POST
    @Path("addKurir")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewDokter(String data) {
        Gson gson = new Gson();
        Kurir kurir = gson.fromJson(data, Kurir.class);
        kurirHelper helper = new kurirHelper();
        helper.addNewKurir(
                kurir.getNik(),
                kurir.getNama(),
                kurir.getAlamat(),
                kurir.getStatus(),
                kurir.getNoTelp(),
                kurir.getAgama(),
                kurir.getTanggalLahir()
        );

        return Response
                .status(200)
                .entity(kurir)
                .build();
    }
}
