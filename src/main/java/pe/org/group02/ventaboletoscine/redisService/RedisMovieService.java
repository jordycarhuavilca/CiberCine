package pe.org.group02.ventaboletoscine.redisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import pe.org.group02.ventaboletoscine.entity.Pelicula;
import pe.org.group02.ventaboletoscine.repository.PeliculasRepository;
import pe.org.group02.ventaboletoscine.response.Response;

public class RedisMovieService {

    @Autowired
    private PeliculasRepository peliculasRepository;

    public Response<Pelicula> findById(Integer id) {

        if (id == null) {
            return new Response<Pelicula>(HttpStatus.BAD_REQUEST, null, "ID cannot be null");
        }

        Pelicula pelicula = peliculasRepository.findById(id).orElse(null);
        if (pelicula == null) {
            return new Response<Pelicula>(HttpStatus.NOT_FOUND,null, "Not Found");
        }

        return new Response<Pelicula>( HttpStatus.OK , pelicula, null);
    }

}
