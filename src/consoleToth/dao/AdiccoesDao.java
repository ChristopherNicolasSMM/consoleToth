package consoleToth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import consoleToth.model.*;

public class AdiccoesDao {

private Connection con = Conexao.getConnection();
	
	// SALVAR DINAMICO
	public void salva(Adiccoes adiccoes){
		String query ="";
		
		if(adiccoes.getId() > 0) {
			
			query = "update adiccoes set paciente_id = ?, adiccao_id = ?,  where id = " + adiccoes.getId();	
		}
		else {
			query = "insert into adiccoes (paciente_id, adiccao_id) "
					+ "values (?, ?)";
		}

		try{
			
			PreparedStatement preparador = con.prepareStatement(query);
			
			preparador.setInt(1, adiccoes.getPacienteId());
			preparador.setInt(2, adiccoes.getAdiccaoId());
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// BUSCA DINAMICA
	public List<Adiccoes> buscar(Adiccoes _adiccoes, int buscarPor){
		String query =  "select * from adiccoes";
		List<Adiccoes> lista = new ArrayList<Adiccoes>();
		
		switch (buscarPor) {
		
		case 0://	TODOS
			break;
		case 1://	ID
			query = query  + " where  id = " +  _adiccoes.getId(); 
			break;
		case 2://	PACIENTE
			query = query  + " where paciente_id = " +  _adiccoes.getPacienteId(); 
			break;
		case 3://	ADICCAO
			query = query  + " where adiccao_id = " +  _adiccoes.getAdiccaoId(); 
			break;


		}
		
		try{
			PreparedStatement preparador = con.prepareStatement(query);

			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Adiccoes adiccoes = new Adiccoes();
				adiccoes.setId(resultado.getInt("id"));
				adiccoes.setId(resultado.getInt("pacienteId"));
				adiccoes.setId(resultado.getInt("adiccaoId"));

				lista.add(adiccoes);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}

	
}
