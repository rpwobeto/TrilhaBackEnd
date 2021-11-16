# TrilhaBackEnd

Desafio 3:
____________________________________________________________
Prólogo: Seu objetivo durante o desafio 3 é entender o básico a respeito do protocolo de comunicação mais utilizado da internet, e a partir desses 
princípios ser capaz de implementar suas próprias controllers a fim de se comunicar com uma aplicação de front-end, um micro serviço ou outros tipos de aplicações.
a) Com suas palavras defina: (máx 5 linhas)
i. O que é o protocolo de comunicação HTTP e como ele funciona;

R: O HTTP (Hypertext Transfer Protocol ou Protocolo de Transferência de Hipertexto em português) é um protocolo que especifica como será a comunicação 
entre um navegador e um servidor web via HTML, sendo um dos principais da World Wide Web (WWW). Trabalha sem configuração de segurança. 

(Resposta para complementação para os desafios) - R: é desenvolvido na camada de aplicação (por exemplo navegadores e servidores web) e trabalha junto com o TCP(Transmission Control Protocol) e o IP(Internet Protocol), 
gerando assim um Request e Response. Em resumo: o usuário acessa um browser, o browser organiza a solicação e envia ao servidor, o servidor encontra a página acessada, o servidor organiza a resposta e envia para o browser,
o browser resgata o HTML e compila em formato visual para o usuário.

ii. O que é REST, e qual é a sua relação com o protocolo HTTP;

R: O REST é um padrão de arquitetura que define como as camadas FrontEnd e BackEnd vão se comunicar por meios dos verbos HTTP(os mais utilizados: 
GET, POST, PUT, DELETE, que correspondem ao método CRUD: Create, Read, Update e Delete (or CRUD). Resumidamente: realizamos uma requisição ao BackEnd 
informando a URL e o verbo HTTP, de acordo com estes a API realiza uma ação, a API retorna os dados em JSON(e XML) e o FrontEnd pode utilizar esses dados
retornados. 

iii. O que é Web API, e qual é a sua relação com REST;

R: A Web API(Interface de Programação de Aplicações) que é utilizada tanto para o servidor quanto para o navegador. Podemos criar e disponibilizar serviços 
para o consumo de browsers(HTTP, ex: intranet com rede segura) e dispositivos móveis(HTTPS). A Web API deve ser construída de acordo com o estilo e padrões 
arquitetônicos do REST, pois assim podemos separar as "preocupações" do cliente e do servidor.


b) Liste todos os métodos de solicitações HTTP utilizados pelo padrão REST e suas respectivas finalidades;

R:
O método GET: geralmente é usado para solicitar que um servidor envie um recurso;
O método POST: envia dados de entrada para o servidor, é frequentemente usado para suportar formulários HTML;
O método PUT: edita e atualiza documentos em um servidor;
O método DELETE: deleta certo dado ou coleção do servidor.

c) Crie uma classe do tipo controller para a entidade categoria, e em seguida:
i. Declare uma variável dentro da controller: private List<SuaEntity> lista = new ArrayList<SuaEntity>();
ii. Crie os seguintes métodos:
iii. Create
Path: /categorias
Method: POST
RequestBody: Tipo categoria
Response: Retorna o número da posição em que foi inserido na lista;
iv. Read
Path: /categorias
Method: GET
Response: Retorna a variável lista;

d) Repita o item c para lançamentos;

e) Crie 2 objetos do tipo categoria;
f) Liste as categorias;
g) Crie 2 objetos do tipo lançamentos;
h) Liste os lançamentos ordenados por data;
Dica: https://www.youtube.com/watch?v=op81bMbgZXs

i) O que é Swagger? (máx 5 linhas)
R: É um framework composto por diversas ferramentas que auxiliam o consumo e a visualização de serviços da API REST,
independente da linguagem de programação.

j) Implemente o Swagger na sua Spring Rest API;
Dica: https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
k) Repita as letras e, f, g e h porém agora em vez de usar o postman, vamos usar o swagger;
