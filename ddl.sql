create table Cliente (
id_cliente int not null primary key auto_increment,
nome varchar(100) not null,
cpf varchar(20) not null,
email varchar(100) not null,
telefone varchar(20) not null,
rua varchar(100) not null,
numero varchar(6),
bairro varchar(50) not null,
complemento varchar(120),
cep varchar(10) not null,
cidade varchar(50)not null,
estado varchar(2)not null
);

create table Fornecedor (
id_fornecedor int not null primary key auto_increment,
nomeFantasia varchar (100) not null,
cnpj varchar(20) not null,
email varchar(100) not null,
telefone varchar(20) not null,
rua varchar(100) not null,
numero varchar(6),
bairro varchar(50) not null,
complemento varchar(120),
cep varchar(10) not null,
cidade varchar(50)not null,
estado varchar(2)not null
);

create table Pedido (
id_pedido int not null primary key auto_increment,
dataCompra timestamp not null,
id_fornecedor int not null,
id_cliente int not null,
valorFrete double 
);

create table Produto (
id_produto int not null primary key auto_increment,
nome varchar(100) not null,
descricao varchar(500),
valorUnitario double 
);

create table Item (
id_item int not null primary key auto_increment,
id_produto int not null,
id_pedido int not null,
quantidade int not null
);
