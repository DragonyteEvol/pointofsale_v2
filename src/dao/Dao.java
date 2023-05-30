package dao;

import java.util.List;

public interface Dao<T>{
	public List<T> getAll();
	public T getById(T id);
	public Long insert(T object);
	public void update(T object);
	public void delete(T object);
}
