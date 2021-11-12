# Trilha Back End Java #

## Desafio 2 ##

____________________________________________________________
Prólogo: Seu objetivo durante o desafio 2 deve ser entender o conceito de POO, entender cada um de seus pilares e também as possibilidades que eles nos 
proporcionam no desenvolvimento de API’s. Além do entendimento desses conceitos, o foco deve estar em saber criar as suas próprias classes de entidade;

a)	Com suas palavras defina o que é programação orientada a objetos (POO) e cite seus pilares? (máx 10 linhas)
R: POO é um estilo de programação (paradigma) que englobam um número de técnicas específicas(abstração, encapsulamento, herança e polimorfirmo) e a classe é um 
tipo de dado que tem muitos recursos e por meio dela podemos criar nossos tipos de dados, ou seja, transformar o real em abstrato no ambiente de programação.


A POO tem 4 pilares: Abstração, encapsulamento, herança e polimorfismo. 
b)	Exemplifique e explique um cenário de abstração; 
R:  Em uma aplicação bancária podemos ter a classe abstrata “Pessoa” com os atributos: nome, sobrenome, endereço, telefone, email. Estas propriedades são genéricas.

c)	Exemplifique e explique um cenário de encapsulamento;
R:  O encapsulamento é a capacidade de esconder detalhes da implementação do objeto, permitindo acesso somente a aqueles que devem ser acessados publicamente, 
dando segurança.  Por exemplo: o atributo Cliente da conta seja somente para leitura (ou seja: é cliente ou não é cliente), acessando a modificação do atributo, sem acessar a classe/aplicação para entender o método utilizado para saber se ele é cliente ou não.

d)	Exemplifique e explique um cenário de herança;
R: Na herança da classe Pai, as propriedades, características, eventos, métodos e soluções da classe abstrata “Pessoa” podem ser utilizadas em classes concretas 
(pessoaJurídica e pessoaFísica), por exemplo. Mas só podem ser acessados  o que está  registrado como público ou protegido, o que é privado a classe que herda 
não tem acesso.

e)	Exemplifique e explique um cenário de polimorfismo;
R:  No polimorfismo o objeto pode ter mais de um comportamento de acordo com a chamada recebida por ele.  Por exemplo: o cliente pode realizar um pagamento 
(classe abstrata com o método pagar - não tem algoritmo nele, pois não sabemos se ele vai ser feito em dinheiro, cartão, etc), faço a implementação dessa 
classe abstrata na minha classe concreta (por exemplo pagamento em dinheiro) e dentro desta classe concreta é que vou criar o algoritmo de pagamento em 
dinheiro, ou seja, o objeto pagamento se comportando como pagamento em dinheiro.

f)	Cite 5 vantagens da POO;
R:  1) Permite uma melhor representação do mundo real na criação de aplicações; 
      2) As aplicações tornam se mais fáceis de se ler e compreender; 
      3) Pode haver um “aumento” na velocidade da programação;
      4) Auxilia na criação de programas de forma a “facilitar” o seu desenvolvimento;
      5) Melhora a manutenção, modificação e/ou a criação de novos objetos existentes de um programa.   

g)	Agora vamos imaginar um sistema de controle financeiro, onde teremos dois tipos de entidades, categoria e lançamento. Categoria, será nossa forma de 
agrupar os lançamentos (Exemplo de categorias: Lazer, Saúde, Alimentação, Salário, Freela, etc). O lançamento por sua vez poderá ter os seguintes estados, 
se é despesa ou receita, se está pago ou pendente, data do acontecimento e valor;

Entidade	Características	Ações
Categoria
(Category)	id (long), name (string), description (string)	getId, setId, getName, setName, getDescription, setDescription, toString
Lançamento
(Entry)	id (long), name (string), description (string), type (string), amount (string), date (string), paid (boolean), categoryId (long)	getId, setId, 
getName, setName, getDescription, setDescription, getType, setType, getAmount, setAmount, getDate, setDate, getPaid, isPaid, getCategoryId, setCategoryId, toString

// Exemplo de categoria
{ 
id: 4, 
      name: 'Salário', 
      description: 'Recebimento de Salário' 
}

// Exemplo de lançamento
{ 
      id: 3, 
      name: 'Salário na Empresa X',
      description: 'Adiantamento quinzenal', 
      type: "revenue",
      amount: "4405,49", 
      date: "15/09/2021", 
      paid: true, 
      categoryId: 4 
}


Hands-on:
i.	Implemente uma classe para cada entidade com suas respectivas características e ações;
ii.	Implemente 2 construtores para cada entidade, um vazio e outro completo;
iii.	Implemente um método toString() para cada entidade;
Agora em tempo de execução:
iv.	Crie um objeto do tipo categoria utilizando o construtor para popular;
v.	Crie um objeto do tipo categoria, porém agora vazio e utilize os métodos set para popular o objeto;
vi.	Realize um println com o método toString() para cada um dos objetos criados;
vii.	Repita os passos 4, 5, 6 para lançamentos;
Dica: Entre no site https://start.spring.io/ e gere um projeto spring.
Group: trilha.back
Artifact/Name: financys
package trilha.back.finacys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinacysApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinacysApplication.class, args);

        // Insira seu código aqui
    }

}
