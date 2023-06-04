package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import log.Log;
import model.ConnectionDatabase;
import object.Annulment;

public class AnnulmentDaoImpl extends DaoImplement implements AnnulmentDao {
	
	private Connection connection = ConnectionDatabase.getConnection();
	
	private final String TABLE = "annulments";
	private final String[] COLUMNS = {"reason","user_id","product_id","quantity"};
	private final String[] JOIN = {"users","products"};
	private final String GET = "SELECT *,"+TABLE+".id as master_id FROM " + TABLE;

	@Override
	public List<Annulment> getAll() {
		ResultSet set = null;
		List<Annulment> a = new ArrayList<>();
		try {
			String sql = joinTable(GET, JOIN, TABLE, false);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			set = statement.executeQuery();
			while(set.next()) {
				a.add((Annulment)(convert(new Annulment(),set)));	
			}
		}catch(SQLException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

	@Override
	public Annulment getById(Long id) {
		ResultSet set = null;
		Annulment a = null;
		try {
			String sql = joinTable(GET, JOIN, TABLE, true);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			set = statement.executeQuery();
			while(set.next()) {
				a = (Annulment)(convert(new Annulment(),set));	
			}
		}catch(Exception  e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

	@Override
	public Long insert(Annulment object) {
		try {
			String sql = generateInsert(TABLE, COLUMNS);
			PreparedStatement statement = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement = setParams(statement, COLUMNS, object);
			statement.executeUpdate();
			return getLastId(statement);
		}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Annulment object) {
		
	}

	@Override
	public void delete(Annulment object) {
		
	}
}
