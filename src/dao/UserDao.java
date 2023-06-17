package dao;

import object.User;

public interface UserDao extends Dao<User>{
	User getByMail(String mail);
}
