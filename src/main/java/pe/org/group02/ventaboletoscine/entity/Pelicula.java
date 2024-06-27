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
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpelicula;
    private String nombrepelicula;
    private String descripcion;
    private String genero;
    private String trailerurl;
    private String imgurl;
    private String directorpelicula;
    private String duracionpelicula;
    @OneToMany(mappedBy = "idpelicula")
    @JsonIgnore
    private List<Precios> precios;
    @OneToMany(mappedBy = "idpelicula")
    @JsonIgnore
    private List<Funciones> funciones;
}
