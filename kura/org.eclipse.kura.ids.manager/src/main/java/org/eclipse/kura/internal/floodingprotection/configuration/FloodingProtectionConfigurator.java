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
 * Eurotech
 ******************************************************************************/
package org.eclipse.kura.internal.floodingprotection.configuration;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.kura.KuraException;
import org.eclipse.kura.configuration.ComponentConfiguration;
import org.eclipse.kura.configuration.SelfConfiguringComponent;
import org.eclipse.kura.core.configuration.ComponentConfigurationImpl;
import org.eclipse.kura.core.configuration.metatype.ObjectFactory;
import org.eclipse.kura.core.configuration.metatype.Tad;
import org.eclipse.kura.core.configuration.metatype.Tocd;
import org.eclipse.kura.core.configuration.metatype.Tscalar;
import org.eclipse.kura.executor.CommandExecutorService;
import org.eclipse.kura.linux.net.iptables.LinuxFirewall;
import org.eclipse.kura.security.IntrusionDetectionService;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloodingProtectionConfigurator implements IntrusionDetectionService, SelfConfiguringComponent {

    private static final Logger logger = LoggerFactory.getLogger(FloodingProtectionConfigurator.class);
    public static final String PID = "org.eclipse.kura.floodingprotection.configuration.FloodingProtectionConfigurator";
    private static final String DESCRIPTION_FAIL2BAN_SERVICE = "The service enables flooding protection mechanisms via iptables.";
    private static final String FLOODING_PROTECTION_ENABLED_PROP_NAME = "flooding.protection.enabled";
    private final Map<String, Object> properties = new HashMap<>();
    private CommandExecutorService executorService;

    protected void setCommandExecutorService(CommandExecutorService executorService) {
        this.executorService = executorService;
    }

    protected void unsetCommandExecutorService(CommandExecutorService executorService) {
        if (this.executorService == executorService) {
            this.executorService = null;
        }
    }

    protected void activate(ComponentContext componentContext, Map<String, Object> properties) {
        logger.info("Activating FloodingConfigurator...");

        doUpdate(properties);

        logger.info("Activating FloodingConfigurator... Done.");
    }

    protected void updated(Map<String, Object> properties) {
        logger.info("Updating FloodingConfigurator...");

        doUpdate(properties);

        logger.info("Updating FloodingConfigurator... Done.");
    }

    protected void deactivate(ComponentContext componentContext) {
        logger.info("Deactivating FloodingConfigurator...");

        logger.info("Deactivating FloodingConfigurator... Done.");

    }

    private void doUpdate(Map<String, Object> properties) {
        this.properties.clear();
        this.properties.putAll(properties);
        try {
            setStatus(isEnabled());
        } catch (KuraException e) {
            logger.warn("Error managing flooding system service");
        }
    }

    private boolean isEnabled() {

        Object value = this.properties.get(FLOODING_PROTECTION_ENABLED_PROP_NAME);
        if (!isNull(value)) {
            return (boolean) value;
        }

        return false;
    }

    private void setStatus(boolean status) throws KuraException {
        logger.info("Ids setting status: {}", status);

        LinuxFirewall linuxFirewall = new LinuxFirewall(this.executorService);
        linuxFirewall.setFloodingProtectionStatus(status);
        linuxFirewall.enable();
        this.properties.put(FLOODING_PROTECTION_ENABLED_PROP_NAME, status);
    }

    @Override
    public ComponentConfiguration getConfiguration() throws KuraException {
        logger.info("getConfiguration()");
        return new ComponentConfigurationImpl(PID, getDefinition(), getProperties());
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public Tocd getDefinition() {
        ObjectFactory objectFactory = new ObjectFactory();
        Tocd tocd = objectFactory.createTocd();
        tocd.setName("Flooding Protection Service");
        tocd.setId(PID);
        tocd.setDescription(DESCRIPTION_FAIL2BAN_SERVICE);

        Tad tad = objectFactory.createTad();
        tad.setId(FLOODING_PROTECTION_ENABLED_PROP_NAME);
        tad.setName(FLOODING_PROTECTION_ENABLED_PROP_NAME);
        tad.setType(Tscalar.BOOLEAN);
        tad.setRequired(true);
        tad.setDefault("false");
        tad.setDescription("Enable/Disable flooding protection feature");
        tocd.addAD(tad);

        return tocd;
    }

}
