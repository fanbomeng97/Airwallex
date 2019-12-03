package Operators;

import java.math.BigDecimal;

// / 运算符实现类，实现了Operator接口
public class DivOperator implements Operator {
	public BigDecimal getResult(String para1, String para2) {
		// 除数不能为0，且保留十五位小数
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
