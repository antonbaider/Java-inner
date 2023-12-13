package jom.com.softserve.s3.task3;

public class Operation {
	public static double execute(int a, int b, Strategy strategy) {
		return strategy.doOperation(a, b);
	}
	public static double addAtoB(int a, int b) {
		return execute(a, b, new Strategy() {
			@Override
			public double doOperation(int a, int b) {
				return a + b;
			}
		});
	}

	public static double subtractBfromA(int a, int b) {
		return execute(a, b, new Strategy() {
			@Override
			public double doOperation(int a, int b) {
				return a - b;
			}
		});
	}

	public static double multiplyAbyB(int a, int b) {
		return execute(a, b, new Strategy() {
			@Override
			public double doOperation(int a, int b) {
				return a * b;
			}
		});
	}

	public static double divideAbyB(int a, int b) {
		return execute(a, b, new Strategy() {
			@Override
			public double doOperation(int a, int b) {
				if (b != 0) {
					return a / b;
				} else {
					throw new IllegalArgumentException("Cannot divide by zero");
				}
			}
		});
	}
}
