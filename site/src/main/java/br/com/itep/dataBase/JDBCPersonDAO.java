package br.com.itep.dataBase;
/**
 * @author allyson.manoel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import br.com.itep.entity.Person;

public class JDBCPersonDAO implements IPersonDAO {
	private Connection connection;
	private static JDBCPersonDAO banco = null;
	
	private JDBCPersonDAO() {
	}

	public static JDBCPersonDAO getInstance()
	{
		if (banco == null) return new JDBCPersonDAO();
		return banco;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		if (connection == null)
		{
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/wicket", "postgres",
					"postgre");
		}
		return connection;
	}
	
	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByCPF(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetDatabase() {
		// TODO Auto-generated method stub

	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void disconect()
	{
		try 
		{
			this.connection.close();
		} catch (SQLException e) {}
	}

}
