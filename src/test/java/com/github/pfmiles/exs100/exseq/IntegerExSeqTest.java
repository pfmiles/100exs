/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.exseq;

import com.github.pfmiles.exs100.model.Ex;
import com.github.pfmiles.exs100.model.Operators;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pf-miles
 * <p>
 * 2022-03-12 21:18
 */
public class IntegerExSeqTest {

    @Test
    public void test() {
        IntegerExSeq seq = new IntegerExSeq(2, 1, 3, Operators.values());
        Assert.assertEquals(8, seq.size());
        for (Ex ex : seq) {
            System.out.println(ex.toPrettyPrintString(true));
        }

        seq = new IntegerExSeq(1, 1, 2, Operators.values());
        Assert.assertEquals(1, seq.size());
        for (Ex ex : seq) {
            System.out.println(ex.toPrettyPrintString(true));
        }

        seq = new IntegerExSeq(5, -10, 10, Operators.values());
        Assert.assertEquals(51200000, seq.size());
        int count = 0;
        for (Ex ex : seq) {
            count++;
        }
        Assert.assertEquals(51200000, count);
    }
}
