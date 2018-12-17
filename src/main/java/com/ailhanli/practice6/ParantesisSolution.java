package com.ailhanli.practice6;

import java.util.Stack;

public class ParantesisSolution {

	//you cannot use lambda expression or stream api for this kind of logics
	public boolean isBalanced(String word) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < word.length(); i++) {
			String newSymbol = "" + word.charAt(i);

			if (newSymbol.equals("(") || newSymbol.equals("[")) {
				stack.push("" + newSymbol);
			} else {
				String firstSymbol = stack.pop();

				if ((!firstSymbol.equals("(") && newSymbol.equalsIgnoreCase(")"))
						|| (!firstSymbol.equals("[") && newSymbol.equalsIgnoreCase("]"))) {
					return false;
				}
			}
		}

		return stack.empty();
	}
}