package com.example.Mensageria2;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.example.Mensageria2.Entities.AlertaClimatico;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class Consumer {

    private final ObjectMapper objectMapper;

    public Consumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "${queue.alertas.name}")
    public void consumirMensagem(byte[] mensagemBytes, Channel channel, Message message) {
        try {
            String mensagemJson = new String(mensagemBytes, StandardCharsets.UTF_8);
            JsonNode jsonNode = objectMapper.readTree(mensagemJson);
            String tipoMensagem = jsonNode.get("tipoMensagem").asText();
            JsonNode conteudo = jsonNode.get("conteudo");

            if ("MensagemDTO".equals(tipoMensagem)) {
                MensagemDTO mensagem = objectMapper.treeToValue(conteudo, MensagemDTO.class);
                System.out.println("MensagemDTO recebida: " + mensagem);
                // Processar MensagemDTO
            } else if ("AlertaClimatico".equals(tipoMensagem)) {
                AlertaClimatico alerta = objectMapper.treeToValue(conteudo, AlertaClimatico.class);
                System.out.println("AlertaClimatico recebido: " + alerta);
                // Processar AlertaClimatico
            } else {
                System.err.println("Tipo de mensagem desconhecido: " + tipoMensagem);
            }

            // Confirma o recebimento da mensagem após o processamento
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            System.err.println("Erro ao processar a mensagem: " + e.getMessage());
            try {
                // Rejeita a mensagem em caso de erro
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException ex) {
                System.err.println("Erro ao rejeitar a mensagem: " + ex.getMessage());
            }
        }
    }
}
