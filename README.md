Desafio 6:
____________________________________________________________
Prólogo: Seu objetivo durante o desafio 6 é conhecer o funcionamento das classes de DTO e a importância dessa prática que tem como viés de trazer maior segurança para a nossa aplicação.
a) O que significa DTO, e qual sua importância? (máx 10 linhas)

R: DTO(Data Transfer Object)







Dica: https://marioalvial.medium.com/blindando-sua-api-spring-boot-com-o-padr%C3%A3o-dto-44f97020d1a0
b) Com base no artigo passado, crie suas próprias classes de DTO’s para as entidades de lançamento e de categoria;
De maneira prática, as responses de uma Web API devem conter apenas as informações necessárias para a aplicação que fez a requisição. Vamos imaginar um cenário onde precisamos montar um gráfico onde vamos ter que somar o valor (amount) de todos lançamentos divididos por suas respectivas categorias. Então nesse panorama as únicas informações que nos importam é o nome da categoria, o tipo do lançamento, e a soma de todos os valores dos lançamentos para a categoria específica.
Ex: [ { name: 'Salário', type: 'revenue', total: 38566,34 }, { name: 'Aluguel', type: 'expense', total: 38566,34 } ]
c) Com base na informação anterior:
i. Crie uma classe (objeto) DTO chart;
ii. Crie um método dentro da classe de serviço de lançamentos e utilize o laço for para realizar o agrupamento por categoria e retornar uma lista de objetos do tipo DTO chart;
iii. Crie um método dentro da controller de lançamentos para retornar a lista criada no item anterior;
d) Agora vamos imaginar o seguinte cenário public Usuario transformaParaObjeto(){ return new Usuario(nome, email, senha, muitas, outras, variáveis, tornando, cada, vez, mais, trabalhoso, o, mapeamento, dos, dados); }
Assista o seguinte vídeo: https://www.youtube.com/watch?v=N3uAMuC-bxo
E em seguida este artigo: https://www.infoq.com/br/articles/dto-hipster-ou-depreciado/
Com base nos links anteriores, onde é apresentado uma nova forma de serialização dos dados. Implemente uma nova serialização dos dados utilizando Mapper.
