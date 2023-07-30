package dao;

import object.Bill;

public interface BillDao extends Dao<Bill>{
	public Bill getByTarget(Long target_id);
}
