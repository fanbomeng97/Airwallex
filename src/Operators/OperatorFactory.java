package Operators;

//运算符工厂，根据输入参数创建相应的实现类
public class OperatorFactory {
	public static Operator getOperator(String symble) {
		// 未来添加运算符在这里添加相应判断即可
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
