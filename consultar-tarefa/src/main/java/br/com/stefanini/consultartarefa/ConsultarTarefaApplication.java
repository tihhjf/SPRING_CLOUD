package br.com.stefanini.consultartarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsultarTarefaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultarTarefaApplication.class, args);
	}

}
