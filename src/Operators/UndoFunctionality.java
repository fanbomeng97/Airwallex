package Operators;

import Calculator.Calculator;

///undo功能，用于撤销上一步操作，实现了Functionality接口
public class UndoFunctionality implements Functionality {
	public void operate(Calculator cal) {
		if (cal.totalItems.size() != 0) {
			cal.totalItems.remove(cal.totalItems.size() - 1);
		}
	}
}
