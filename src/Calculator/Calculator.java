package Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import Operators.FunctionalityFactory;
import Operators.OperatorFactory;

/*
 * �������࣬����һ�����������󲢵���start������ʹ�øü�����
 */
public class Calculator {
	public static Scanner in = new Scanner(System.in);

	// ��ʷ�����б����ڼ�¼��ǰ���������е���ʷ���룬ֻ��������������������������������
	public ArrayList<String> totalItems = new ArrayList<>();
	// ��ǰ�����б����ڼ�¼��ǰջ������룬ֻ��������������������������������
	public ArrayList<String> currentItems = new ArrayList<>();
	// ����ջ�����ڼ���ʱ�������
	public Stack<String> parameterStack = new Stack<>();
	// �����죬��������ֹ����������ʱΪtrue
	public boolean functionalityFlag = false;

	// ���м������ķ���
	public void start() {
		while (true) {
			// ���ڼ����û����뼰�ַ����ָ��
			String input = in.nextLine();
			String[] inputItems = input.split(" ");

			// ����ǰ�������������ʷ�͵�ǰ�����б�����й����Բ����������ʷ��¼���д�����������Ϊtrue
			for (String i : inputItems) {
				// ����Ժ���ӹ���ֻ��Ҫ���ж���������Ӽ���
				if (i.matches("clear|undo")) {
					FunctionalityFactory.getFunctionality(i).operate(this);
					functionalityFlag = true;
				} else {
					totalItems.add(i);
					currentItems.add(i);
				}
			}

			/*
			 * ���������Ϊtrue����˵��������������Բ�������ʱ��Ҫ������ʷ���루����˵undo���ܣ���
			 * ��˽���ǰ�����б��滻Ϊ��ʷ�����б����û�й����Բ�������Ҫ������ʷ��¼�����账��ǰ��¼�б�������������
			 */
			if (functionalityFlag) {
				currentItems.clear();
				currentItems.addAll(totalItems);
				functionalityFlag = false;
			}

			// ����ǰ�����б�
			for (int i = 0; i < currentItems.size(); i++) {
				String item = currentItems.get(i);
				// �����ǰ������Ϊ���֣�����������ջ
				if (item.matches("\\d+|\\d+\\.\\d+")) {
					parameterStack.push(item);

					// �����ǰ������Ϊ��Ԫ��������������Ӧ��������Ժ���Ӷ�Ԫ�����ֻ��Ҫ���ж���������Ӽ���
				} else if (item.matches("\\+|\\-|\\*|\\/")) {
					// �жϵ�ǰջ�������Ƿ������������������򱨴��˳�ѭ�������������������
					if (parameterStack.size() < 2) {
						System.out.println("operator " + item + " (position: " + (i + 1) + "): insucient parameters");
						break;
					}
					String param1 = parameterStack.pop();
					String param2 = parameterStack.pop();
					// ���ù����еķ���������Ӧ���������������
					BigDecimal result = OperatorFactory.getOperator(item).getResult(param2, param1);
					if (result == null) {
						System.out.println("Exception position: " + i);
						break;
					}
					parameterStack.push(result.toString());

					// �����ǰ������ΪһԪ��������������Ӧ��������Ժ����һԪ�����ֻ��Ҫ���ж���������Ӽ���
				} else if (item.matches("sqrt")) {
					// �жϵ�ǰջ�������Ƿ��㹻���㣬��������򱨴��˳�ѭ�������������������
					if (parameterStack.isEmpty()) {
						break;
					}
					String param = parameterStack.pop();
					// ���ù����еķ���������Ӧ���������������
					BigDecimal result = OperatorFactory.getOperator(item).getResult(param);
					if (result == null) {
						System.out.println("Exception position: " + i);
						break;
					}
					parameterStack.push(result.toString());
				}
			}

			// ѭ����������յ�ǰ�����б�����ջ�е����ּ����б�������֮��Ĵ���
			currentItems.clear();
			while (!parameterStack.isEmpty()) {
				currentItems.add(0, parameterStack.pop());
			}

			// ����StringBuildder����Stack���
			StringBuilder sb = new StringBuilder();
			sb.append("Stack: ");
			for (String item : currentItems) {
				// ��֤�����λ��Ϊ10λ����������β�����0
				BigDecimal parameter = new BigDecimal(item).setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
				sb.append(parameter.toPlainString() + " ");
			}
			System.out.println(sb.toString());
		}
	}

	// ������������һ��������ʵ��������start����
	public static void main(String[] args) {
		Calculator mainCalculator = new Calculator();
		mainCalculator.start();
	}
}
