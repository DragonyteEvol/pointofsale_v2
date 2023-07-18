package dao;

import java.util.List;

import object.Ingredient;
import object.Product;

public interface ProductDao extends Dao<Product>{
	public Long insert(Product object,List<Ingredient> dependecies);
}
