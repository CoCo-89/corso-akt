
	-- Crea il database 'universita' se non esiste già
	CREATE DATABASE IF NOT EXISTS universita;

	-- Seleziona il database 'universita' per le operazioni successive
	USE universita;

	-- Crea la tabella 'studenti' se non esiste già
	CREATE TABLE IF NOT EXISTS studenti (
		id INT AUTO_INCREMENT PRIMARY KEY,
		nome VARCHAR(50) NOT NULL,
		cognome VARCHAR(50) NOT NULL
	);

	-- Inserisci alcuni dati di esempio nella tabella 'studenti'
	INSERT INTO studenti (nome, cognome) VALUES
	('Alice', 'Rossi'),
	('Bob', 'Bianchi'),
	('Charlie', 'Verdi');

	-- (Opzionale) Visualizza tutti i dati dalla tabella 'studenti' per verificare l'inserimento
	SELECT * FROM studenti;



