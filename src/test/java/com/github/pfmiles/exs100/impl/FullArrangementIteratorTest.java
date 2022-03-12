/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pf-miles
 * <p>
 * 2022-03-12 00:47
 */
public class FullArrangementIteratorTest {
    @Test
    public void test() {
        List<String> nums = new ArrayList<>();
        nums.add("1");
        List<?>[] elementArrs = new List<?>[]{nums};
        FullArrangementIterator iter = new FullArrangementIterator(elementArrs);
        List<Object> arrangements = new ArrayList<>();
        while (iter.hasNext()) {
            List<Object> arrangement = iter.next();
//            System.out.println(arrangement);
            arrangements.add(arrangement);
        }
        Assert.assertEquals(1, arrangements.size());

        nums = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            nums.add(String.valueOf(i + 1));
        }
        List<String> ops = new ArrayList<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("\\");
        elementArrs = new List<?>[]{nums, ops, nums};
        iter = new FullArrangementIterator(elementArrs);
        arrangements = new ArrayList<>();
        while (iter.hasNext()) {
            List<Object> arrangement = iter.next();
//            System.out.println(arrangement);
            arrangements.add(arrangement);
        }
        Assert.assertEquals(40000, arrangements.size());

        nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nums.add(String.valueOf(i + 1));
        }
        ops = new ArrayList<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("\\");
        elementArrs = new List<?>[]{nums, ops, nums, ops, nums};
        iter = new FullArrangementIterator(elementArrs);
        arrangements = new ArrayList<>();
        while (iter.hasNext()) {
            List<Object> arrangement = iter.next();
//            System.out.println(arrangement);
            arrangements.add(arrangement);
        }
        Assert.assertEquals(2000, arrangements.size());
    }
}
