# TrilhaBackEnd

# Desafio 4:
___________________________________________________________________________________________________________________________
Prólogo: Seu objetivo durante o desafio 4 é entender o papel da camada de persistência, a abstração da linguagem dos bancos 
de dados criada pelas ferramentas de ORM e a partir desse entendimento ser capaz de se comunicar com qualquer tipo de banco 
de dados independendo da sua linguagem nativa. O seu foco durante o desafio 2 deve estar em saber implementar suas próprias 
classes de repositório.

Neste desafio iremos abstrair os conceitos de banco de dados.

a) Com suas palavras conceitue: (máx 5 linhas/cada)
i. O que é JDBC?
R: Java Databse Connectivity é um conjunto de classes e interfaces (API) escritas em Java que realizam o envio de instruções SQL para qualquer 
banco de dados relacionais. Para cada tipo de banco de dados há um driver JDBC dividido em 4 categorias: 
Tipo 1: Ponte JDBC-ODBC
Tipo 2: Driver API-Nativo
Tipo 3: Driver Nativo
Tipo 4: Driver de Protocolo de Rede

ii. O que é ORM, cite 3 exemplos?
R: ORM (Object-Relational Mapping/Mapeamento Objeto-Relacional) é uma técnica bastante utilizada para converter dados entre bancos relacionais 
e linguagens orientadas a objeto, reduzindo assim o tempo gasto com a criação de Queries. Principais exemplos: Java - Hibernate/Active JPA; 
C# - Entity Framework/NHibernate; Python - Django/SqlAlchemy.

iii. O que é JPA e qual é a sua relação com os ORM’s?
R: JPA(Java Persistence API é uma coleção de classes e métodos voltados para a persistência de dados nos bancos de informação. A API de Persistência do 
Java é uma especificação de como o Mapeamento Objeto-Relacional deve ser implementado na plataforma JavaEE. Ou seja, o ORM é um conceito geral e o JAP 
define um padrão ORM de como deve funcionar o Java na prática. Assim facilita o processo de transformação dos dados que trafegam entre as aplicações 
e os bancos de dados e podemos utilizar ferramentas de persistência como o Hibernate.

iv. O que é Spring Data?
R: O Spring Data é um framework criado para ajudar desenvolvedores Java na sua integração com o banco de dados.

b) Instale, configure e teste um banco de dados SQL
Dica: https://www.baeldung.com/spring-boot-h2-database

c) Implemente uma interface repository (nossa camada de persistência) utilizando spring data e as entidades criadas no desafio anterior;

d) O que caracteriza um projeto “CRUD básico”? (máx 10 linhas);
R: Um projeto CRUD (acrônimo do inglês: Create=Criação, Read=Consulta, Update=Atualização e Delete=Destruição - de dados) utilizado essas
quatro operações básicas em banco de dados relacionais.


e) Com base nas classes de controller, use as interfaces desenvolvidas e crie os seguintes métodos e refatore os existentes se necessário:
i. Create
Path: /categorias
Method: POST
RequestBody: Tipo categoria
Response: Nova categoria com Id gerado
ii. Read
Path: /categorias
Method: GET
Response: Lista com todas categorias
FindById
Path: /categorias/{id}
Method: GET
RequestPath: long id
Response: Categoria identificada
iii. Update
Path: /categorias/{id}
Method: PUT
RequestBody: Tipo Categoria
Response: Categoria identificada atualizada
iv. Delete
Path: /categorias/{id}
Method: Delete
Response: Void 200 OK
v. Repita o item e para lançamentos;

f) Utilizando as interfaces repositor e os métodos criados anteriormente:
i. Crie um objeto do tipo categoria e o salve no banco de dados;
ii. Liste todas as categorias salvas no banco de dados;
iii. Edite a categoria criada anteriormente utilizando o identificador Id;
iv. Crie uma nova categoria e a salve no banco de dados;
v. Liste todas as categorias salvas no banco de dados;
vi. Delete a primeira categoria criada;
vii. Liste todas as categorias salvas no banco de dados;

viii. Crie um objeto do tipo lançamento, mas antes de salvar valide se o Id da categoria informada é válido, caso seja, 
salve o objeto criado no banco. Caso não seja, imprimir erro no console (println);
Obs: paid deve ser = true

ix. Crie um novo lançamento;
Obs: paid deve ser = false

x. Liste todos os lançamentos salvos no banco de dados;
xi. Liste todos os lançamentos pagos;
xii. Liste todos os lançamentos pendentes;
