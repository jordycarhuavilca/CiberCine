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
@Table(name = "cine")
public class Cine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcine;
    private String nombre;
    private String direccion;
    private String ciudad;
    @OneToMany(mappedBy = "idcine")
    @JsonIgnore
    private List<Salas> salas;
}
