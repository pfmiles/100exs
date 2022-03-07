package com.github.pfmiles.model;

/**
 * A binary operator in math equations.
 *
 * @author pf-miles
 */
public interface Operator {
    /**
     * Do the computation.
     *
     * @param left  left operand
     * @param right right operand
     * @return the result
     */
    default Number compute(Number left, Number right) {
        if (left instanceof Double || right instanceof Double) {
            return computeDouble(left, right);
        } else {
            return computeInt(left, right);
        }
    }

    /**
     * Do floating point computation.
     *
     * @param left  left
     * @param right right
     * @return result
     */
    Double computeDouble(Number left, Number right);

    /**
     * Do integral computation.
     *
     * @param left  left
     * @param right right
     * @return result
     */
    Integer computeInt(Number left, Number right);
}
