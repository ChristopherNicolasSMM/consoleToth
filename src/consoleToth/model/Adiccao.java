package consoleToth.model;

import java.sql.Timestamp;



public class Adiccao {
	
	private int id;
	private String substancia;
	private Timestamp dataInicio;
	private Timestamp maiorAbst;
	private Timestamp tempoLimpo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubstancia() {
		return substancia;
	}
	public void setSubstancia(String substancia) {
		this.substancia = substancia;
	}
	public Timestamp getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Timestamp getMaiorAbst() {
		return maiorAbst;
	}
	public void setMaiorAbst(Timestamp maiorAbst) {
		this.maiorAbst = maiorAbst;
	}
	public Timestamp getTempoLimpo() {
		return tempoLimpo;
	}
	public void setTempoLimpo(Timestamp tempoLimpo) {
		this.tempoLimpo = tempoLimpo;
	}
	
	
	


}
