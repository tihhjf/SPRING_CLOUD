package br.com.stefanini.tarefaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Sink.class)
public class TarefaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefaConsumerApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void readMessage(String message) {
		System.out.println("-------> Mensagem recebida: " + message);
	}

}
