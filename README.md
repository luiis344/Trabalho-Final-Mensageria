# Projeto de Alertas Climáticos

Este é um sistema para monitoramento e envio de alertas climáticos, desenvolvido em Java com integração de diversas tecnologias modernas. O objetivo principal do projeto é gerenciar alertas relacionados a condições climáticas, gerando notificações automáticas para cidades monitoradas e permitindo a interação através de uma interface JavaFX.

## **Estrutura do Projeto**

### **Pacotes Principais**
1. **Entities**
   - **AlertaClimatico**: Representa os alertas climáticos gerados.
   - **CidadeMonitorada**: Representa as cidades que estão sendo monitoradas.
   - **Notificacao**: Representa as notificações enviadas com base nos alertas.

2. **Services**
   - **AlertaClimaticoService**: Contém a lógica de negócio para criação e gerenciamento de alertas.
   - **CidadeMonitoradaService**: Contém a lógica de negócio para gerenciar as cidades monitoradas.
   - **NotificacaoService**: Responsável por gerenciar as notificações enviadas.

3. **Controller**
   - **MensagemController**: Controla a interação entre o backend e a interface JavaFX, permitindo o envio de mensagens e a exibição dos dados em tabelas.

4. **Config**
   - **JacksonConfig**: Configura o ObjectMapper para manipulação de objetos JSON, garantindo a correta serialização e desserialização de datas e outros dados.

5. **DTOs**
   - Objetos de Transferência de Dados (DTOs) para encapsular e trafegar dados entre camadas do sistema.

### **Integração com JSON**
- O projeto utiliza a biblioteca **Jackson** para manipulação de dados em formato JSON. Essa integração facilita o envio e recebimento de dados entre o backend e qualquer consumidor, como a interface JavaFX ou APIs externas.

## **Funcionalidades Principais**

1. **Cadastro e Gerenciamento de Alertas Climáticos**
   - Permite criar, listar, atualizar e excluir alertas climáticos.
   - Cada alerta possui atributos como nível de severidade e descrição.

2. **Monitoramento de Cidades**
   - Permite cadastrar e listar cidades monitoradas.
   - Associa alertas específicos às cidades afetadas.

3. **Geração e Envio de Notificações**
   - Notificações automáticas são geradas com base em alertas para as cidades monitoradas.
   - Integração com JSON para trafegar dados entre componentes.

4. **Interface Gráfica com JavaFX**
   - Interface intuitiva que exibe tabelas de alertas, cidades e notificações.
   - Uso de combobox para seleção do nível de severidade.

## **Tecnologias Utilizadas**

1. **Java 17**
   - Linguagem de programação base do projeto.

2. **JavaFX**
   - Biblioteca para construção da interface gráfica.

3. **Spring Boot**
   - Framework utilizado para estruturação do backend e controle das entidades.

4. **Jackson**
   - Biblioteca para serialização e desserialização de objetos JSON.

5. **Maven**
   - Ferramenta de automação e gerenciamento de dependências.

## **Execução do Projeto**

### **Requisitos**
- Java 17 ou superior instalado.
- Maven configurado no ambiente.

### **Passos para Execução**
1. Clone o repositório:
   ```bash
   git clone https://github.com/luiis344/Trabalho-Final-Mensageria.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd Trabalho-Final-Mensageria
   ```

3. Instale as dependências:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn javafx:run
   ```

## **Contribuição**
Contribuições são bem-vindas! Para contribuir, siga estas etapas:

1. Fork o repositório.
2. Crie um branch para suas alterações:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça o commit das alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie suas alterações:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request no repositório principal.

6. Coloque os seus dados do rabbitMQ e Banco de Dados a sua escolhar no application.properties

7. E inicialize a classe mensageria application

