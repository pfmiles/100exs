/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.impl;

import com.github.pfmiles.model.Ex;
import com.github.pfmiles.model.Operator;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author pf-miles
 * <p>
 * 2022-03-07 23:31
 */
public class ExComputer {

    /**
     * tell if the Ex valid.
     *
     * @param ex ex
     * @return if the ex valid
     */
    public static boolean checkExValid(Ex ex) {
        List<Number> ns = ex.getNumbers();
        List<Operator> ops = ex.getOps();
        return CollectionUtils.isNotEmpty(ns) && CollectionUtils.isNotEmpty(ops) && (ns.size() - ops.size() == 1);
    }

    /**
     * Calculate the ex.
     *
     * @param ex ex
     * @return the result number
     */
    public static Number compute(Ex ex) {
        List<Number> ns = ex.getNumbers();
        List<Operator> ops = ex.getOps();

        Number tmp = ns.get(0);
        for (int i = 0; i < ops.size(); i++) {
            tmp = ops.get(i).compute(tmp, ns.get(i + 1));
        }
        return tmp;
    }
}
