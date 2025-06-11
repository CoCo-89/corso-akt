-- Join
/*
La normalità operativa è quella di lavorare su più tabelle collegate tra loro.
Il collegamento avviene usando la Primary Key di una tabella e impostandola come Foreign Key nella nuova tabella che deve essere collegata a quella esistente
*/
use libreria;
create table if not exists Libri(
	id_libro 	int primary key auto_increment,
    titolo		varchar(100) not null,
    idAutore	int,
    foreign key (idAutore) references Autori(id_autore) -- la chiave esterna idAutore si riferisce alla tabella Autori dell'id_autore
);

-- una versione più professionale e formale è questa:
create table if not exists Libri(
	id_libro	int auto_increment,
    titolo		varchar(100) not null,
    idAutore	int,
    constraint	pk_libri primary key(id_libro),
    constraint	fk_libri_autori foreign key	(id_libro) references Autori(id_autore)
    -- manca ancora on update e on delete
);

select * from LIBRI;
select * from AUTORI;

select titolo, nome, cognome -- metodo per i join
	from autori
    inner join libri
    on libri.idAutoreFk = Autori.id_autore; -- si possono scambiare di posizione
    
/*
create view libri_e_autori as
	select titolo, nome, cognome
		from autori
        inner join libri
        on libri.idAutoreFk = Autori.id_autore;
        
        select * from libri_e_autori;
*/
-- 						if( condizione			, se_vera, se_falsa)
select titolo, concat(	IF (Autori.nome IS NOT NULL, nome, "Sconosciuto"), " ", cognome)
	from autori
    inner join libri
    on libri.idAutoreFk = autori.id_autore;
    
select titolo, concat(IFNULL (NOME, ""), " ", cognome) as Autore
	from autori
    inner join libri
    on libri.idAutoreFk = autori.id_autore;
    
-- facciamo un RIGHT OUTER JOIN esclusivo che estragga solo i libri che non hanno riferimenti nella tabella autori

select * from 
	autori A right join libri L -- A e L sono alias per la tabella autori e tabella libri
	on A.id_autore = L.idAutoreFk -- una volta creati alias vanno utilizzati sempre quelli
    where idAutoreFk is null;
    
-- inseriamo degli autori che non abbiano libri abbinati
/*
insert into autori (nome, cognome) values
	("George", "Orwell"),
	("Licia", "Troisi"),
	("Elena", "Ferrante");
    
insert into autori (nome, cognome, data_nascita) values
	("Valerio Massimo", "Manfredi", "1943-03-08"),
    ("Dan", "Brown", "1964-06-22");
  */
select * from autori;
-- ANTI SEMI JOIN mi permette di estrarre tutti gli autori che non hanno libri abbinati.
select * from autori
		where not exists (select * from libri L 
							where autori.id_autore = L.idAutoreFk
                            );
-- cross join - da non fare su grandi DB. per ottenerlo è sufficiente omettere la clausola ON
select * from autori join libri;

-- fa un cross join e conta le righe che ci sono
select
	row_number() over () as numero_riga,
    nome,
    cognome,
    titolo
from autori
join libri;

select * from city join country;