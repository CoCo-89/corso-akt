-- Le view (o viste)
/*
	Le viste sono generate tramite una query.
    Quando ho query complesse o che devo usare ricorrentemente le posso salvare in una VIEW richiamabile per nome.
*/
CREATE VIEW autori_ordinati AS
	SELECT cognome, nome, data_nascita
    FROM autori
    WHERE nome IS NOT NULL -- filtra qualcosa che sia diverso da NULL
    ORDER BY nome, cognome;

-- per usare una view faccio un normale select
select * from autori_ordinati;
select * from autori_ordinati
	where year(data_nascita) >= 1900; -- mostra solo quelli nati dopo il 1900



