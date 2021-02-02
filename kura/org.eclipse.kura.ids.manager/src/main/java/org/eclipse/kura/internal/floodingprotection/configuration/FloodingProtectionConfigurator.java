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

import java.util.Map;

import org.eclipse.kura.KuraException;
import org.eclipse.kura.configuration.ComponentConfiguration;
import org.eclipse.kura.configuration.SelfConfiguringComponent;
import org.eclipse.kura.core.configuration.ComponentConfigurationImpl;
import org.eclipse.kura.executor.CommandExecutorService;
import org.eclipse.kura.linux.net.iptables.LinuxFirewall;
import org.eclipse.kura.security.IntrusionDetectionService;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloodingProtectionConfigurator implements IntrusionDetectionService, SelfConfiguringComponent {

    private static final Logger logger = LoggerFactory.getLogger(FloodingProtectionConfigurator.class);
    private FloodingProtectionOptions floodingProtectionOptions;
    private LinuxFirewall linuxFirewall;
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

        this.linuxFirewall = new LinuxFirewall(this.executorService);
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
        this.floodingProtectionOptions = new FloodingProtectionOptions(properties);
        try {
            this.linuxFirewall.setFloodingProtectionConfiguration(this.floodingProtectionOptions.getConfiguration());
            this.linuxFirewall.enable();
        } catch (KuraException e) {
            logger.warn("Error managing flooding system service");
        }
    }

    @Override
    public ComponentConfiguration getConfiguration() throws KuraException {
        return new ComponentConfigurationImpl(this.floodingProtectionOptions.getPid(),
                this.floodingProtectionOptions.getDefinition(), this.floodingProtectionOptions.getProperties());
    }

}
