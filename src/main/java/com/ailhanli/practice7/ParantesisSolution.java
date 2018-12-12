package com.ailhanli.practice7;

import java.util.Stack;

public class ParantesisSolution {

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