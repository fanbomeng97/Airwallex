package Operators;

import java.math.BigDecimal;

// / �����ʵ���࣬ʵ����Operator�ӿ�
public class DivOperator implements Operator {
	public BigDecimal getResult(String para1, String para2) {
		// ��������Ϊ0���ұ���ʮ��λС��
		if (!para2.equals("0")) {
			return new BigDecimal(para1).divide(new BigDecimal(para2), 15, BigDecimal.ROUND_HALF_UP);
		} else {
			System.out.print("The divisor cannot be 0, ");
			return null;
		}

	}

	public BigDecimal getResult(String para) {
		return null;
	}
}
