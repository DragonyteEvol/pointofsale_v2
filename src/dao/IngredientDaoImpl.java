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
import object.Ingredient;

public class IngredientDaoImpl extends DaoImplement implements IngredientDao{

	private Connection connection = ConnectionDatabase.getConnection();
	
	private final String TABLE = "ingredients";
	private final String[] COLUMNS = {"ingredient","price","unit_id","categorie_id","amenitie"};
	private final String[] JOIN = {"units","categories"};
	
	@Override
	public List<Ingredient> getAll() {
		ResultSet set = null;
		List<Ingredient> a = new ArrayList<>();
		try {
			String sql = joinTable(JOIN, TABLE, false);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			set = statement.executeQuery();
			while(set.next()) {
				a.add((Ingredient)(convert(new Ingredient(),set)));	
			}
		}catch(SQLException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

	@Override
	public Ingredient getById(Long id) {
		ResultSet set = null;
		Ingredient a = null;
		try {
			String sql = joinTable(JOIN, TABLE, true);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			set = statement.executeQuery();
			while(set.next()) {
				a = (Ingredient)(convert(new Ingredient(),set));	
			}
		}catch(Exception  e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

	@Override
	public Long insert(Ingredient object) {
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
	public void update(Ingredient object) {
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
	public void delete(Ingredient object) {
		try {
			String sql = generateDelete(TABLE);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, object.getId());
			statement.executeUpdate();
		}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
	}
	
	@Override
	public List<Ingredient> search(String search) {
		ResultSet set = null;
		List<Ingredient> a = new ArrayList<>();
		try {
			String sql = joinTable(JOIN, TABLE, false);
			sql += " WHERE " + TABLE + ".ingredient LIKE '%" + search + "%'";
			Log.getLogger(getClass()).info(sql);
			PreparedStatement statement = this.connection.prepareStatement(sql);
			set = statement.executeQuery();
			while(set.next()) {
				a.add((Ingredient)(convert(new Ingredient(),set)));	
			}
		}catch(Exception  e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}finally {
			closeResultSet(set);
		}
		return a;
	}

}
