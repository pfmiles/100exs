/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.model;

import com.github.pfmiles.exs100.impl.ExComputer;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * An exercise. It's a polynomial equation.
 *
 * @author pf-miles
 * <p>
 * 2022-03-07 23:24
 */
public class Ex {
    private List<Number> numbers;
    private List<Operator> ops;
    private Number result;

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

    public Number getResult() {
        if (this.result == null) this.result = ExComputer.compute(this);
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public String toPrettyPrintString(boolean withResult) {
        if (CollectionUtils.isEmpty(numbers)) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.numbers.get(0));
        for (int i = 0; i < this.ops.size(); i++) {
            sb.append(' ').append(this.ops.get(i)).append(' ').append(this.numbers.get(i + 1));
        }
        sb.append(" =");
        if (withResult) sb.append(' ').append(this.getResult());
        return sb.toString();
    }
}
