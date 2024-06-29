package pe.org.group02.ventaboletoscine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableCaching
@ComponentScan(value = "pe.org.group02.ventaboletoscine")
@SpringBootApplication()
public class VentaBoletosCineApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentaBoletosCineApplication.class, args);
	}
}