package Operators;

import java.math.BigDecimal;

/*
 * Operator接口，定义相关的方法，以后添加运算符只需要实现相关的类
 * 使用BigDecimal类实现高精度运算
 */
public interface Operator {
	// 二元运算符的返回结果方法
	public BigDecimal getResult(String para1, String para2);

	// 一元运算符的返回结果方法
	public BigDecimal getResult(String para1);
}
