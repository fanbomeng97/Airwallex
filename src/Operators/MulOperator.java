package Operators;

import java.math.BigDecimal;

// * �����ʵ���࣬ʵ����Operator�ӿ�
public class MulOperator implements Operator {
	public BigDecimal getResult(String para1, String para2) {
		return new BigDecimal(para1).multiply(new BigDecimal(para2));
	}

	public BigDecimal getResult(String para) {
		return null;
	}
}