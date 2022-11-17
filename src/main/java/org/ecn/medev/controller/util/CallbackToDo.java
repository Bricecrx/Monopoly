/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package org.ecn.medev.controller.util;

/**
 * The Callback interface is designed to allow for a common, reusable interface
 * to exist for defining APIs that requires a call back in certain situations.
 * <p>
 */
@FunctionalInterface
public interface CallbackToDo {
    /**
     * The <code>call</code> without return
     */
    public void call();
}
