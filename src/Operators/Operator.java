package Operators;

import java.math.BigDecimal;

/*
 * Operator�ӿڣ�������صķ������Ժ���������ֻ��Ҫʵ����ص���
 * ʹ��BigDecimal��ʵ�ָ߾�������
 */
public interface Operator {
	// ��Ԫ������ķ��ؽ������
	public BigDecimal getResult(String para1, String para2);

	// һԪ������ķ��ؽ������
	public BigDecimal getResult(String para1);
}
