/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.render;

import com.github.pfmiles.exs100.model.Ex;

import java.util.List;

/**
 * Render list of exs as byte array of an output format.
 *
 * @author pf-miles
 * <p>
 * 2022-03-12 23:24
 */
public interface Renderer {
    /**
     * Render exercises to bytes.
     *
     * @param exs exercises
     * @return bytes of an output format
     */
    byte[] render(List<Ex> exs);
}
