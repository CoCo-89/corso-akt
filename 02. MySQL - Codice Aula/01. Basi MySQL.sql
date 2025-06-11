-- Commento in linea
/*
	Commento multi
	linea
*/

CREATE DATABASE IF NOT EXISTS Libreria;
USE Libreria;

CREATE TABLE IF NOT EXISTS Autori(
	id_autore	int primary key auto_increment,
    nome 		varchar(50),
    cognome		varchar(50) not null	-- not null è una constraint che obbliga a inserire un valore nel campo
);

-- drop table Autori; -- elimina la tabella

describe Autori;
alter table Autori modify nome varchar(30);	-- riduce la larghezza della colonna da 50 a 30 ma attenzione perchè potrebbe cancellare pezzi di parametri già inseriti

alter table Autori drop nome; -- elimina la colonna nome

alter table Autori add nome varchar(30); -- add column nome

select * from Autori; -- mostra tutte le colonne della tabella indicata

alter table Autori add nome varchar(30) first; -- posiziona come prima colonna

alter table Autori add nome varchar(30) after id_autore; -- posiziona dopo la colonna indicata 'id_autori'

alter table Autori rename column id_autore to idAutore; -- rinomina la colonna

/*
CANCELLAZIONE MULTIPLA DI COLONNE
alter table Autori
	drop column colonna1,
    drop column colonna2,
    ...
    drop column colonnaN;
*/

-- INSERIMENTO DATI NELLA TABELLA:
/*
insert into Autori (nome, cognome) values ("Ernest", "Hemingway");

insert into Autori (nome, cognome) values ("Oscar", "Wilde");

truncate table Autori; -- cancella tutto il contenuto della tabella senza toccare la struttura

select * from Autori;

-- INSERIMENTO DI RECORD MULTIPLI CON UN SOLO CAMPO PER RECORD
insert into Autori (cognome) values ("Faletti"),
									("Tolkien"),
                                    ("Clancy"),
                                    ("Fallaci");
*/
select nome from Autori; 
select concat (nome, " ", cognome) as nome_completo from Autori;

-- use world;
-- select * from libreria.Autori; -- posso specificare il database a cui accedere prima della tabella

select * from Autori;

-- tipo colonna 'date'
alter table autori add data_nascita date default '1000-01-01';
/*
insert into autori (nome, cognome, data_nascita) values
		('Luigi', 'Pirandello', '1867-06-28'),
        ('Umberto', 'Eco', '1932-01-05'),
        ('Agatha', 'Christie', '1890-09-15');*/

-- UPDATE `libreria`.`autori` SET `nome` = 'Giorgio' WHERE
-- (`id_autore` = '3');
-- Questo non funziona perchè devo identificare la riga in modo univoco
-- update autori set nome = 'Giorgio' where cognome = 'Clancy';

select * from Autori where cognome = 'Clancy';
update Autori set nome = 'Tom' where id_autore = 5;

update Autori set data_nascita = '1950-11-25',  nome = 'Giorgio' where id_autore = 3;
