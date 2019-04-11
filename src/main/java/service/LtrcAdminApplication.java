package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.admin.repositories.NaturalRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class)
@EnableDiscoveryClient
public class LtrcAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LtrcAdminApplication.class, args);
    }

}
