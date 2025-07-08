Este projeto é uma API REST desenvolvida com Spring Boot, utilizando Spring Web, Spring Data JPA e um banco de dados relacional (H2, PostgreSQL etc.).

A API permite gerenciar produtos com as seguintes operações:

⦁	    Criar produtos

⦁	    Listar todos os produtos

⦁	    Buscar um produto por ID

⦁	    Atualizar produtos

⦁	    Excluir produtos


1.	Entidade: ApiProduto.java
O que ela faz:

⦁	    Representa a tabela api_produto no banco de dados.

⦁	    A anotação @Entity marca a classe como persistente (JPA).

⦁	    O campo id é a chave primária, gerada automaticamente com @GeneratedValue.

⦁	    Os demais atributos (nome, preco, quantidade) representam colunas da tabela.


2. Repositório: ProdutoRepository.java
O que ele faz:
⦁	    É a ponte entre o controller e o banco de dados.

⦁	    Estende JpaRepository, que já fornece métodos prontos como:

⦁	     findAll(), findById(), save(), delete()...

⦁	    	Permite consultar, salvar, atualizar e deletar produtos sem escrever SQL.


3. Controlador: ProdutoController.java
Fluxo de funcionamento:

⦁	    O cliente faz uma requisição HTTP (via Postman, frontend, etc.).

⦁	    O ProdutoController recebe essa requisição.

⦁	    O controller chama os métodos do ProdutoRepository.

⦁	    O repositório acessa o banco de dados.

⦁	    A resposta (produto, erro, confirmação) é retornada ao cliente.


Tecnologias utilizadas

1.	    Java 17+
2.	    Spring Boot
3.	    Spring Web (REST Controller)
4.	    Spring Data JPA (Repositório)
5.	    Hibernate (ORM)
6.	    Banco de Dados Relacional (como H2, PostgreSQL, MySQL)
7.	    Maven (gerenciador de dependências)






