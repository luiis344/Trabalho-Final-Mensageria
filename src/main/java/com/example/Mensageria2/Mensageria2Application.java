package com.example.Mensageria2;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.example.Mensageria2.Entities.AlertaClimatico;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Mensageria2Application implements CommandLineRunner {

	private final Producer producer;

	public Mensageria2Application(Producer producer) {
		this.producer = producer;
	}

	public static void main(String[] args) {
		SpringApplication.run(Mensageria2Application.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			// Criar e enviar MensagemDTO
			MensagemDTO mensagem = new MensagemDTO();
			mensagem.setDescricao("Teste de Alerta");
			mensagem.setEstado("RJ");
			mensagem.setNivelSeveridade("Moderada");
			mensagem.setNome("Teste Climático");
			mensagem.setTipoEvento("Ventos Fortes");
			mensagem.setLatitude(-22.906847);
			mensagem.setLongitude(-43.172896);

			System.out.println("Enviando MensagemDTO...");
			producer.enviarMensagem(mensagem);

			// Criar e enviar AlertaClimatico
			AlertaClimatico alerta = new AlertaClimatico();
			alerta.setTipoAlerta("Chuva Intensa");
			alerta.setDescricao("Alerta de chuva para as próximas horas");
			alerta.setCidadeMonitorada("São Paulo");
			alerta.setDataEmissao(LocalDateTime.now());

			System.out.println("Enviando AlertaClimatico...");
			producer.enviarMensagem(alerta);

		} catch (Exception e) {
			System.err.println("Erro ao executar o envio de mensagens: " + e.getMessage());
		}
	}
}
