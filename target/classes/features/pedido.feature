# language: pt

Funcionalidade: Realizando um pedido

  Cenario: Acompanhar produção do pedido
    Quando consulta status do pedido
    Então atualiza status do pedido
    E recebe uma mensagem sobre andamento do pedido e atendimento