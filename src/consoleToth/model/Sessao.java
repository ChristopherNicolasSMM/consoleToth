package consoleToth.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public class Sessao {
	
	private int id;
	private int pacienteId;
	private int terapiaId;
	private String observacao;
	private Double manipulacao;
	private Timestamp dataSessao;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
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
	public Double getManipulacao() {
		return manipulacao;
	}
	public void setManipulacao(Double manipulacao) {
		this.manipulacao = manipulacao;
	}
	public Timestamp getDataSessao() {
		return dataSessao;
	}
	public void setDataSessao(Timestamp dataSessao) {
		this.dataSessao = dataSessao;
	}
	


}
