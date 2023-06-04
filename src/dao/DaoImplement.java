package dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import log.Log;

public class DaoImplement {
	
	//GENERA LA SENTENCIA SQL CON LOS JOINS REQUERIDOS
	//RECIBE UN SQL INICIAL DE TIPO SELECT
	//UNA LISTA DE STRINGS CON LOS NOMBRES DE LAS TABLAS A UNIR
	//UN STRING DE LA TABLA PADRE
	//UN BOOLEANO PARA AGREGAR LA CLAUSULA WHERE DE ID
	public String joinTable(String sql,String[] JOIN,String TABLE,Boolean where) {
		for(String table : JOIN) {
			//CAPITALIZE DE LA COLUMNA Y _ID EJ USER_ID
			String column = table.substring(0,table.length()-1) + "_id"; 
			sql+=" LEFT JOIN " + table + " ON " + TABLE + "." + column + "=" + table + ".id"; 
		}
		if(where) {
			sql+= " WHERE " + TABLE + ".id=?";
		}
		return sql;
	}
	
	//GENERA UN OBJECTO CON CAMPOS A PARTIR DE UN RESULTSET DE UNA CONSULTA
	//RECIBE UN OBJECTO VACIO Y EL RESULSET DE LA CONSULTA
	public Object convert(Object object,ResultSet set) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, SQLException {
		Field[] fields = object.getClass().getFields();
		for(Field field:fields) {
			//CONVERTIR NOMBRE DEL METODO A CAPITALAZE
			String method_name = field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
			method_name = "set"+method_name;
			Log.getLogger(getClass()).debug(method_name);
			//EXTRAER METODO DINAMICO
			
			//VALIDACION DE STRING
			if(field.getType().getName().equals(String.class.getName())) {
				Method method = object.getClass().getMethod(method_name, String.class);
				method.invoke(object, set.getString(field.getName()));
			}
			//VALIDACION DE LONG
			if(field.getType().getName().equals(Long.class.getName())) {
				Method method = object.getClass().getMethod(method_name, Long.class);	
				method.invoke(object, set.getLong(field.getName()));
			}
			//VALIDACION DE INTEGER
			if(field.getType().getName().equals(Integer.class.getName())) {
				Method method = object.getClass().getMethod(method_name, Integer.class);
				method.invoke(object, set.getInt(field.getName()));
			}
			//VALIDACION BOOLEAN
			if(field.getType().getName().equals(Boolean.class.getName())) {
				Method method = object.getClass().getMethod(method_name, Boolean.class);
				method.invoke(object, set.getBoolean(field.getName()));
			}
		}
		return object;
	}
	
	//SETEA LOS PARAMETROS DE UNA CONSULTA PREPARADA
	//RECIBE UN STATEMENT EL OBJECTO QUE TIENE LOS VALORES A ASIGNAR Y LA LISTA DE COLUMNAS A ASIGNAR
	public PreparedStatement setParams(PreparedStatement statement,String[] columns,Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		int index = 1;
		for(String column : columns) {
			Field field = object.getClass().getField(column);
			//VALIDACION DE STRING
			if(field.getType().getName().equals(String.class.getName())) {
				statement.setString(index, 
						field.get(object).toString());
			}
			//VALIDACION DE LONG
			if(field.getType().getName().equals(Long.class.getName())) {
				statement.setLong(index, 
						Long.valueOf(field.get(object).toString()));
			}
			//VALIDACION DE INTEGER
			if(field.getType().getName().equals(Integer.class.getName())) {
				statement.setInt(index, 
						Integer.valueOf(field.get(object).toString()));
			}
			//VALIDACION BOOLEAN
			if(field.getType().getName().equals(Boolean.class.getName())) {
				statement.setBoolean(index, 
						Boolean.valueOf(field.get(object).toString()));
			}
			index+=1;
		}
		return statement;
	}
	
	//CIERRA EL RESULT SET
	//RECIBE UN RESULT SET
	public void closeResultSet(ResultSet set) {
		if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                Log.getLogger(getClass()).error(e.getMessage());
            }
        }
	}
	
	//GENERA LA CONSULTA PREPARADA PARA INSERSION DE REGISTROS
	//RECIBE STRING DE LA TABLA SOBRE LA CUAL SE VA A HACER LA INSERCION Y UNA LISTA DE COLUMNAS A INSERTAR
	public String generateInsert(String TABLE,String[] COLUMNS) {
		String sql = "INSERT INTO "+ TABLE;
		sql+= "(";
		String values ="(";
		int index = 1;
		for(String column : COLUMNS) {
			sql+=column;
			values+="?";
			if(index==COLUMNS.length) {
				sql+=")";
				values+=")";
			}else {
				sql+=",";
				values+=",";
			}
			index+=1;
		}
		sql += sql + "VALUES " + values;
		return sql;
	}
	
	//EJECUTA LA CONSULTA PREPARADA
	public Long getLastId(PreparedStatement statement) {
		Long rowId = null;
		try {
	        ResultSet idKey = statement.getGeneratedKeys();
	        if (idKey.next()) {
	            rowId = idKey.getLong(1);
	        }
	        return rowId;
		}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
		return rowId;
	}
}
