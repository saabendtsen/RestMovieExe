package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;
import facades.MovieFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/movie")
public class MovieResource {

    private final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private final MovieFacade FACADE =  MovieFacade.getFacadeExample(EMF);
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Movie, shit";
    }




    @Path("/all")
    @GET
    @Produces("application/json")
    public String getAllMovies(){
        List<MovieDTO> res = FACADE.getAllMovies();
        return new Gson().toJson(res);

    }


}