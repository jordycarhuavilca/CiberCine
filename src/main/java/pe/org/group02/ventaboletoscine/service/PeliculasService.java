package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Pelicula;
import pe.org.group02.ventaboletoscine.repository.PeliculasRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class PeliculasService {

    @Autowired
    private PeliculasRepository peliculasRepository;

    @PostMapping("/add")
    public Response addMovie(@RequestBody Pelicula movie){
        if(movie.getIdpelicula() != null){
            return new Response(401, "Id no permitido");
        }
        peliculasRepository.save(movie);
        return new Response(200, null);
    }

    @GetMapping("/find")
    public ResponseConsultas<Pelicula> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Pelicula> peliculas = null;
        if (id > 0) {
            peliculas = peliculasRepository.findAllById(List.of(id));
        } else if (id == 0) {
            peliculas = peliculasRepository.findAll();
        } else {
            return new ResponseConsultas<Pelicula>(404, "not found id", null);
        }

        return new ResponseConsultas<Pelicula>( 200 , null, peliculas);
    }

    @PatchMapping("/update")
    public Response updateMovie(@RequestBody Pelicula movie){
        if(!peliculasRepository.findById(movie.getIdpelicula()).isPresent()){
            return new Response(404, "Not Found");
        }

        peliculasRepository.save(movie);
        return new Response(200, null);
    }

    @DeleteMapping("/delete")
    public Response deleteMovie(@RequestBody Pelicula movie) {
        if (!peliculasRepository.findById(movie.getIdpelicula()).isPresent()) {
            return new Response(404, "Not Found");
        }
        peliculasRepository.delete(movie);
        return new Response(200, null);
    }
}
