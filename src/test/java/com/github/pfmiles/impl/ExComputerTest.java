/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.impl;

import com.github.pfmiles.model.Ex;
import com.github.pfmiles.model.Operator;
import com.github.pfmiles.model.Operators;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author pf-miles
 * <p>
 * 2022-03-08 00:11
 */
public class ExComputerTest {
    @Test
    public void testCompute() {
        // random tests
        for (int i = 0; i < 1000000; i++) {
            Pair<Ex, Number> exAndExp = generateTestCase();
            Assert.assertEquals(exAndExp.getRight(), exAndExp.getLeft().getResult());
        }
    }

    // gen one test case, with expected result
    private Pair<Ex, Number> generateTestCase() {
        Ex ex = new Ex();
        ex.setNumbers(new ArrayList<>());
        ex.setOps(new ArrayList<>());

        int len = ThreadLocalRandom.current().nextInt(1, 8);
        Number first = randOperand();
        ex.getNumbers().add(first);
        Number tmpRst = first;
        for (int i = 0; i < len; i++) {
            Operator op = randOperator();
            Number operand = randOperand();
            tmpRst = compute(tmpRst, op, operand);
            ex.getOps().add(op);
            ex.getNumbers().add(operand);
        }
        return Pair.of(ex, tmpRst);
    }

    private Number compute(Number operand1, Operator op, Number operand2) {
        Operators o = (Operators) op;
        switch (o) {
            case add:
                if (operand1 instanceof Double || operand2 instanceof Double) {
                    return operand1.doubleValue() + operand2.doubleValue();
                } else {
                    return operand1.intValue() + operand2.intValue();
                }
            case minus:
                if (operand1 instanceof Double || operand2 instanceof Double) {
                    return operand1.doubleValue() - operand2.doubleValue();
                } else {
                    return operand1.intValue() - operand2.intValue();
                }
            default:
                throw new UnsupportedOperationException("Unimplemented test logic, operator: " + o.name());
        }
    }

    private Operator randOperator() {
        Operators[] allOps = Operators.values();
        return allOps[ThreadLocalRandom.current().nextInt(0, allOps.length)];
    }

    private Number randOperand() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            // gen int
            return ThreadLocalRandom.current().nextInt(-100000, 100000);
        } else {
            // gen double
            return ThreadLocalRandom.current().nextDouble(-100000.0, 100000.0);
        }
    }
}
