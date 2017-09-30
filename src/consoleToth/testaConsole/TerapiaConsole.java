package consoleToth.testaConsole;

import java.util.List;
import consoleToth.dao.TerapiaDao;
import consoleToth.model.Terapia;
import java.util.ArrayList;
import java.util.List;

public class TerapiaConsole {

	public void executar() {
		 salvar();
		 
		 List<Terapia> listar = buscar();
		
		for (Terapia terapia : listar) {
			System.out.println("ID : " + terapia.getId());
			System.out.println("Nome : " +terapia.getNome());
			System.out.println("Origem : " +terapia.getOrigem());
			System.out.println("Principio : " +terapia.getPrincipio());
			System.out.println("Substancia : " +terapia.getSubstancia() + "\n");

		} 

		 System.out.println("Passou aqui...");

	}
		 
			//METODOS
			public static void salvar() {
				Terapia _terapia = new Terapia();
				_terapia.setId(10);
				_terapia.setNome("console-10");
				_terapia.setOrigem("console-10");
				_terapia.setPrincipio("console-10");
				_terapia.setSubstancia("console-10");
				TerapiaDao dao = new TerapiaDao();
				dao.salva(_terapia);
				
			}
			
		    public static List<Terapia> buscar() {
		        
		        Terapia _terapia = new Terapia();
		        TerapiaDao dao = new TerapiaDao();       
		        return dao.buscar(_terapia, 0);
		    }
	
	
}
