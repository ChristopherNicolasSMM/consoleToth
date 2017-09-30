package consoleToth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

		
		public static Connection getConnection(){
			
			try {
				Class.forName("org.postgresql.Driver");
				return DriverManager.getConnection("jdbc:postgresql://localhost:5433/toth",
						"postgres", "root");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		
}

