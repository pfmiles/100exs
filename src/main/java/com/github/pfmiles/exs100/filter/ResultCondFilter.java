/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.filter;

import com.github.pfmiles.exs100.model.Ex;
import com.google.common.base.Preconditions;

import java.util.function.Predicate;

/**
 * A predicate which enforces rules on exercise result.
 *
 * @author pf-miles
 * <p>
 * 2022-03-14 19:44
 */
public class ResultCondFilter implements Predicate<Ex> {
    private final String compareSign;
    private final Number compareValue;

    public ResultCondFilter(String compareSign, Number compareValue) {
        Preconditions.checkNotNull(compareSign);
        Preconditions.checkNotNull(compareValue);
        this.compareSign = compareSign;
        this.compareValue = compareValue;
    }

    @Override
    public boolean test(Ex ex) {
        Number result = ex.getResult();
        switch (compareSign) {
            case ">":
                if (result instanceof Integer) {
                    return result.intValue() > compareValue.intValue();
                } else {
                    return result.doubleValue() > compareValue.doubleValue();
                }
            case "<":
                if (result instanceof Integer) {
                    return result.intValue() < compareValue.intValue();
                } else {
                    return result.doubleValue() < compareValue.doubleValue();
                }
            case ">=":
                if (result instanceof Integer) {
                    return result.intValue() >= compareValue.intValue();
                } else {
                    return result.doubleValue() >= compareValue.doubleValue();
                }
            case "<=":
                if (result instanceof Integer) {
                    return result.intValue() <= compareValue.intValue();
                } else {
                    return result.doubleValue() <= compareValue.doubleValue();
                }
            case "=":
                return result.equals(compareValue);
            default:
                throw new IllegalArgumentException("Invalid compare sign: " + compareSign);
        }
    }

}
