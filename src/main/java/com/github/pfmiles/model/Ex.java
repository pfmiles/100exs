/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.model;

import java.util.List;

/**
 * An exercise.
 *
 * @author pf-miles
 * <p>
 * 2022-03-07 23:24
 */
public class Ex {
    private List<Number> numbers;
    private List<Operator> ops;

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Operator> getOps() {
        return ops;
    }

    public void setOps(List<Operator> ops) {
        this.ops = ops;
    }
}
