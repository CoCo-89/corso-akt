-- data e ora attuali 
select now();
select now() as today; -- alternativa data_di_oggi
-- select now() as date; sempre meglio evitare l'utilizzo delle keyword come nomi di campi

select nome, cognome, year(now())-year(data_nascita) as anniversario_nascita from Autori where year(data_nascita) != 1000;
select 4+5;
select 4+5 as somma;
select 23 < 12;			-- ritorna un 0 o 1
select 12%5;			-- modulo come in java
select mod(12, 5);		-- sempre per scrivere modulo
select 34/22;			-- divisione decimale
select 34 div 22;		-- divisione intero della divisione

/*
Elenco delle CLAUSOLE di select. L'ordine deve essere rispettato con questa sequenza.
	SELECT campi (ulteriori clausole COUNT, DISTINCT, ecc..)
		FROM tabella
        JOIN o UNION
        WHERE condizione di ricerca
        GROUP BY raggruppa per espressione un insieme di righe
        HAVING altra condizione di ricerca
        ORDER BY ASC o DESC
		LIMIT numero massimo di righe visualizzate
*/
use world; 
show tables;
select * from city;
describe city;
select * from city where countrycode = 'ita';

select * from city where countrycode = 'ita' limit 10;

select distinct countrycode from city;

select * from city where name = 'Roma';

-- per ricerche ' approssimative' invece di = uso LIKE
select * from city where name like 'R%'; 
select * from city where name like 'Ro%';
-- % rappresenta un numero x di caratteri casuali 
-- invece _ underscore indica un singolo carattere jolly
select * from city where name like 'R__a';

-- GROUP BY

select countrycode from city
	where population > 200000
    group by countrycode;
    
use world;
select countrycode, COUNT(name) as Numero_di_citta -- conteggia e va a mappare quante città ha un countrycode
from city
where population > 200000
group by countrycode;

-- AND e OR
select name, population
	from city
    where population < 1000000 AND population < 2000000
    order by population desc;
    
select name, population
	from city
    where population between 1000000 and 2000000 -- fra
    order by name asc, population desc;
    
select name, population
from city
where name NOT LIKE "A%" -- diverso da
	AND (population between 1000000 and 2000000 or population > 3000000);