package pe.org.group02.ventaboletoscine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Pelicula;
import pe.org.group02.ventaboletoscine.repository.PeliculasRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseTemp;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
import pe.org.group02.ventaboletoscine.service.PeliculasService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private PeliculasService peliculasService;

    /*@PostMapping("/add")
    public ResponseTemp addMovie(@RequestBody Pelicula movie){
        if(movie.getIdpelicula() != null){
            return new ResponseTemp(401, "Id no permitido");
        }
        peliculasRepository.save(movie);
        return new ResponseTemp(200, null);
    }*/

    @GetMapping("/find/{id}")
    public Response<Pelicula> findById(@PathVariable("id") Integer id) {
       return this.peliculasService.findById(id);
    }

    @GetMapping("/list")
    public Response<Iterable<Pelicula>> list() {
        return this.peliculasService.list();
    }

    /*@PatchMapping("/update")
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
    }*/
}
