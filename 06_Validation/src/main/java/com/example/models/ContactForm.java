package com.example.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ContactForm {

/*In questo caso, abbiamo utilizzato le annotazioni “base” presenti nel package jakarta.validation.constraints 
 * ma è possibile implementare annotazioni custom per definire regole e logiche di validazione più complesse	*/ 
	@NotEmpty
	@Size(max=50)
	private String firstName;
	
	@NotEmpty //utilizzata per validare che una collezione, una mappa o una stringa non sia nulla e non sia vuota.
	@NotBlank //utilizzata per validare che una stringa non sia nulla e non contenga solo spazi vuoti.
	@Size(max=100)
	private String lastName;
	
	@NotEmpty
	@Size(max=20)
	private String phone;
	
	@Email  //fa una valutazione standard controllando solo se esiste @
	@Size(max=100)
	private String email;
/*	
	Per eseguire un controllo più preciso posso usare una regex	
	    @Pattern( 		
	            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
	            message = "Formato email non valido"
	        )
	    private String email;
     
	Cosa fa la regex:
		[A-Za-z0-9._%+-]+ 	→ parte locale (prima della @)
		@ 					→ obbligatoria
		[A-Za-z0-9.-]+ 		→ dominio
		\\.[A-Za-z]{2,} 	→ TLD (es. .com, .it)        
	 
*/
	
// 	PASSWORD:
/*	
	@NotBlank
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-\\[\\]{}|;:,.<>?]).{10,}$",
        message = "La password deve contenere almeno 10 caratteri, con almeno una maiuscola, una minuscola, un numero e un simbolo speciale"
    )
    private String password;
    
    SPIEGAZIONE:
    Componente	Significato
		(?=.*[a-z])			almeno una lettera minuscola
		(?=.*[A-Z])			almeno una lettera maiuscola
		(?=.*\\d)			almeno un numero
		[!@#$%^&*()_+=\-\[\]{}|;:,.<>?]		[!@ indica almeno uno tra i simboli indicati
		.{10,}				almeno 10 caratteri totali
		^...$				inizio e fine della stringa (regex completa)
*/	
	
	public ContactForm() {}
	
	public ContactForm(@NotEmpty @Size(max = 50) String firstName, @NotEmpty @Size(max = 100) String lastName, @NotEmpty @Size(max = 20) String phone, @Email @Size(max = 100) String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	//più getters e setters
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
}
