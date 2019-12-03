package Operators;

import Calculator.Calculator;

//Functionality接口，定义相关的方法，以后添加功能只需要实现相关的类
public interface Functionality {
	// 功能的实现方法，具体方法需要在具体类中实现
	public void operate(Calculator cal);
}
