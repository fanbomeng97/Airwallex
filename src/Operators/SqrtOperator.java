package Operators;

import java.math.BigDecimal;

// sqrt 运算符实现类，实现了Operator接口
public class SqrtOperator implements Operator {
	public BigDecimal getResult(String para1, String para2) {
		return null;
	}

	public BigDecimal getResult(String para) {
		return new BigDecimal(Math.sqrt(Double.parseDouble(para))).setScale(15, BigDecimal.ROUND_HALF_UP);
	}
}
