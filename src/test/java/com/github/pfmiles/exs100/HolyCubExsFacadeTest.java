/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100;

import com.github.pfmiles.exs100.filter.ResultCondFilter;
import com.github.pfmiles.exs100.model.Ex;
import com.github.pfmiles.exs100.model.Operator;
import com.github.pfmiles.exs100.model.Operators;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author pf-miles
 * <p>
 * 2022-03-14 19:41
 */
public class HolyCubExsFacadeTest {
    @Test
    public void test100ExsStringRender() {
        String rst = HolyCubExsFacade.gen100IntExsString(2, 1, 20, new Operator[]{Operators.add, Operators.minus}, buildFilter(), "\n");
        System.out.println(rst);
    }

    private Predicate<Ex> buildFilter() {
        return new ResultCondFilter("<=", 20).and(new ResultCondFilter(">", 0));
    }
}
