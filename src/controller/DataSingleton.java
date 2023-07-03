package controller;

import object.Target;
import object.Unit;

public class DataSingleton {
	
	private static DataSingleton instance;
	
	//DATA
	private Target target;
	private String string;
	private Unit unit;
	
	private DataSingleton() {
		super();
	}

	public static DataSingleton getInstance() {
		if(instance==null) {
			instance=new DataSingleton();
		}
		return instance;
	}

	public static void setInstance(DataSingleton instance) {
		DataSingleton.instance = instance;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	
}
