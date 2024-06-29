package pe.org.group02.ventaboletoscine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.group02.ventaboletoscine.entity.Email;

@Repository
public interface TemporalRegistrationRepository extends CrudRepository<Email,Integer> {
}
