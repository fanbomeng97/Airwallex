package Operators;

import Calculator.Calculator;

///undo���ܣ����ڳ�����һ��������ʵ����Functionality�ӿ�
public class UndoFunctionality implements Functionality {
	public void operate(Calculator cal) {
		if (cal.totalItems.size() != 0) {
			cal.totalItems.remove(cal.totalItems.size() - 1);
		}
	}
}
