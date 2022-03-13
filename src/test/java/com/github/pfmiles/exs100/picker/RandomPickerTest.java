/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.picker;

import com.github.pfmiles.exs100.model.Ex;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pf-miles
 * <p>
 * 2022-03-14 01:38
 */
public class RandomPickerTest {

    @Test
    public void test() {
        List<Ex> exs = new ArrayList<>();
        exs.add(new Ex());

        Assert.assertEquals(Collections.emptyList(), RandomPicker.pick(null, 100));

        Assert.assertEquals(Collections.emptyList(), RandomPicker.pick(exs, 0));

        Assert.assertEquals(exs, RandomPicker.pick(exs, 1));

        exs = new ArrayList<>();
        exs.add(new Ex());
        exs.add(new Ex());
        exs.add(new Ex());

        Assert.assertEquals(1, RandomPicker.pick(exs, 1).size());

        Assert.assertEquals(2, RandomPicker.pick(exs, 2).size());
    }
}
