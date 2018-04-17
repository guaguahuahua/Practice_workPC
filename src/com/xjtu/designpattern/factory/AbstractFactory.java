package com.xjtu.designpattern.factory;

/**
 * 抽象工厂主要的是将产生sender的过程转化为一个接口，
 * 这样的接口被继承之后，需要什么对象直接就生成该对象即可
 * @author Administrator
 *
 */
public interface AbstractFactory {

	public Sender factory();
}
