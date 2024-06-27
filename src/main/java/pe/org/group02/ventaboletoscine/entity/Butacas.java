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
@Table(name = "butacas")
public class Butacas {
    @Id
    private String numerobutaca;
    @ManyToOne
    @JoinColumn(name = "idsala")
    private Salas idsala;
    private Boolean disponible;
}
