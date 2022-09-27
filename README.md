# jdbc-project
Este é um projeto relacionado a estudo de conexão e uso do java com banco de dados.

Consulte **[Implantação](#-implanta%C3%A7%C3%A3o)** para saber como implantar o projeto.

## 🚀 Começando

Para executar o projeto, será necessário instalar os seguintes programas:

[IntelliJ](https://www.jetbrains.com/pt-br/idea/) - Desenvolvimento do projeto Java

[Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - Execução do projeto Java.

[MySQL](https://www.mysql.com/) - Banco de dados

## 📋 Pré-requisitos

Para a execução da aplicação você precisará de uma IDE, e um SGBD.

## 🔧 Instalação

Etapa de explicação para instalação de componentes necessários:

### IntelliJ:
1. O instalador pode ser baixado da página de download selecionando o sistema operacional e a edição necessária. 
2. Após o download, abra o instalador e siga as instruções na tela para instalá-lo. 
3. Após a instalação, um atalho será criado na área de trabalho e o menu iniciar para abrir a IDE.

### Java JDK 17
Para instalar o JDK no Linux ou no Windows primeiramente é necessário efetuar o download do arquivo de instalação. Para isso deve-se acessar o site da [Oracle](https://www.oracle.com/java/technologies/downloads/#java17) e baixar versão 17 do JDK correspondente ao sistema operacional e arquitetura (32 ou 64 bits) utilizada.

Após o download efetue a instalação, você poderá acessar o tutorial completo para instalção [neste link](https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749).

### MySQL 
Primeiramente, acesse a página de download do [instalador do MySQL](https://dev.mysql.com/downloads/installer/).

Como vamos instalar o SGBD do MySQL, vamos baixar o instalador global do Mysql, ou seja, o MySQL Installer.

* Observação: Nós escolhemos a Community, pois é a versão gratuita. 😊

Após baixar o instalador do MySQL, execute-o e siga o [tutorial completo para instalação](https://dicasdeprogramacao.com.br/como-instalar-o-mysql-no-windows/).

## ⚙️ Desenvolvimento 

1. Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:
```
cd "diretorio de sua preferencia"
git clone https://github.ibm.com/Leypoiani/jdbc-project.git
```

2. Execute a IDE, navegue pelo seu computador e selecione o projeto para visualiza-lo.

3. No MySQL, crie um novo DataBase com o nome project e certifique-se de que ele esteja rodando na porta 3306.

5. Substitua no arquivo db.properties, presente na pasta sources do projeto, as configurações do banco de dados referente usuário, senha, e nome do banco de dados.

```
user=seuUser
password=SuaSenha
dburl=jdbc:mysql://localhost:3306/NomeBD
useSSl=false
```

5. Popule o banco executando o script abaixo.

Create table Department(
	Id INT PRIMARY KEY,
	Name VARCHAR (20));

Create table seller(
	Id INT PRIMARY KEY,
	Name VARCHAR (20),
	Email VARCHAR (30),
	BirthDate DATE,
	BaseSalary DOUBLE,
	CONSTRAINT DepartmentId FOREIGN KEY (DepartmentId) REFERENCES Department (Id)
);


Insert into department (Id, Name) VALUES (1, 'Financeiro');

Insert into department (Id, Name) VALUES (2, 'Comercial');

Insert into department (Id, Name) VALUES (3, 'PCM');

Insert into seller 
(Name, Email, BirthDate, BaseSalary, DepartmentId) 
VALUES ('Maria Cunha', 'maria@gmail.com', 01/01/2000, 2000.0, 1);

Insert into seller 
(Name, Email, BirthDate, BaseSalary, DepartmentId) 
VALUES ('José Silva', 'jSilva@gmail.com', 01/08/1997, 6000.0, 3);

Insert into seller 
(Name, Email, BirthDate, BaseSalary, DepartmentId) 
VALUES ('Antonio Siqueira', 'tony@gmail.com', 19/04/1987, 5000.0, 3);

Insert into seller 
(Name, Email, BirthDate, BaseSalary, DepartmentId) 
VALUES ('Jessica Toledo', 'jeska@gmail.com', 20/04/1998, 3000.0, 2);



## ⌨️ Features

1. Onboarding de registros. 
2. Consulta de dados por ID.
3. Consulta de lista.
4. Salvar, atualizar e deletar registros da base de dados.

## 📦 Implantação 
Vá até o arquivo Program referente a cada DAO e execute conforme desejar para efetuar as operações CRUD presentes nas classes DAO.

## 🛠️ Construído com

* [MySQL](https://www.mysql.com/) - Banco de dados
* [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - Linguagem de programação
* [IntelliJ](https://www.jetbrains.com/pt-br/idea/) - IDEA
* [Git](https://git-scm.com/) - Versionamento
* [GitHub](https://github.com/) - Repositório remoto
## ✒️ Autoria

* **Leianny Poiani** - [Leianny-Poiani](https://github.ibm.com/Leianny-Poiani)
---
⌨️ com ❤️ por [Leianny Poiani](https://github.ibm.com/Leianny-Poiani) 
