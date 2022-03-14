/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.render;

import com.github.pfmiles.exs100.model.Ex;
import com.github.pfmiles.exs100.model.Operators;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pf-miles
 * <p>
 * 2022-03-14 19:37
 */
public class StringRendererTest {
    @Test
    public void test() {
        List<Ex> exs = new ArrayList<>();
        Ex e1 = new Ex();
        e1.setNumbers(new ArrayList<>());
        e1.setOps(new ArrayList<>());
        e1.getNumbers().add(1);
        e1.getNumbers().add(2);
        e1.getOps().add(Operators.add);
        exs.add(e1);
        exs.add(e1);
        exs.add(e1);
        Assert.assertEquals("1 + 2 =\n1 + 2 =\n1 + 2 =", new String(new StringRenderer("\n").render(exs), StandardCharsets.UTF_8));
    }
}
