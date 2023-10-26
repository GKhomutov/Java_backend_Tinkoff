package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

   record Negate(Expr expr) implements Expr {
        public Negate(double value) {
            this(new Constant(value));
        }

        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    record Exponent(Expr base, Expr exponent) implements Expr {
        public Exponent(double base, double exponent) {
            this(new Constant(base), new Constant(exponent));
        }

        public Exponent(Expr base, double exponent) {
            this(base, new Constant(exponent));
        }

        public Exponent(double base, Expr exponent) {
            this(new Constant(base), exponent);
        }

        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), exponent.evaluate());
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        public Addition(double left, double right) {
            this(new Constant(left), new Constant(right));
        }

        public Addition(Expr left, double right) {
            this(left, new Constant(right));
        }

        public Addition(double left, Expr right) {
            this(new Constant(left), right);
        }

        @Override
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        public Multiplication(double left, double right) {
            this(new Constant(left), new Constant(right));
        }

        public Multiplication(Expr left, double right) {
            this(left, new Constant(right));
        }

        public Multiplication(double left, Expr right) {
            this(new Constant(left), right);
        }


        @Override
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}
