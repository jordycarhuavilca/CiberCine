package pe.org.group02.ventaboletoscine.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "funciones")
public class Funciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfuncion;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Lima")
    private Date fechahora;
    @ManyToOne
    @JoinColumn(name = "idprecio")
    private Precios idprecio;
    @ManyToOne
    @JoinColumn(name = "idsala")
    private Salas idsala;
    @ManyToOne
    @JoinColumn(name = "idpelicula")
    private Pelicula idpelicula;
    @OneToMany(mappedBy = "idfuncion")
    @JsonIgnore
    private List<DetalleCompra> detalleCompras;
}
