/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.impl;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author pf-miles
 * <p>
 * 2022-03-11 00:58
 */
public class FullArrangementIterator implements Iterator<List<Object>> {
    private final List<?>[] elementArrs;
    private final int[] status;

    public FullArrangementIterator(List<?>[] elementsArrs) {
        if (ArrayUtils.isEmpty(elementsArrs)) throw new IllegalArgumentException("elements arrays cannot be empty.");
        this.elementArrs = elementsArrs;
        this.status = new int[this.elementArrs.length];
        Arrays.fill(this.status, 0);
    }

    @Override
    public boolean hasNext() {
        return status[0] < elementArrs[0].size();
    }

    @Override
    public List<Object> next() {
        List<Object> ret = new ArrayList<>(status.length);
        // return current arrangement according to current status
        for (int i = 0; i < status.length; i++) {
            ret.add(elementArrs[i].get(status[i]));
        }
        // update status
        for (int i = status.length - 1; i >= 0; i--) {
            status[i]++;
            if (status[i] == elementArrs[i].size() && i != 0) {
                status[i] = 0;
            } else {
                break;
            }
        }
        return ret;
    }
}
