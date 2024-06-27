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
@Table(name = "salas")
public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsala;
    private String numero;
    private Boolean saladisponibilidad;
    private Integer nrobutacas;
    @ManyToOne
    @JoinColumn(name = "idcine")
    private Cine idcine;
    @OneToMany(mappedBy = "idsala")
    @JsonIgnore
    private List<Funciones> funciones;
    @OneToMany(mappedBy = "idsala")
    @JsonIgnore
    private List<Confiteria> confiterias;
    @OneToMany(mappedBy = "idsala")
    @JsonIgnore
    private List<Butacas> butacas;
}
