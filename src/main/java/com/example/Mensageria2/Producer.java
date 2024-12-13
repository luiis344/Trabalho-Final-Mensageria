package com.example.Mensageria2;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public Producer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void enviarMensagem(Object mensagem) {
        try {
            // Converta o objeto em JSON e inclua o tipo da mensagem
            String tipoMensagem = mensagem instanceof MensagemDTO ? "MensagemDTO" : "AlertaClimatico";
            String mensagemJson = objectMapper.writeValueAsString(mensagem);
            String mensagemComTipo = String.format("{\"tipoMensagem\":\"%s\", \"conteudo\":%s}", tipoMensagem, mensagemJson);

            rabbitTemplate.convertAndSend("puc_mensageria", mensagemComTipo);
        } catch (Exception e) {
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}
