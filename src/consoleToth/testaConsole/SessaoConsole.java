package consoleToth.testaConsole;

import java.util.List;
import consoleToth.dao.*;
import consoleToth.model.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SessaoConsole {

	public void executar() {
		 salvar();
		 
		 List<Sessao> listar = buscar();
		
		for (Sessao sessao : listar) {
			System.out.println("ID : " + sessao.getId());
			System.out.println("Paciete ID : " + sessao.getPacienteId());
			System.out.println("Terapia ID : " + sessao.getTerapiaId());
			System.out.println("Manipulação : " + sessao.getManipulacao());
			System.out.println("Observação : " + sessao.getObservacao());
			System.out.println("Data : " + sessao.getDataSessao() + "\n");

		} 

		 System.out.println("Passou aqui...");

	}
		 
			//METODOS
			public static void salvar() {
				Sessao _sessao = new Sessao();
				_sessao.setPacienteId(1);
				_sessao.setTerapiaId(1);
				_sessao.setObservacao("Obs");
				_sessao.setManipulacao(10.5);
				_sessao.setDataSessao(Timestamp.valueOf("2017-09-10 00:00:00"));
				SessaoDao dao = new SessaoDao();
				dao.salva(_sessao);
				
			}
			
		    public static List<Sessao> buscar() {
		        
		        Sessao _sessao = new Sessao();
		        SessaoDao dao = new SessaoDao();       
		        return dao.buscar(_sessao, 0);
		    }
	
}
