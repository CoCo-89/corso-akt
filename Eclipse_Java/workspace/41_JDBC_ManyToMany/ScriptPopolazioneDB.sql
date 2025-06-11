	-- Inserimento di dati nella tabella Editori
	INSERT INTO Editori (nome_editore, sede) VALUES
	('Bompiani', 'Milano'),
	('Einaudi', 'Torino'),
	('Mondadori', 'Segrate'),
	('Salani', 'Milano'),
	('Adelphi', 'Milano');

	-- Inserimento di dati nella tabella Libri (con riferimento all'editore)
	INSERT INTO Libri (titolo, anno, id_editore) VALUES
	('Il Signore degli Anelli', 1954, 1), -- Bompiani
	('Lo Hobbit', 1937, 1), -- Bompiani
	('Il Simarillion', 1977, 1), -- Bompiani
	('Orgoglio e Pregiudizio', 1813, 2), -- Einaudi
	('Fondazione', 1951, 3), -- Mondadori
	('Le Cronache di Narnia', 1950, 4), -- Salani
	('Harry Potter e la Pietra Filosofale', 1997, 5), -- Adelphi (ipotetico)
	('Harry Potter e la Camera dei segreti', 1998, 5), -- Adelphi (ipotetico)
	('Harry Potter e il prigioniero di Azkaban', 1999, 5), -- Adelphi (ipotetico)
	('Harry Potter e il Calice di fuoco', 2000, 5), -- Adelphi (ipotetico)
	('1984', 1949, 2), -- Einaudi
	('Il Piccolo Principe', 1943, 1), -- Bompiani
	('Neuromante', 1984, 3); -- Mondadori

	-- Inserimento di dati nella tabella Autori
	INSERT INTO Autori (nome, cognome) VALUES
	('J.R.R.', 'Tolkien'),
	('Jane', 'Austen'),
	('Isaac', 'Asimov'),
	('C.S.', 'Lewis'),
	('J.K.', 'Rowling'),
	('George', 'Orwell'),
	('Antoine', 'de Saint-Exupéry'),
	('William', 'Gibson'),
	('Christopher', 'Tolkien');


	-- Inserimento di dati nella tabella Libro_Autore per stabilire le relazioni
	INSERT INTO Libro_Autore (id_libro, id_autore) VALUES
	(1, 1), -- Il Signore degli Anelli - J.R.R. Tolkien
	(2, 1), -- Lo Hobbit - J.R.R. Tolkien
	(3, 9), -- Il Simarillion - Christopher Tolkien
	(4, 2), -- Orgoglio e Pregiudizio - Jane Austen
	(5, 3), -- Fondazione - Isaac Asimov
	(6, 4), -- Le Cronache di Narnia - C.S. Lewis
	(7, 5), -- Harry Potter e la Pietra Filosofale - J.K. Rowling
	(8, 5), -- Harry Potter e la Camera dei segreti - J.K. Rowling
	(9, 5), -- Harry Potter e il prigioniero di Azkaban - J.K. Rowling
	(10, 5), -- Harry Potter e il Calice di fuoco - J.K. Rowling
	(11, 6), -- 1984 - George Orwell
	(12, 7), -- Il Piccolo Principe - Antoine de Saint-Exupéry
	(13, 8); -- Neuromante - William Gibson
	
	