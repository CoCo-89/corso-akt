package it.akt.model;



public class Fumetto {
	
	private Long id;
	private String titolo;
	private String editore;
	private int volume;
	
	public Fumetto() {
	}
	
	public Fumetto(Long id, String titolo, String editore, int volume) {
		this.setId(id);
		this.titolo = titolo;
		this.editore = editore;
		this.volume = volume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Fumetto [id=" + id + ", titolo=" + titolo + ", editore=" + editore + ", volume=" + volume + "]";
	}
	
	

}
