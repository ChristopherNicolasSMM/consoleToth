package consoleToth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import consoleToth.model.*;

public class AdiccaoDao {

	
	private Connection con = Conexao.getConnection();
	
	// SALVAR DINAMICO
	public void salva(Adiccao adiccao){
		String query ="";
		
		if(adiccao.getId() > 0) {
			
			query = "update adiccao set substancia = ?, data_inicio = ?,"
					+ " maior_abst = ?, tempo_limpo = ?  where id = " + adiccao.getId();	
		}
		else {
			query = "insert into adiccao (substancia, data_inicio, maior_abst, tempo_limpo) "
					+ "values (?, ?, ?, ?)";
		}

		try{
			
			PreparedStatement preparador = con.prepareStatement(query);
			
			preparador.setString(1, adiccao.getSubstancia());
			preparador.setTimestamp(2, adiccao.getDataInicio());
			preparador.setTimestamp(3, adiccao.getMaiorAbst());
			preparador.setTimestamp(4, adiccao.getTempoLimpo());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// BUSCA DINAMICA
	public List<Adiccao> buscar(Adiccao _adiccao, int buscarPor){
		String query =  "select * from adiccao";
		List<Adiccao> lista = new ArrayList<Adiccao>();
		
		switch (buscarPor) {
		
		case 0://	TODOS
			break;
		case 1://	ID
			query = query  + " where id = " +  _adiccao.getId()  ; 
			break;
		case 2://	SUBSTANCIA
			query = query  + " where substancia like '%" + _adiccao.getSubstancia() + "%'";  
			break;

		}
		
		try{
			PreparedStatement preparador = con.prepareStatement(query);

			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Adiccao adiccao = new Adiccao();
				adiccao.setId(resultado.getInt("id"));
				adiccao.setSubstancia(resultado.getString("substancia"));
				adiccao.setDataInicio(resultado.getTimestamp("data_inicio"));
				adiccao.setMaiorAbst(resultado.getTimestamp("maior_abst"));
				adiccao.setTempoLimpo(resultado.getTimestamp("tempo_limpo"));
				lista.add(adiccao);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
}
