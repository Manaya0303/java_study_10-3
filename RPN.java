

package midterm_ver2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RPN {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("式を入力");
		
		String formula = sc.nextLine();
		
		String checkedFormula = checkFormula(formula);
		
		System.out.println(checkedFormula);
		
		//getRpnでRPNに変換
		String rpn = getRpn(checkedFormula);
		
		System.out.println(rpn);
		
		//calRpnで計算し、結果をresultに格納
		double result = calRpn(rpn);
		
		System.out.println(result);
		
	}
	
	
	
	public static String checkFormula (String formula) {
		char[] c = formula.toCharArray();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i]) || c[i] == ')') {
				if(i > 0 && i < c.length - 1 && (c[i + 1] == '(')) {
					result.append(c[i]).append('*');
				} else if(i > 0 && i < c.length - 1 && c[i] == ')' && Character.isDigit(c[i + 1])) {
					result.append(c[i]).append('*');
				}else {
					result.append(c[i]);
				}
			} else {
				result.append(c[i]);
			}
		}
		
		return result.toString();
	}
	
	
	
	
	public static String getRpn(String formula) {
		
		//formula変数を一文字ずつsequenceList配列に格納
		char[] sequenceList = formula.toCharArray();
		
		//RPNを組み立てる場所
		StringBuilder rpnBuilder = new StringBuilder();
		
		//スタック
		Deque<Character> stack = new ArrayDeque<>();
		
		//複数桁の数値を組み立て
		StringBuilder number = new StringBuilder();
		
		//sequenceListの中身をすべてtokenに格納するまでループ
		for (int i = 0; i < sequenceList.length; i++) {
			char token = sequenceList[i];
			
			//tokenの中身によって処理を分岐
			switch(token) {
				case '+':
				case '-':
					
					if (number.length() > 0) {
						rpnBuilder.append(number.toString()).append(' ');
						number.setLength(0);
					}
					//スタックされた演算子の優先順位より低い場合はスタックの演算子をバッファへ
					while (!stack.isEmpty()) {
						char c = stack.getFirst();
						//'*'か'/'ならrpnBuilderの末尾に追加
						if (c == '*' || c == '/') {
							rpnBuilder.append(stack.removeFirst()).append(' ');
						}else {
							break;
						}
					}
					stack.addFirst(token);
					break;
					
				case '*':
				case '/':
					if (number.length() > 0) {
                        rpnBuilder.append(number.toString()).append(' ');
                        number.setLength(0);
                    }
					stack.addFirst(token);
					break;
					
				case '×':
					if (number.length() > 0) {
                        rpnBuilder.append(number.toString()).append(' ');
                        number.setLength(0);
                    }
					stack.addFirst('*');
					break;
					
				case '÷':
					if (number.length() > 0) {
                        rpnBuilder.append(number.toString()).append(' ');
                        number.setLength(0);
                    }
					stack.addFirst('/');
					break;
				case '(':
					if(number.length() > 0) {
						rpnBuilder.append(number.toString()).append(' ');
						number.setLength(0);
					}
					stack.addFirst(token);
					break;
					
				case ')':
					if (number.length() > 0) {
						rpnBuilder.append(number.toString()).append(' ');
						number.setLength(0);
					}
					while (!stack.isEmpty() && stack.getFirst() != '(') {
						rpnBuilder.append(stack.removeFirst()).append(' ');
					}
					if(!stack.isEmpty()) {
						// '('を削除
						stack.removeFirst();					
					}
					break;
					
				case '.':
					number.append(token);
					break;
				
				default:
					//数値の場合の処理
					if(Character.isDigit(token)) {
						number.append(token);
					}
					break;
			}
		}
		
		if (number.length() > 0) {
			rpnBuilder.append(number.toString()).append(' ');
			number.setLength(0);
		}
		
		while (!stack.isEmpty()) {
			rpnBuilder.append(stack.removeFirst()).append(' ');
		}
		
		return rpnBuilder.toString().trim();
	}

	public static double calRpn(String rpn) {
		Deque<Double> stack = new ArrayDeque<>();
		StringBuilder number = new StringBuilder();
		
		for (int i = 0; i < rpn.length(); i++) {
			char c = rpn.charAt(i);
			if (c == ' ') {
				if (number.length() > 0) {
					stack.addFirst(Double.parseDouble(number.toString()));
					number.setLength(0);
				}
			} else if(Character.isDigit(c) || c == '.') {
				number.append(c);
				
			//数字か判定し数字ではないならisOperatorメソッドで演算子か判定
			} else if (isOperator(c)) {
				if (number.length() > 0) {
					stack.addFirst(Double.parseDouble(number.toString()));
					number.setLength(0);
				}
				double b = stack.removeFirst();
				double a = stack.removeFirst();
				
				switch (c) {
					case '+': stack.addFirst(a + b); break;
					case '-': stack.addFirst(a - b); break;
					case '*': stack.addFirst(a * b); break;
					case '/': stack.addFirst(a / b); break;
				}
			}
		}
		
		if (number.length() > 0) {
			stack.addFirst(Double.parseDouble(number.toString()));
		}
		return stack.removeFirst();
	}

	public static boolean isOperator (char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

}
