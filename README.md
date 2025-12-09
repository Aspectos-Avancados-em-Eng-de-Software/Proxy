# Implementação do Padrão de Projeto:  Memento

O Padrão Memento é um padrão de projeto comportamental que permite salvar e restaurar o estado anterior de um objeto sem revelar os detalhes de sua implementação. Isso promove o encapsulamento e simplifica a estrutura do objeto original (Originator).

Este padrão é ideal para cenários que exigem funcionalidades como "desfazer" (undo) ou o rastreamento de um histórico de transações, como:

- Editores de texto ou imagem: Para reverter ações do usuário.
- Assistentes de instalação (wizards): Para voltar a um passo anterior.
- Jogos: Para salvar o progresso do jogador (checkpoints).
- Gerenciamento de transações: Para reverter uma operação em caso de falha.

## Cenário Aplicado: Controle de Acesso a Documentos Confidenciais
Para esta implementação, foi escolhido o cenário do gerenciamento do ciclo de vida de um pedido em um sistema de e-commerce. O objetivo é rastrear as mudanças de estado de um Pedido (Criado, Aguardando Pagamento, etc.) e permitir a restauração para um estado anterior, se necessário.

Este cenário se encaixa perfeitamente no Padrão Memento, onde:
- O Pedido é o objeto Originator, cujo estado desejamos salvar.
- A interface PedidoEstado atua como o Memento, armazenando uma "fotografia" do estado do pedido em um determinado momento.
- A própria classe Pedido também assume o papel de Caretaker (Zelador), mantendo um histórico de Mementos (estados) em uma lista, sem precisar conhecer os detalhes internos de cada estado.

Os componentes principais do padrão, adaptados ao cenário, são:
- **Originator (Pedido):** A classe principal que possui um estado interno e cujo histórico queremos salvar. Ela cria os Mementos e os utiliza para restaurar seu estado
- **Memento (PedidoEstado):** Uma interface que representa o estado salvo. As classes concretas (PedidoEstadoCriado, PedidoEstadoCancelado, etc.) implementam essa interface e contêm a lógica de transição de estado
- **Caretaker (Pedido):**  A classe Pedido também gerencia o histórico de Mementos. Ela é responsável por guardar e restaurar os estados do Originator


### Estrutura do Projeto
O projeto foi organizado utilizando a estrutura padrão do Maven.

```
├──pom.xml
└──src/
    ├── main/java/padroescomportamentais/memento/
    │   └── Pedido.java             
    │   └── PedidoEstado.java        
    │   └── PedidoEstadoAguardandoPagamento.java          
    │   └── PedidoEstadoCancelado.java                  
    │   └── PedidoEstadoCriado.java 
    │   └── PedidoEstadoEmTransporte.java       
    │   └── PedidoEstadoEntregue.java
    │   └── PedidoEstadoPagamentoAprovado.java                                                      
    └── test/java/padroescomportamentais/memento/
        └── PedidoTest.java  
```

### Diagrama
![Diagrama Memento](diagrama_proxy.png)

### Tecnologias Utilizadas
- Java 11: Linguagem de programação principal.
- Maven 3.8+: Ferramenta de automação de build e gerenciamento de dependências.
- JUnit 5: Framework para a escrita e execução de testes unitários