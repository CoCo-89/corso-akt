	DROP DATABASE IF EXISTS Biblioteca;
	CREATE DATABASE Biblioteca;

	-- Una volta creato il database, devi selezionarlo
	-- per poter creare le tabelle al suo interno:
	USE Biblioteca;

	-- Creazione della tabella Editori
	CREATE TABLE Editori (
		id_editore INT PRIMARY KEY AUTO_INCREMENT,
		nome_editore VARCHAR(255) NOT NULL,
		sede VARCHAR(255)
	);

	-- Creazione della tabella Libri (con riferimento all'editore)
	CREATE TABLE Libri (
		id_libro INT PRIMARY KEY AUTO_INCREMENT,
		titolo VARCHAR(255) NOT NULL,
		anno INT,
		id_editore INT,
		FOREIGN KEY (id_editore) REFERENCES Editori(id_editore)
		-- Se un editore viene eliminato, imposta a NULL l'id_editore dei libri
		ON DELETE SET NULL 
		-- Se l'id_editore cambia, propaga la modifica ai libri
		ON UPDATE CASCADE 
	);
	-- ON DELETE e ON UPDATE: se il valore nella tabella di partenza (es:Editori) 
	-- viene eliminato, allora viene eseguita l'operazione indicata nella tabella
	-- attuale, nel campo dove è presente la FK	


	-- Creazione della tabella Autori
	CREATE TABLE Autori (
		id_autore INT PRIMARY KEY AUTO_INCREMENT,
		nome VARCHAR(100) NOT NULL,
		cognome VARCHAR(100) NOT NULL
	);

	-- Creazione della tabella di collegamento Libro_Autore
	CREATE TABLE Libro_Autore (
		id_libro INT,
		id_autore INT,
		PRIMARY KEY (id_libro, id_autore),
		FOREIGN KEY (id_libro) REFERENCES Libri(id_libro)
		-- Se un libro viene eliminato, elimina anche le righe in Libro_Autore
		ON DELETE CASCADE, 
		FOREIGN KEY (id_autore) REFERENCES Autori(id_autore)
		-- Se un autore viene eliminato, elimina anche le righe in Libro_Autore
		ON DELETE CASCADE 
	);

