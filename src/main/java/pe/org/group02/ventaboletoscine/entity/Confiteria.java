package pe.org.group02.ventaboletoscine.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "confiterias")
public class Confiteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idconfiteria;
    private String nombre;
    private Double precio;
    private String detalle;
    @ManyToOne
    @JoinColumn(name = "idsala")
    private Salas idsala;
}
