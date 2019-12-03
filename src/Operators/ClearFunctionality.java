package Operators;

import Calculator.Calculator;

//clear功能，用于清除当前和历史纪录，实现了Functionality接口
public class ClearFunctionality implements Functionality {
	public void operate(Calculator cal) {
		cal.totalItems.clear();
	}
}
