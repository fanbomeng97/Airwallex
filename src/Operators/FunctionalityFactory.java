package Operators;

//���ܹ����������������������Ӧ��ʵ����
public class FunctionalityFactory {
	public static Functionality getFunctionality(String symble) {
		// δ����ӹ��������������Ӧ�жϼ���
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
