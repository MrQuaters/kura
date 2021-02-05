/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Eurotech
 ******************************************************************************/
package org.eclipse.kura.security;

public class IntrusionDetectionConfiguration {

    private boolean enabled;
    private int connLimit;
    private int limit;
    private int burstLimit;
    private int rstLimit;
    private int rstBurstLimit;

    public IntrusionDetectionConfiguration() {
        this.enabled = false;
        this.connLimit = 80;
        this.limit = 60;
        this.burstLimit = 20;
        this.rstLimit = 60;
        this.rstBurstLimit = 20;
    }

    public IntrusionDetectionConfiguration(boolean enabled, int connLimit, int limit, int burstLimit, int rstLimit,
            int rstBurstLimit) {
        this.enabled = enabled;
        this.connLimit = connLimit;
        this.limit = limit;
        this.burstLimit = burstLimit;
        this.rstLimit = rstLimit;
        this.rstBurstLimit = rstBurstLimit;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getConnLimit() {
        return this.connLimit;
    }

    public void setConnLimit(int connLimit) {
        this.connLimit = connLimit;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int tcpLimit) {
        this.limit = tcpLimit;
    }

    public int getBurstLimit() {
        return this.burstLimit;
    }

    public void setBurstLimit(int tcpBurstLimit) {
        this.burstLimit = tcpBurstLimit;
    }

    public int getRstLimit() {
        return this.rstLimit;
    }

    public void setRstLimit(int rstLimit) {
        this.rstLimit = rstLimit;
    }

    public int getRstBurstLimit() {
        return this.rstBurstLimit;
    }

    public void setRstBurstLimit(int rstBurstLimit) {
        this.rstBurstLimit = rstBurstLimit;
    }

}
