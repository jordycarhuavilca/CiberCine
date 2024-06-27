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
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompra;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuarios idusuario;
    private Integer cantidadclientes;
    private Double montototal;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Lima")
    private Date creationdate;
    @OneToMany(mappedBy = "idcompra")
    @JsonIgnore
    private List<DetalleCompra> detalleCompras;
    @OneToMany(mappedBy = "idcompra")
    @JsonIgnore
    private List<ComprobantePago> comprobantePagos;
    @OneToMany(mappedBy = "idcompra")
    @JsonIgnore
    private List<CompraConfiteria> compraConfiterias;
}
