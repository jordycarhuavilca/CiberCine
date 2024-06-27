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
@Table(name = "compraconfiteria")
public class CompraConfiteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompraconfiteria;
    @ManyToOne
    @JoinColumn(name = "idconfiteria")
    private Confiteria idconfiteria;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "idcompra")
    private Compra idcompra;
}
