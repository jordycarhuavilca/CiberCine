package pe.org.group02.ventaboletoscine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;
import pe.org.group02.ventaboletoscine.entity.Email;
import pe.org.group02.ventaboletoscine.repository.TemporalRegistrationRepository;

import java.util.Optional;

@Slf4j
@Service
public class TemporalRegistrationService {
    @Autowired
    private TemporalRegistrationRepository temporalRegistrationRepository;

    public Email save(Email email) {
        log.info("saving user");
        return temporalRegistrationRepository.save(email);
    }

    public Email findById(Integer id) {
        log.info("Getting user from database: " + id);
         return temporalRegistrationRepository.findById(id).orElse(null);
    }

    /*@CachePut( value="user", key="#id")
    public SecutityCode updateUser(Integer code, SecutityCode user) {
        SecutityCode userUpd = secutityCodeRepository.findById(code)
                .orElseThrow();
        userUpd.setAge(user.getAge());
        userUpd.setName(user.getName());

        log.info("Updating user: ", id);
        return userRepository.save(userUpd);
    }*/
    /*@CacheEvict
            ( value="user")
    public void deleteUser(Integer id) {
        log.info("Updating user: ", id);
        User user = secutityCodeRepository.findById(id)
                .orElseThrow();
        userRepository.delete(user);
    }*/


}
