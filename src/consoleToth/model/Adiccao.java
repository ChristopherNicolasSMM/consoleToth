package consoleToth.model;

import org.postgresql.jdbc.TimestampUtils;

public class Adiccao {
	
	private int id;
	private String substancia;
	private TimestampUtils dataInicio;
	private TimestampUtils maiorAbst;
	private TimestampUtils tempoLimpo;
	
	
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
	public TimestampUtils getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(TimestampUtils dataInicio) {
		this.dataInicio = dataInicio;
	}
	public TimestampUtils getMaiorAbst() {
		return maiorAbst;
	}
	public void setMaiorAbst(TimestampUtils maiorAbst) {
		this.maiorAbst = maiorAbst;
	}
	public TimestampUtils getTempoLimpo() {
		return tempoLimpo;
	}
	public void setTempoLimpo(TimestampUtils tempoLimpo) {
		this.tempoLimpo = tempoLimpo;
	}
	
	
	


}
