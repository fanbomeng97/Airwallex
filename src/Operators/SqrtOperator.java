package Operators;

import java.math.BigDecimal;

// sqrt �����ʵ���࣬ʵ����Operator�ӿ�
public class SqrtOperator implements Operator {
	public BigDecimal getResult(String para1, String para2) {
		return null;
	}

	public BigDecimal getResult(String para) {
		return new BigDecimal(Math.sqrt(Double.parseDouble(para))).setScale(15, BigDecimal.ROUND_HALF_UP);
	}
}
