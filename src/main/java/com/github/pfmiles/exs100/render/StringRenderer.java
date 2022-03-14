/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.github.pfmiles.exs100.render;

import com.github.pfmiles.exs100.model.Ex;
import org.apache.commons.collections4.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Render list of exercises as a long string, in form of each exercise separated by the separator.
 *
 * @author pf-miles
 * <p>
 * 2022-03-14 19:21
 */
public class StringRenderer implements Renderer {
    private final String separator;

    public StringRenderer(String separator) {
        if (separator == null) throw new IllegalArgumentException("Separator cannot be null.");
        this.separator = separator;
    }

    @Override
    public byte[] render(List<Ex> exs) {
        if (CollectionUtils.isEmpty(exs)) return new byte[0];
        StringBuilder sb = new StringBuilder();
        sb.append(exs.get(0));
        for (int i = 1; i < exs.size(); i++) {
            sb.append(separator).append(exs.get(i));
        }
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }
}
