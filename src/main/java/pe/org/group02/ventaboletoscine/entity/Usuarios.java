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
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @OneToOne
    @JoinColumn(name = "id_empleado", unique = true)
    private Empleados idEmpleado;
    @Column(unique = true)
    private String usuario;
    private String contrasenia;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date createdAt;
    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<ComprobantePago> comprobantePagos;
}
