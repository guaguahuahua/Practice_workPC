package com.xjtu.designpattern.observer;

import java.util.ArrayList;

public abstract class AbstractSubject implements Subject{
	
	ArrayList<Observer> list=new ArrayList<Observer>();
	
	public void add(Observer observer) {
		list.add(observer);
	}
	
	public void del(Observer observer) {
		list.remove(observer);
	}
	
	public void notifyObservers() {
		for(int i=0; i<list.size(); i++) {
			Observer o=list.get(i);
			o.update();
		}
	}
}
