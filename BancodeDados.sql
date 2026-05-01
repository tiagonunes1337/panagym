CREATE DATABASE panagym;
USE panagym;

CREATE TABLE matricula (
    id bigint AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(70) NOT NULL,
    email VARCHAR(100), 
    telefone VARCHAR(20),
    cpf VARCHAR(14), -- 14 para suportar 000.000.000-00
    cartao VARCHAR(19) NOT NULL, 
    plano VARCHAR(20) NOT NULL -- Para salvar "Bronze", "Ouro" ou "Diamante"
);

