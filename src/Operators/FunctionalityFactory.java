package Operators;

//功能工厂，根据输入参数创建相应的实现类
public class FunctionalityFactory {
	public static Functionality getFunctionality(String symble) {
		// 未来添加功能在这里添加相应判断即可
		switch (symble) {
		case "clear":
			return new ClearFunctionality();
		case "undo":
			return new UndoFunctionality();
		default:
			System.out.println("Illegal functionality");
			return null;
		}
	}
}
