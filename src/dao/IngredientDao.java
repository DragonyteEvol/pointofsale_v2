package dao;

import java.util.List;

import object.Ingredient;

public interface IngredientDao extends Dao<Ingredient>{
	public List<Ingredient> search(String search);
}
