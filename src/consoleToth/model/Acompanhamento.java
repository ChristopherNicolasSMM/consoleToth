package consoleToth.model;

import java.sql.Timestamp;

import org.postgresql.jdbc.TimestampUtils;

public class Acompanhamento {

	private int id;
	private int pacienteId;
	private int sessaoId;
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
	public int getSessaoId() {
		return sessaoId;
	}
	public void setSessaoId(int sessaoId) {
		this.sessaoId = sessaoId;
	}
	public Timestamp getDataSessao() {
		return dataSessao;
	}
	public void setDataSessao(Timestamp dataSessao) {
		this.dataSessao = dataSessao;
	}

}
