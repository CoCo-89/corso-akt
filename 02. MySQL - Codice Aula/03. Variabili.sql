use libreria;
-- in mysql è possibile creare delle variabili
set @my_id := (select id_autore from autori
					where nome = "Oscar" and cognome = "Wilde");
                    
-- per stampare il nome della variabile:
select @my_id;

update autori set data_nascita = "1854-10-16" where id_autore = @my_id;

show variables; -- mostra le variabili
show global variables; -- mostra le variabili globali
show variables like "%admin%"; -- mostra le variabili  che specifichiamo

