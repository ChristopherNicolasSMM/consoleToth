package consoleToth.testaConsole;

import java.util.List;
import consoleToth.dao.*;
import consoleToth.model.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdiccaoConsole {

	public void executar() {
		 salvar();
		 
		 List<Adiccao> listar = buscar();
		
		for (Adiccao adiccao : listar) {
			System.out.println("ID : " + adiccao.getId());
			System.out.println("Substancia : " +adiccao.getSubstancia());
			System.out.println("Data Inicio : " +adiccao.getDataInicio());
			System.out.println("Maior Abstinencia : " +adiccao.getMaiorAbst());
			System.out.println("Tempo Limpo : " +adiccao.getTempoLimpo() + "\n");

		} 

		 System.out.println("Passou aqui...");

	}
		 
			//METODOS
			public static void salvar() {
				Adiccao _adiccao = new Adiccao();
				_adiccao.setId(4);
				_adiccao.setSubstancia("console-30");
				_adiccao.setDataInicio(Timestamp.valueOf("2017-02-10" + " 00:00:00"));
				_adiccao.setMaiorAbst(Timestamp.valueOf("2017-02-20" + " 00:00:00"));
				_adiccao.setTempoLimpo(Timestamp.valueOf("2017-02-20" + " 00:00:00"));
				AdiccaoDao dao = new AdiccaoDao();
				dao.salva(_adiccao);
				
			}
			
		    public static List<Adiccao> buscar() {
		        
		        Adiccao _adiccao = new Adiccao();
		        AdiccaoDao dao = new AdiccaoDao();       
		        return dao.buscar(_adiccao, 0);
		    }
	
}
