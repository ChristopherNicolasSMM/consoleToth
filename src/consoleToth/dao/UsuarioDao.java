package consoleToth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import consoleToth.model.*;

public class UsuarioDao {

private Connection con = Conexao.getConnection();
	
	// SALVAR DINAMICO
	public void salva(Usuario usuario){
		String query ="";
		
		if(usuario.getId() > 0) {
			
			query = "update usuario set nome=?, login=?, senha=?, permissao=? where id = " + usuario.getId();	
		}
		else {
			query = "insert into usuario (nome, login, senha, permissao) "
					+ "values (?, ?, ?, ?)";
		}

		try{
			
			PreparedStatement preparador = con.prepareStatement(query);
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setString(4, usuario.getPermissao());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// BUSCA DINAMICA
	public List<Usuario> buscar(Usuario _usuario, int buscarPor){
		String query =  "select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		switch (buscarPor) {
		
		case 0://	TODOS
			break;
		case 1://	ID
			query = query  + " where " +  _usuario.getId()  ; 
			break;
		case 2://	NOME
			query = query  + " where nome like '%" +  _usuario.getNome()      + "%'"; 
			break;
		case 3://	ORIGEM
			query = query  + " where login like '%" +  _usuario.getLogin()    + "%'"; 
			break;
		case 4://	PRINCIPIO
			query = query  + " where permissao like '%" + _usuario.getPermissao()  + "%'";  
			break;
		}
		
		try{
			PreparedStatement preparador = con.prepareStatement(query);

			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setPermissao(resultado.getString("permissao"));
				lista.add(usuario);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
