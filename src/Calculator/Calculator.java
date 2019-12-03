package Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import Operators.FunctionalityFactory;
import Operators.OperatorFactory;

/*
 * 计算器类，创建一个计算器对象并调用start方法来使用该计算器
 */
public class Calculator {
	public static Scanner in = new Scanner(System.in);

	// 历史输入列表，用于记录当前计算器所有的历史输入，只包含数字与运算符，不包含功能运算符
	public ArrayList<String> totalItems = new ArrayList<>();
	// 当前输入列表，用于记录当前栈里的输入，只包含数字与运算符，不包含功能运算符
	public ArrayList<String> currentItems = new ArrayList<>();
	// 数字栈，用于计算时存放数据
	public Stack<String> parameterStack = new Stack<>();
	// 功能旗，当输入出现功能性运算符时为true
	public boolean functionalityFlag = false;

	// 运行计算器的方法
	public void start() {
		while (true) {
			// 用于监听用户输入及字符串分割处理
			String input = in.nextLine();
			String[] inputItems = input.split(" ");

			// 将当前的输入项加入历史和当前输入列表，如果有功能性操作，则对历史纪录进行处理，功能旗设为true
			for (String i : inputItems) {
				// 如果以后添加功能只需要在判断语句中增加即可
				if (i.matches("clear|undo")) {
					FunctionalityFactory.getFunctionality(i).operate(this);
					functionalityFlag = true;
				} else {
					totalItems.add(i);
					currentItems.add(i);
				}
			}

			/*
			 * 如果功能旗为true，则说明里面包含功能性操作，此时需要考虑历史输入（比如说undo功能），
			 * 因此将当前输入列表替换为历史输入列表。如果没有功能性操作则不需要考虑历史纪录，仅需处理当前纪录列表和新输入的数据
			 */
			if (functionalityFlag) {
				currentItems.clear();
				currentItems.addAll(totalItems);
				functionalityFlag = false;
			}

			// 处理当前输入列表
			for (int i = 0; i < currentItems.size(); i++) {
				String item = currentItems.get(i);
				// 如果当前输入项为数字，则推入数字栈
				if (item.matches("\\d+|\\d+\\.\\d+")) {
					parameterStack.push(item);

					// 如果当前输入项为二元运算符，则进行相应处理，如果以后添加二元运算符只需要在判断语句中增加即可
				} else if (item.matches("\\+|\\-|\\*|\\/")) {
					// 判断当前栈中数字是否大于两个，如果不够则报错退出循环，放弃后面的输入项
					if (parameterStack.size() < 2) {
						System.out.println("operator " + item + " (position: " + (i + 1) + "): insucient parameters");
						break;
					}
					String param1 = parameterStack.pop();
					String param2 = parameterStack.pop();
					// 调用工厂中的方法创建相应的运算符并输出结果
					BigDecimal result = OperatorFactory.getOperator(item).getResult(param2, param1);
					if (result == null) {
						System.out.println("Exception position: " + i);
						break;
					}
					parameterStack.push(result.toString());

					// 如果当前输入项为一元运算符，则进行相应处理，如果以后添加一元运算符只需要在判断语句中增加即可
				} else if (item.matches("sqrt")) {
					// 判断当前栈中数字是否足够运算，如果不够则报错退出循环，放弃后面的输入项
					if (parameterStack.isEmpty()) {
						break;
					}
					String param = parameterStack.pop();
					// 调用工厂中的方法创建相应的运算符并输出结果
					BigDecimal result = OperatorFactory.getOperator(item).getResult(param);
					if (result == null) {
						System.out.println("Exception position: " + i);
						break;
					}
					parameterStack.push(result.toString());
				}
			}

			// 循环结束后清空当前输入列表，并将栈中的数字加入列表中用于之后的处理
			currentItems.clear();
			while (!parameterStack.isEmpty()) {
				currentItems.add(0, parameterStack.pop());
			}

			// 创建StringBuildder用于Stack输出
			StringBuilder sb = new StringBuilder();
			sb.append("Stack: ");
			for (String item : currentItems) {
				// 保证输出的位数为10位，并消除结尾多余的0
				BigDecimal parameter = new BigDecimal(item).setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
				sb.append(parameter.toPlainString() + " ");
			}
			System.out.println(sb.toString());
		}
	}

	// 主方法，创建一个计算器实例并调用start方法
	public static void main(String[] args) {
		Calculator mainCalculator = new Calculator();
		mainCalculator.start();
	}
}
