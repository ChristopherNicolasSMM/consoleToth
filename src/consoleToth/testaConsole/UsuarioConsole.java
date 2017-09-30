package consoleToth.testaConsole;

import java.util.List;
import consoleToth.dao.*;
import consoleToth.model.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioConsole {


	public void executar() {
		 salvar();
		 
		 List<Usuario> listar = buscar();
		
		for (Usuario usuario : listar) {
			System.out.println("ID : " + usuario.getId());
			System.out.println("Nome : " +usuario.getNome());
			System.out.println("Login : " +usuario.getLogin());
			System.out.println("Senha : " +usuario.getSenha());
			System.out.println("Permissao : " +usuario.getPermissao());

		} 

		 System.out.println("Passou aqui...");

	}
		 
			//METODOS
			public static void salvar() {
				Usuario _usuario = new Usuario();
				_usuario.setId(2);
				_usuario.setNome("console-02");
				_usuario.setLogin("Login");
				_usuario.setPermissao("Teste Perm");

				UsuarioDao dao = new UsuarioDao();
				dao.salva(_usuario);
				
			}
			
		    public static List<Usuario> buscar() {
		        
		        Usuario _usuario = new Usuario();
		        UsuarioDao dao = new UsuarioDao();   
		        _usuario.setNome("conso");
		        return dao.buscar(_usuario, 2);
		    }
	
}
