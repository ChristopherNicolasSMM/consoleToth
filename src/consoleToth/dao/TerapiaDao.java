package consoleToth.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import consoleToth.model.*;



public class TerapiaDao {
	
	private Connection con = Conexao.getConnection();
	
	// SALVAR DINAMICO
	public void salva(Terapia terapia){
		String query ="";
		
		if(terapia.getId() > 0) {
			
			query = "update terapia set nome = ?, origem = ?,"
					+ " principio = ?, substancia = ?  where id = " + terapia.getId();	
		}
		else {
			query = "insert into terapia (nome, origem, principio, substancia) "
					+ "values (?, ?, ?, ?)";
		}

		try{
			
			PreparedStatement preparador = con.prepareStatement(query);
			
			preparador.setString(1, terapia.getNome());
			preparador.setString(2, terapia.getOrigem());
			preparador.setString(3, terapia.getPrincipio());
			preparador.setString(4, terapia.getSubstancia());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// BUSCA DINAMICA
	public List<Terapia> buscar(Terapia _terapia, int buscarPor){
		String query =  "select * from terapia";
		List<Terapia> lista = new ArrayList<Terapia>();
		
		switch (buscarPor) {
		
		case 0://	TODOS
			break;
		case 1://	ID
			query = query  + " where " +  _terapia.getId()  ; 
			break;
		case 2://	NOME
			query = query  + " where nome like '%" +  _terapia.getNome()      + "%'"; 
			break;
		case 3://	ORIGEM
			query = query  + " where origem like '%" +  _terapia.getOrigem()    + "%'"; 
			break;
		case 4://	PRINCIPIO
			query = query  + " where principio like '%" + _terapia.getPrincipio()  + "%'";  
			break;
		case 5://	SUBSTANCIA
			query = query  + " where substancia like '%" + _terapia.getSubstancia() + "%'";  
			break;

		}
		
		try{
			PreparedStatement preparador = con.prepareStatement(query);

			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Terapia terapia = new Terapia();
				terapia.setId(resultado.getInt("id"));
				terapia.setNome(resultado.getString("nome"));
				terapia.setOrigem(resultado.getString("origem"));
				terapia.setPrincipio(resultado.getString("principio"));
				terapia.setSubstancia(resultado.getString("substancia"));
				lista.add(terapia);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}

}