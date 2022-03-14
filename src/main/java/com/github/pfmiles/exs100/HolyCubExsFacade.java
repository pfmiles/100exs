/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100;

import com.github.pfmiles.exs100.exseq.IntegerExSeq;
import com.github.pfmiles.exs100.model.Ex;
import com.github.pfmiles.exs100.model.Operator;
import com.github.pfmiles.exs100.picker.RandomPicker;
import com.github.pfmiles.exs100.render.A4PdfRenderer;
import com.github.pfmiles.exs100.render.StringRenderer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * The facade service to generate the whole staff.
 *
 * @author pf-miles
 * <p>
 * 2022-03-12 22:56
 */
public class HolyCubExsFacade {
    /**
     * Generate 100 exercises in an A4 pdf file as a byte array.
     *
     * @param termCount   how many terms does a single exercise equation have?
     * @param startNumber the lower bound of all operands in an exercise equation, inclusive
     * @param endNumber   the upper bound of all operands in an exercise equation, exclusive
     * @param ops         all the possible operators be used in the generated exercises
     * @param filter      for choosing qualified exercises
     * @return A4 pdf file data as a byte array
     */
    public static byte[] gen100IntExsA4Pdf(int termCount, int startNumber, int endNumber, Operator[] ops, Predicate<Ex> filter) {
        return new A4PdfRenderer().render(gen100IntExs(termCount, startNumber, endNumber, ops, filter));
    }

    public static String gen100IntExsString(int termCount, int startNumber, int endNumber, Operator[] ops, Predicate<Ex> filter, String separator) {
        return new String(new StringRenderer(separator).render(gen100IntExs(termCount, startNumber, endNumber, ops, filter)), StandardCharsets.UTF_8);
    }

    private static List<Ex> gen100IntExs(int termCount, int startNumber, int endNumber, Operator[] ops, Predicate<Ex> filter) {
        // gen all possible equation list
        IntegerExSeq seq = new IntegerExSeq(termCount, startNumber, endNumber, ops);
        // filter out the qualified ones
        List<Ex> filtered = new ArrayList<>();
        for (Ex ex : seq) {
            if (filter.test(ex)) {
                filtered.add(ex);
            }
        }
        // random pick 100 of them
        List<Ex> picked = RandomPicker.pick(filtered, 100);
        // shuffle
        Collections.shuffle(picked);
        return picked;
    }
}
