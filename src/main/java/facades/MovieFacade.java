package facades;

import dtos.MovieDTO;
import dtos.RenameMeDTO;
import entities.Movie;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovieFacade {

    private static EntityManagerFactory emf;
    private static MovieFacade instance;

    public MovieFacade() {}

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    public RenameMeDTO create(RenameMeDTO rm){
        RenameMe rme = new RenameMe(rm.getDummyStr1(), rm.getDummyStr2());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RenameMeDTO(rme);
    }

    public List<MovieDTO> getAllMovies(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m",Movie.class);
        List<Movie> movies = query.getResultList();

        List<MovieDTO> movieDTOS = MovieDTO.getDtos(movies);

        return movieDTOS;
    }






}


