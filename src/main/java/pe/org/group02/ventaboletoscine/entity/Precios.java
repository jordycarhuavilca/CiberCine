package pe.org.group02.ventaboletoscine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "precios")
public class Precios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprecio;
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "idpelicula")
    @JsonIgnore
    private Pelicula idpelicula;
    @OneToMany(mappedBy = "idprecio")
    @JsonIgnore
    private List<Funciones> funciones;
}
