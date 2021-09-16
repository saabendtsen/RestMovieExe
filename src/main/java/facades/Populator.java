/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Movie;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacadeExample(emf);
        MovieFacade mf = MovieFacade.getFacadeExample(emf);
        fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
        fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));

        String a1 = "Niller Larsen";
        String a2 = "Niller Karlsen";

        Movie m1 = new Movie(1990,"Günter",a1);
        Movie m2 = new Movie(1849,"Lækker film",a2);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m1);
        em.persist(m2);
        em.getTransaction().commit();

    }
    
    public static void main(String[] args) {
        populate();
    }
}
