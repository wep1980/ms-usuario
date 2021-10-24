package br.com.wepdev.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient // Habilitando a configuração do servidor eureka
@SpringBootApplication
public class UsuarioApplication implements CommandLineRunner { // CommandLineRunner imprime no console o bcrypt de uma senha passada no metodo run()


    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // precisou ser criado um bean, para ter a instancia do bcrypy disponivel no spring



    public static void main(String[] args) {
        SpringApplication.run(UsuarioApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        //System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));
    }
}
