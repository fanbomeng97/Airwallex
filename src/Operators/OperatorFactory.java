package Operators;

//����������������������������Ӧ��ʵ����
public class OperatorFactory {
	public static Operator getOperator(String symble) {
		// δ���������������������Ӧ�жϼ���
		switch (symble) {
		case "+":
			return new AddOperator();
		case "-":
			return new SubOperator();
		case "*":
			return new MulOperator();
		case "/":
			return new DivOperator();
		case "sqrt":
			return new SqrtOperator();
		default:
			System.out.println("Illegal operator");
			return null;
		}
	}
}
