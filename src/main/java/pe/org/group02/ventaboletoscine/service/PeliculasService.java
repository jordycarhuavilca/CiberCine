package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pe.org.group02.ventaboletoscine.entity.Pelicula;
import pe.org.group02.ventaboletoscine.repository.PeliculasRepository;
import pe.org.group02.ventaboletoscine.response.Response;

@Service
public class PeliculasService {

    @Autowired
    private PeliculasRepository peliculasRepository;

    public Response<Pelicula> findById( Integer id) {
        try{
            if (id == null) {
                return new Response<Pelicula>(HttpStatus.BAD_REQUEST, null, "ID cannot be null");
            }

            Pelicula pelicula = peliculasRepository.findById(id).orElse(null);

           if (pelicula == null) {
                return new Response<Pelicula>(HttpStatus.NOT_FOUND,null, "Not Found");
            }

            return new Response<Pelicula>( HttpStatus.OK , pelicula, null);
        }catch (Exception e){
            System.out.println("Exception "+ e);
            return new Response<Pelicula>( HttpStatus.UNPROCESSABLE_ENTITY , null, "occured an error");

        }

    }

    public Response<Iterable<Pelicula>> list() {
        return new Response<Iterable<Pelicula>>(HttpStatus.OK , peliculasRepository.findAll(),null);
    }


}
