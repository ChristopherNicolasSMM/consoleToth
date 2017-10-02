package consoleToth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import consoleToth.model.*;

public class SessaoDao {

	private Connection con = Conexao.getConnection();

	// SALVAR DINAMICO
	public void salva(Sessao sessao) {
		String query = "insert into sessao (paciente_id, terapia_id, observacoes, manipulacao, data_sessao) " 
		+ "values (?, ?, ?, ?, ?)";

		try {

			PreparedStatement preparador = con.prepareStatement(query);

			preparador.setInt(1, sessao.getPacienteId());
			preparador.setInt(2, sessao.getTerapiaId());
			preparador.setString(3, sessao.getObservacao());			
			preparador.setDouble(4, sessao.getManipulacao());
			preparador.setTimestamp(5, sessao.getDataSessao());
			preparador.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// BUSCA DINAMICA
	public List<Sessao> buscar(Sessao _sessao, int buscarPor) {
		String query = "select * from sessao";
		List<Sessao> lista = new ArrayList<Sessao>();

		switch (buscarPor) {

		case 0:// TODOS
			break;
		case 1:// ID
			query = query + " where id = " + _sessao.getId();
			break;
		case 2:// PACIENTE
			query = query + " where paciente_id = " + _sessao.getPacienteId();
			break;
		case 3:// TERAPIA
			query = query + " where terapia_id = " + _sessao.getTerapiaId();
			break;

		}

		try {
			PreparedStatement preparador = con.prepareStatement(query);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Sessao sessao = new Sessao();
				sessao.setId(resultado.getInt("id"));
				sessao.setPacienteId(resultado.getInt("paciente_id"));
				sessao.setTerapiaId(resultado.getInt("terapia_id"));
				sessao.setObservacao(resultado.getString("observacoes"));
				sessao.setManipulacao(resultado.getDouble("manipulacao"));
				sessao.setDataSessao(resultado.getTimestamp("data_sessao"));
				lista.add(sessao);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
