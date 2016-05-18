package org.chinaarchitect.calculator.formula;

public class Division extends Function {

	public Division(Expressible[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	public Division(double[] array) {
		super(array);
	}

	public Division(Expressible dividend, Expressible divisor) {
		super(new Expressible[] { dividend, divisor });
	}

	@Override
	public double getValue() {
		if (expressions != null) {
			double value = expressions[0].getValue();
			for (int i = 1; i < expressions.length; i++) {
				try {
					value = value / expressions[i].getValue();
				} catch (java.lang.ArithmeticException e) {
					return Double.NaN;
				}

			}
			return value;
		}

		return 0;
	}

	@Override
	public String toString() {
		if (expressions != null) {
			String str = "";
			// Judge the priority of the operation in the expression
			if (expressions[0] instanceof Addition || expressions[0] instanceof Subtraction) {
				str = "(" + expressions[0].toString() + ")";

			} else
				str = expressions[0].toString();

			for (int i = 1; i < expressions.length; i++) {

				if (expressions[i] instanceof Constant) {
					str += "/" + expressions[i];
				} else
					str += "/(" + expressions[i] + ")";
			}
			return str;
		}

		return "";

	}

}