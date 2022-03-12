/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.exseq;

import com.github.pfmiles.exs100.model.Operator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A finite sequence of integer polynomial equations.
 *
 * @author pf-miles
 * <p>
 * 2022-03-10 00:39
 */
public class IntegerExSeq extends AbstractExSeq<Integer> {

    /**
     * Create a integer ex sequence.
     *
     * @param termCount   count of terms a generated polynomial have
     * @param startNumber start number, inclusive
     * @param endNumber   end number, exclusive
     * @param ops         operator list to use
     */
    public IntegerExSeq(int termCount, Integer startNumber, Integer endNumber, Operator[] ops) {
        super(termCount, startNumber, endNumber, ops);
        if (startNumber > endNumber)
            throw new IllegalArgumentException("End number must be greater equal than start number.");
    }

    @Override
    public int size() {
        int numCount = (this.endNumber - this.startNumber);
        int opCount = this.ops.size();
        return ((int) Math.pow(numCount, termCount)) * ((int) Math.pow(opCount, termCount - 1));
    }

    @Override
    protected List<? extends Number> resolveNumSeq() {
        return IntStream.range(this.startNumber, this.endNumber).boxed().collect(Collectors.toList());
    }

}
