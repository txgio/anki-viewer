package io.txg.ankiviewer;

import java.util.List;

public class Note {

	private String id;
	private List<Field> campos;

	public Note(String id, List<Field> campos) {
		this.id = id;
		this.campos = campos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Field getCampo(int ordem) {
		return campos.get(ordem - 1);
	}

	public List<Field> getCampos() {
		return campos;
	}

	public void setCampos(List<Field> campos) {
		this.campos = campos;
	}

}
