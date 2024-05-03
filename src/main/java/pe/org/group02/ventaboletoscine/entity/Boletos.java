package pe.org.group02.ventaboletoscine.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "boletos")
public class Boletos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoleto;
    @ManyToOne
    @JoinColumn(name = "id_funcion")
    private Funciones idFuncion;
    private Double precio;
    private Integer cantidad;
    @OneToMany(mappedBy = "idBoleto")
    private List<ComprobantePago> comprobantePagos;
}
