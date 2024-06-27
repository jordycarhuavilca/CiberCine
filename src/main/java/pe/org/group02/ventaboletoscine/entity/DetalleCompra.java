package pe.org.group02.ventaboletoscine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "detallecompra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetallecompra;
    private Integer cantidadticketsadultos;
    private Integer cantidadticketsninos;
    @ManyToOne
    @JoinColumn(name = "idfuncion")
    private Funciones idfuncion;
    private String metodopago;
    @ManyToOne
    @JoinColumn(name = "idcompra")
    private Compra idcompra;
}
