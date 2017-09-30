package consoleToth.testaConsole;

import java.util.List;
import consoleToth.dao.*;
import consoleToth.model.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteConsole {

	public void executar() {
		 salvar();
		 
		 List<Paciente> listar = buscar();
		
		for (Paciente paciente : listar) {
			System.out.println("ID : " + paciente.getId());
			System.out.println("Nome : " +paciente.getNome());

		} 

		 System.out.println("Passou aqui...");

	}
		 
			//METODOS
			public static void salvar() {
				Paciente _paciente = new Paciente();
				_paciente.setId(1);
				_paciente.setNome("console-01");

				PacienteDao dao = new PacienteDao();
				dao.salva(_paciente);
				
			}
			
		    public static List<Paciente> buscar() {
		        
		        Paciente _paciente = new Paciente();
		        PacienteDao dao = new PacienteDao();   
		        _paciente.setNome("conso");
		        return dao.buscar(_paciente, 2);
		    }
	
}
