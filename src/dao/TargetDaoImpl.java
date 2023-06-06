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
import object.Target;

public class TargetDaoImpl extends DaoImplement implements TargetDao{
	
	private Connection connection = ConnectionDatabase.getConnection();
	
	private final String TABLE = "targets";
	private final String[] COLUMNS = {"target","capacity","description","price","room","allocated"};
	private final String[] JOIN = {};


	@Override
	public List<Target> getAll() {
		ResultSet set = null;
		List<Target> a = new ArrayList<>();
		try {
			String sql = joinTable(JOIN, TABLE, false);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			set = statement.executeQuery();
			while(set.next()) {
				a.add((Target)(convert(new Target(),set)));	
			}
		}catch(SQLException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

	@Override
	public Target getById(Long id) {
		ResultSet set = null;
		Target a = null;
		try {
			String sql = joinTable(JOIN, TABLE, true);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			set = statement.executeQuery();
			while(set.next()) {
				a = (Target)(convert(new Target(),set));	
			}
		}catch(Exception  e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

	@Override
	public Long insert(Target object) {
		try {
			String sql = generateInsert(TABLE, COLUMNS);
			PreparedStatement statement = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement = setParams(statement, COLUMNS, object,false);
			statement.executeUpdate();
			return getLastId(statement);
		}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Target object) {
		try {
			String sql = generateUpdate(TABLE, COLUMNS);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement = setParams(statement, COLUMNS, object,true);
			statement.executeUpdate();
		}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
	}

	@Override
	public void delete(Target object) {
		try {
			String sql = generateDelete(TABLE);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, object.getId());
			statement.executeUpdate();
		}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
	}

}
