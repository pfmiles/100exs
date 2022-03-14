/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.render;

import com.github.pfmiles.exs100.model.Ex;

import java.util.List;

/**
 * Render exercises to an A4 pdf file.
 *
 * @author pf-miles
 * <p>
 * 2022-03-12 23:26
 */
public class A4PdfRenderer implements Renderer {
    @Override
    public byte[] render(List<Ex> exs) {
        return new byte[0];
    }
}
