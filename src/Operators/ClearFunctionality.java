package Operators;

import Calculator.Calculator;

//clear���ܣ����������ǰ����ʷ��¼��ʵ����Functionality�ӿ�
public class ClearFunctionality implements Functionality {
	public void operate(Calculator cal) {
		cal.totalItems.clear();
	}
}
