package model;

import object.User;

public class ConfigModel {
	public static User user;
	
	//GESTION DE USUARIOS
	public static User getUser() {
		return user;
	}
	
	public static User setUser(User us) {
		user = us;
		return user;
	}
	
	
}
