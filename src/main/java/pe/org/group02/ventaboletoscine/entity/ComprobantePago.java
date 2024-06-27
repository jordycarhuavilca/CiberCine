package pe.org.group02.ventaboletoscine.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "comprobantepago")
public class ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomprobante;
    @ManyToOne
    @JoinColumn(name = "idcompra")
    private Compra idcompra;
}
