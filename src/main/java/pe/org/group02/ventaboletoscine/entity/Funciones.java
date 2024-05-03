package pe.org.group02.ventaboletoscine.entity;

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
    private Integer idFuncion;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "id_peligen")
    private PeliculasGenero idPeligen;
    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Salas idSala;
    @OneToMany(mappedBy = "idFuncion")
    @JsonIgnore
    private List<Boletos> boletos;
}
