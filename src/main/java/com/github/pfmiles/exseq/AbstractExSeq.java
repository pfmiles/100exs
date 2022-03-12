package com.github.pfmiles.exseq;

import com.github.pfmiles.impl.FullArrangementIterator;
import com.github.pfmiles.model.Ex;
import com.github.pfmiles.model.Operator;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A finite exercises sequence.
 *
 * @author pf-miles
 */
public abstract class AbstractExSeq<T extends Number> implements Iterable<Ex> {
    // the term count of each Ex(polynomial)
    protected final int termCount;

    protected final T startNumber;
    protected final T endNumber;
    protected final List<Operator> ops;

    protected AbstractExSeq(int termCount, T startNumber, T endNumber, Operator[] ops) {
        this.termCount = termCount;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        if (ArrayUtils.isEmpty(ops)) throw new IllegalArgumentException("Operator list must not be empty.");
        this.ops = Arrays.asList(ops);
    }

    /**
     * The size of the finite sequence
     *
     * @return size
     */
    public abstract int size();

    /**
     * generate the number sequence to use
     *
     * @return num seq
     */
    protected abstract List<? extends Number> resolveNumSeq();

    @Override
    public Iterator<Ex> iterator() {
        // construct element array
        int len = this.termCount + this.termCount - 1;
        List<?>[] eleArrs = new List<?>[len];
        List<? extends Number> nums = this.resolveNumSeq();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                eleArrs[i] = nums;
            } else {
                eleArrs[i] = ops;
            }
        }

        return new Iterator<Ex>() {
            private final FullArrangementIterator iter = new FullArrangementIterator(eleArrs);

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Ex next() {
                List<Object> arrange = iter.next();
                Ex ret = new Ex();
                List<Number> nums = new ArrayList<>();
                ret.setNumbers(nums);
                List<Operator> ops = new ArrayList<>();
                ret.setOps(ops);
                for (int i = 0; i < len; i++) {
                    if (i % 2 == 0) {
                        nums.add((Number) arrange.get(i));
                    } else {
                        ops.add((Operator) arrange.get(i));
                    }
                }
                return ret;
            }
        };
    }

    public int getTermCount() {
        return termCount;
    }

    public T getStartNumber() {
        return startNumber;
    }

    public T getEndNumber() {
        return endNumber;
    }

    public List<Operator> getOps() {
        return ops;
    }
}
