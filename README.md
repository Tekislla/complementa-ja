# Complementa já!
Aplicativo para gestão de horas complementares dos alunos do Centro Universitário Católica de Santa Catarina


🧠 Repositório front-end: https://github.com/atjulia/complementa-ja
<br>
<br>
**⚠ INSTRUÇÕES ⚠**
<br>
<br>
1️⃣ Requisitos:

    👉🏻 IntelliJ
  
    👉🏻 JDK 1.8 (Java 8)
  
    👉🏻 Postman (para testar os endpoints)
    
    👉🏻 Git (para fazer os commits, criar branchs, fazer pull request e etc.)
<br>
2️⃣ Entrar no workspace do postman (solicitar acesso à mim):

    👉🏻 Seção LOCAL: Testar os endpoints enquanto roda a aplicação na sua máquina (localhost)
    
    👉🏻 Seção NUVEM: Chamar os endpoints da aplicação deployada na nuvem (heroku)
<br>
3️⃣ Utilizar as API's da NUVEM para integrar ao frontend:

    👉🏻 Os endpoints se encontram na seção NUVEM no workspace do postman
<br>
4️⃣ SEMPRE testar os endpoints antes de fazer PULL REQUEST:

    👉🏻 Jogar o endpoint em uma nova request do postman e testar localmente
<br>
5️⃣ Como fazer o commit:

    👉🏻 Criar uma branch nova com o mesmo nome da issue que consta no projeto
    
    👉🏻 Após as alterações, no terminal do IntelliJ, executar os seguintes comandos:
    
      👉🏻 git fetch
      
      👉🏻 git checkout [nome da branch]
      
      👉🏻 git status (os nomes dos arquivos devem estar vermelhos)
      
      👉🏻 git add .
      
      👉🏻 git status (os nomes dos arquivos agora devem estar verdes)
      
      👉🏻 git commit -m "Aqui você digita o que você mudou na aplicação através desse commit"
      
      👉🏻 git push
<br>
6️⃣ Como fazer o pull request:

    👉🏻 Entrar no repositório aqui no github
    
    👉🏻 Selecionar sua branch
    
    👉🏻 Apertar no botão de pull request
    
    👉🏻 Confirmar o pull request
<br>
7️⃣ Aguardar o merge:

    👉🏻 Eu faço o review do pull request
    
    👉🏻 Eu faço o merge da sua branch na main
<br>
8️⃣ Aguardar deploy:

    👉🏻 Eu realizo o deploy da aplicação pelo dashboard do heroku
<br>
9️⃣ Manter o fluxo de trabalho organizado:

    👉🏻 Sempre abrir issues (cards) no projeto para qualquer tarefa relacionada ao projeto
    
    👉🏻 Manter as issues no estágio correto de desenvolvimento (pronta pra fazer, em desenvolvimento,
    pronta pra teste, etc.)
    
    👉🏻 Fechar as issues quando concluídas
<br>
🔟 Endpoints

    👉🏻 Ao enviar um documento, verificar no banco de dados o envio do documento, via postman:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/usuario/{{usuarioId}}
      
    👉🏻 Para realizar o aceite do documento:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/documento/aceitar/{{usuarioId}}/{{documentoId}}
      
    👉🏻 Para recusar o documento:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/documento/recusar/{{usuarioId}}/{{documentoId}}
    
    👉🏻 Para visualizar os documentos pendentes de aprovação/reprovação:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/documento/pendentes/{{usuarioId}}
    
    👉🏻 Para visualizar os documentos aprovados:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/documento/aceitos/{{usuarioId}}
    
    👉🏻 Para visualizar os documentos recusados:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/documento/recusados/{{usuarioId}}
      
    👉🏻 Para fazer o download de um documento:
    
      👉🏻 https://complementa-ja.herokuapp.com/complementaja/documento/download/{{documentoId}}
      ✍🏻 Este endpoint só funciona pelo navegador, pelo postman ele não faz o download
 <br>
⚠ Qualquer dúvida, entrar em contato comigo
<br>
<br>
<br>
<br>
<br>
<p align="right">João Pedro Lazarim ✍🏻</p>
