/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.picker;

import com.github.pfmiles.exs100.model.Ex;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Randomly picking exercises.
 *
 * @author pf-miles
 * <p>
 * 2022-03-12 23:43
 */
public class RandomPicker {
    /**
     * Randomly pick `count` elements from the specified list.
     *
     * @param exs   the origin list to pick from
     * @param count the number of elements to pick
     * @return the list of randomly picked elements
     */
    public static List<Ex> pick(List<Ex> exs, int count) {
        if (count < 0) throw new IllegalArgumentException("'count' must be greater equal than 0.");
        if (count == 0 || CollectionUtils.isEmpty(exs)) return Collections.emptyList();
        if (exs.size() < count)
            throw new IllegalArgumentException("The size of the list to be picked elements from must be greater equal than 'count'.");
        if (exs.size() == count) return new ArrayList<>(exs);

        int toDiscard = exs.size() - count;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (count <= toDiscard) {
            Set<Integer> pickedIdx = new HashSet<>();
            while (pickedIdx.size() < count) pickedIdx.add(random.nextInt(exs.size()));
            List<Ex> ret = new ArrayList<>(count);
            for (Integer i : pickedIdx) {
                ret.add(exs.get(i));
            }
            return ret;
        } else {
            Set<Integer> droppedIdx = new HashSet<>();
            while (droppedIdx.size() < toDiscard) droppedIdx.add(random.nextInt(exs.size()));
            List<Ex> ret = new ArrayList<>(exs);
            for (Integer i : droppedIdx) {
                ret.remove(i.intValue());
            }
            return ret;
        }
    }
}
