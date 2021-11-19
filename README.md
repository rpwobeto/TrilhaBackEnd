# Desafio 5:

Prólogo: Seu objetivo durante o desafio 5 é conhecer mais uma das camadas de uma aplicação, sendo capaz de entender qual o papel de cada uma das camadas apresentadas até o momento, e por consequência saber replicar seus conceitos para diferentes tipos de projetos.

a) Defina com suas palavras qual é a responsabilidade das camadas vistas até agora, entity, controller, repository e service. (máx 10 linhas)

Por intermédio do Design Patterns acessamos a/o:

Entity: É uma camada que realiza o mapeamento das tabelas do banco de dados. Para cada tablea do banco precisaremos de umaq classe na camada de entidades. O objeto que for instanciado a partir desta classe faz referência a tabela criada no banco de dados.

Controller: pode ser chamado também de EndPoint, pois esta camada é responsável por definir a URL e o método HTTP da requisição(realizamos essa ação ao incluir a Annotation @RequestMapping) de forma realizar a gestão da comunicação da API REST. Esta processa os dados inseridos e repassa para outras camadas.

Repository: É a camada de persitência de dados responsável pela interação com o banco de dados. No repository podemos identificar parte da regra de negócios no que se refere a composição das Entities.

Service: É a camada responsável pela intermediação da comunicação entre um controller e uma camada do repository, nela construímos a lógica de validação.

De maneira prática, as controllers de uma Web API devem ser responsáveis apenas pela gestão da comunicação da nossa aplicação. No entanto se analisarmos o método create da nossa controller de lançamentos podemos verificar que ela está sendo responsável por verificar a veracidade do categoryId antes de criar um novo lançamento. Uma boa prática de desenvolvimento é separarmos essas atribuições em uma classe de serviço.

a) Com base na informação anterior: i. Crie uma classe de serviço para lançamentos; ii. Crie um método dentro na nova classe de serviço para validar categoria pelo ID; Ex: public boolean validateCategoryById(long idCategory) {} iii. Refatore a controller de lançamentos para utilizar o método validateCategoryById();
