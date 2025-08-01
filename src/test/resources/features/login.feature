#language: pt
#Author: islansantosbz@gmail.com

@regressivos
Funcionalidade: Login na plataforma webshop
  Como um usuário do site webshop
  Quero enviar as minhas credenciais 
  Para acessar a página de usuário logado

Contexto: Acessar o formulário de login
  Dado que o usuário acessa a página de login

@loginPositivo
Cenário: Login com sucesso
  Quando preencher o email "islansantosbz@gmail.com" e a senha "123456" corretamente
  Então valida o "islansantosbz@gmail.com" logado

@loginNegativo
Cenário Outline: Login com credenciais inválidas
  Quando preencher o <email> e a <senha> incorretamente
  Então valida a mensagem com a inconsistência "<mensagem>"

  Exemplos:
    | email                   | senha   | mensagem          |
    |                         |         | Dados em branco   |
    | islansantosbz@gmail.com | errada  | Senha errada      |
    | errodo@gmail.com        | errada  | Email errado      |

