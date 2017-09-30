package consoleToth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import consoleToth.model.*;

public class PacienteDao {

private Connection con = Conexao.getConnection();
	
	// SALVAR DINAMICO
	public void salva(Paciente paciente){
		String query ="";
		
		if(paciente.getId() > 0) {
			
			query = "update paciente set nome=?, data_nascimento=?, sexo=?, cpf=?, naturalidade=?,"
					+ " cep=?, logradouro=?, numero=?, complemento=?, bairro=?, cidade=?,"
					+ " estado=?, pais=?  "
					+ "where id = " + paciente.getId();	
		}
		else {
			query = "insert into paciente (nome, data_nascimento, sexo, cpf, naturalidade,"
					+ " cep, logradouro, numero, complemento, bairro, cidade, estado, pais) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}

		try{
			
			PreparedStatement preparador = con.prepareStatement(query);
			
			preparador.setString(1, paciente.getNome());
			preparador.setTimestamp(2, paciente.getDataNascimento());
			preparador.setString(3, paciente.getSexo());
			preparador.setString(4, paciente.getCpf());
			preparador.setString(5, paciente.getNaturalidade());
			preparador.setString(6, paciente.getCep());
			preparador.setString(7, paciente.getLogradouro());
			preparador.setInt(8, paciente.getNumero());
			preparador.setString(9, paciente.getComplemento());
			preparador.setString(10, paciente.getBairro());
			preparador.setString(11, paciente.getCidade());
			preparador.setString(12, paciente.getEstado());
			preparador.setString(13, paciente.getPais());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// BUSCA DINAMICA
	public List<Paciente> buscar(Paciente _paciente, int buscarPor){
		String query =  "select * from paciente";
		List<Paciente> lista = new ArrayList<Paciente>();
		
		switch (buscarPor) {
		
		case 0://	TODOS
			break;
		case 1://	ID
			query = query  + " where id = " +  _paciente.getId()  ; 
			break;
		case 2://	NOME
			query = query  + " where nome like '%" +  _paciente.getNome() + "%'"; 
			break;
		case 3://	CPF
			query = query  + " where cpf like '%" +  _paciente.getCpf()    + "%'"; 
			break;
		case 4://	Cidade
			query = query  + " where cidade like '%" + _paciente.getCidade()  + "%'";  
			break;

		}
		
		try{
			PreparedStatement preparador = con.prepareStatement(query);

			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Paciente paciente = new Paciente();
				paciente.setId(resultado.getInt("id"));
				paciente.setNome(resultado.getString("nome"));

				lista.add(paciente);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
