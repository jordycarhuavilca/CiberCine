package pe.org.group02.ventaboletoscine.repository;

import org.springframework.data.repository.CrudRepository;
import pe.org.group02.ventaboletoscine.entity.Compra;

public interface BoletosRepository extends CrudRepository<Compra, Integer> {
}