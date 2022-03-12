package com.github.pfmiles.exs100.model;

/**
 * All implemented operators.
 *
 * @author pf-miles
 */
public enum Operators implements Operator {
    add {
        @Override
        public Double computeDouble(Number left, Number right) {
            return left.doubleValue() + right.doubleValue();
        }

        @Override
        public Integer computeInt(Number left, Number right) {
            return left.intValue() + right.intValue();
        }

        public String toString() {
            return "+";
        }
    },

    minus {
        @Override
        public Double computeDouble(Number left, Number right) {
            return left.doubleValue() - right.doubleValue();
        }

        @Override
        public Integer computeInt(Number left, Number right) {
            return left.intValue() - right.intValue();
        }

        public String toString() {
            return "-";
        }
    }

}
