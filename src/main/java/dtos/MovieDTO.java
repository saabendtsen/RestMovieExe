package dtos;

import entities.Movie;
import entities.RenameMe;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private Long id;
    private int year;
    private String title;
    private String actors;


    public MovieDTO(Movie m) {
        this.id = m.getId();
        this.year = m.getYear();
        this.title = m.getTitle();
        this.actors = m.getActors();
    }

    public MovieDTO() {
    }

    public static List<MovieDTO> getDtos(List<Movie> rms){
        List<MovieDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new MovieDTO(rm)));
        return rmdtos;
    }
}
