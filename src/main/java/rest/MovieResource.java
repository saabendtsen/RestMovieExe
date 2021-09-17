package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;
import facades.MovieFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PostLoad;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movie")
public class MovieResource {

    private final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private final MovieFacade FACADE =  MovieFacade.getFacadeExample(EMF);
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
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

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public String getMovieById(@PathParam("id") int id ){
        MovieDTO res = FACADE.getMovieByID(id);
        return new Gson().toJson(res);
    }

}