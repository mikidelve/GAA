package Entita;

import integration.StrumentoDAO;

public class Strumento {
	private String Nome;
	private String Modello;
	private String Tipo;
	private String AnnoAcquisto;
	private String Proprietario;
	private String Ubicazione;
	private StrumentoDAO dao;

	public Strumento() {
		dao = new StrumentoDAO();	
	}
	
	public Strumento(String nome, String modello, String tipo, String annoAcquisto, String proprietario,
			String ubicazione) {
		super();
		Nome = nome;
		Modello = modello;
		Tipo = tipo;
		AnnoAcquisto = annoAcquisto;
		Proprietario = proprietario;
		Ubicazione = ubicazione;
		dao = new StrumentoDAO();
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getModello() {
		return Modello;
	}

	public void setModello(String modello) {
		Modello = modello;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getAnnoAcquisto() {
		return AnnoAcquisto;
	}

	public void setAnnoAcquisto(String annoAcquisto) {
		AnnoAcquisto = annoAcquisto;
	}

	public String getProprietario() {
		return Proprietario;
	}

	public void setProprietario(String proprietario) {
		Proprietario = proprietario;
	}

	public String getUbicazione() {
		return Ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		Ubicazione = ubicazione;
	}
}
