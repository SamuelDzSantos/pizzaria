/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Samuel e Christian
 * Created: 15/11/2023
 */
CREATE DATABASE db_pizza;
CREATE TABLE tb_cliente (
  id_cliente SERIAL NOT NULL,
  nome_cliente varchar(50) NOT NULL,
  sobrenome_cliente varchar(50) NOT NULL,
  telefone_cliente varchar(20) NOT NULL,
  endereco_cliente varchar(255) NOT NULL,
  PRIMARY KEY (id_cliente)
);
CREATE TABLE tb_forma_pizza (
  id SERIAL NOT NULL,
  nome varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE tb_idstatus (
  id SERIAL NOT NULL,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY(id)
);
CREATE TABLE tb_pedido (
  id_pedido SERIAL NOT NULL,
  id_status_pedido int DEFAULT NULL,
  id_cliente int DEFAULT NULL,
  UNIQUE(id_cliente),
  PRIMARY KEY (id_pedido)
);
CREATE TABLE tb_pedido_pizza (
  id SERIAL NOT NULL,
  id_pedido int DEFAULT NULL,
  id_sabor int DEFAULT NULL,
  id_forma int DEFAULT NULL,
  id_sabor2 int DEFAULT NULL,
  valor_pedido_item numeric(10, 2) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE (id_pedido)
);
CREATE TABLE tb_sabor (
  id_sabor SERIAL NOT NULL,
  nome_sabor varchar(50) NOT NULL,
  tipo_sabor int DEFAULT NULL,
  PRIMARY KEY (id_sabor)
);
CREATE TABLE tb_tipopizza (
  id_tipo int NOT NULL,
  nome_tipo varchar(50) NOT NULL,
  preco_tipo numeric(10, 2) DEFAULT NULL,
  PRIMARY KEY (id_tipo)
);
INSERT INTO tb_tipopizza (id_tipo, nome_tipo, preco_tipo)
VALUES ('1', 'Simples', '0.0');
INSERT INTO tb_tipopizza (id_tipo, nome_tipo, preco_tipo)
VALUES ('2', 'Especial', '0.0');
INSERT INTO tb_tipopizza (id_tipo, nome_tipo, preco_tipo)
VALUES ('3', 'Premium', '0.0');
INSERT INTO tb_idstatus (id, nome)
VALUES ('1', 'ABERTO');
INSERT INTO tb_idstatus (id, nome)
VALUES ('2', 'A CAMINHO');
INSERT INTO tb_idstatus (id, nome)
VALUES ('3', 'ENTREGUE');
INSERT INTO tb_forma_pizza (id, nome)
VALUES (1, 'CIRCULO');
INSERT INTO tb_forma_pizza (id, nome)
VALUES (2, 'QUADRADO');
INSERT INTO tb_forma_pizza (id, nome)
VALUES (3, 'TRIÂNGULO');