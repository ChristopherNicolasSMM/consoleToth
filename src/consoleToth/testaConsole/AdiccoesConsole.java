package consoleToth.testaConsole;

import java.util.List;
import consoleToth.dao.*;
import consoleToth.model.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdiccoesConsole {

	public void executar() {
		 salvar();
		 
		 List<Adiccoes> listar = buscar();
		
		for (Adiccoes adiccoes : listar) {
			System.out.println("ID : " + adiccoes.getId());
			System.out.println("Paciente Id : " +adiccoes.getPacienteId());
			System.out.println("Adiccao Id : " +adiccoes.getAdiccaoId() + "\n");

		} 

		 System.out.println("Passou aqui...");

	}
		 
			//METODOS
			public static void salvar() {
				Adiccoes _adiccoes = new Adiccoes();
				_adiccoes.setPacienteId(1);
				_adiccoes.setAdiccaoId(2);
				AdiccoesDao dao = new AdiccoesDao();
				dao.salva(_adiccoes);
				
			}
			
		    public static List<Adiccoes> buscar() {
		        
		        Adiccoes _adiccoes = new Adiccoes();
		        AdiccoesDao dao = new AdiccoesDao();       
		        return dao.buscar(_adiccoes, 0);
		    }
	
	
}
