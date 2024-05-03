package pe.org.group02.ventaboletoscine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "peliculas_generos")
public class PeliculasGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPeligen;
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula idPelicula;
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero idGenero;
    @OneToMany(mappedBy = "idPeligen")
    @JsonIgnore
    private List<Funciones> funciones;
}
