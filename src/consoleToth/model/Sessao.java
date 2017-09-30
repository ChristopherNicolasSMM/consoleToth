package consoleToth.model;

public class Sessao {
	
	private int id;
	private int terapiaId;
	private String observacao;
	private double manipulacao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTerapiaId() {
		return terapiaId;
	}
	public void setTerapiaId(int terapiaId) {
		this.terapiaId = terapiaId;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public double getManipulacao() {
		return manipulacao;
	}
	public void setManipulacao(double manipulacao) {
		this.manipulacao = manipulacao;
	}

}
