package org.eclipse.kura.internal.floodingprotection.configuration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.kura.core.configuration.metatype.ObjectFactory;
import org.eclipse.kura.core.configuration.metatype.Tad;
import org.eclipse.kura.core.configuration.metatype.Tocd;
import org.eclipse.kura.core.configuration.metatype.Tscalar;
import org.eclipse.kura.security.IntrusionDetectionConfiguration;

public class FloodingProtectionOptions {

    private static final String PID = "org.eclipse.kura.floodingprotection.configuration.FloodingProtectionConfigurator";
    private static final String FP_DESCRIPTION = "The service enables flooding protection mechanisms via iptables.";
    private static final String FP_ENABLED_PROP_NAME = "flooding.protection.enabled";
    private static final String FP_ENABLED_DESCRIPTION = "Enable flooding protection feature.";
    private static final String FP_CONN_LIMIT_PROP_NAME = "flooding.protection.conn.limit";
    private static final String FP_CONN_LIMIT_DESCRIPTION = "The maximum number of parallel connections per IP address.";
    private static final String FP_LIMIT_PROP_NAME = "flooding.protection.limit";
    private static final String FP_LIMIT_DESCRIPTION = "The maximum average number of new TCP connections allowed per second.";
    private static final String FP_BURST_LIMIT_PROP_NAME = "flooding.protection.limit.burst";
    private static final String FP_BURST_LIMIT_DESCRIPTION = "The maximum burst of new TCP connection attempts before the limit is enabled.";
    private static final String FP_RST_LIMIT_PROP_NAME = "flooding.protection.rst.limit";
    private static final String FP_RST_LIMIT_DESCRIPTION = "The maximum average number of TCP RST packets allowed per second.";
    private static final String FP_RST_BURST_LIMIT_PROP_NAME = "flooding.protection.rst.limit.burst";
    private static final String FP_RST_BURSTLIMIT_DESCRIPTION = "The maximum burst of TCP RST packets before the limit is enabled.";
    private static final boolean FP_ENABLED_DEFAULT = false;
    private static final int FP_CONN_LIMIT_DEFAULT = 111;
    private static final int FP_LIMIT_DEFAULT = 60;
    private static final int FP_BURST_LIMIT_DEFAULT = 20;
    private static final int FP_RST_LIMIT_DEFAULT = 2;
    private static final int FP_RST_BURST_LIMIT_DEFAULT = 2;

    private IntrusionDetectionConfiguration idsConfig;

    public FloodingProtectionOptions(Map<String, Object> properties) {
        setProperties(properties);
    }

    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(FP_ENABLED_PROP_NAME, this.idsConfig.isEnabled());
        properties.put(FP_CONN_LIMIT_PROP_NAME, this.idsConfig.getConnLimit());
        properties.put(FP_LIMIT_PROP_NAME, this.idsConfig.getLimit());
        properties.put(FP_BURST_LIMIT_PROP_NAME, this.idsConfig.getBurstLimit());
        properties.put(FP_RST_LIMIT_PROP_NAME, this.idsConfig.getRstLimit());
        properties.put(FP_RST_BURST_LIMIT_PROP_NAME, this.idsConfig.getRstBurstLimit());
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        boolean enabled = (boolean) properties.getOrDefault(FP_ENABLED_PROP_NAME, FP_ENABLED_DEFAULT);
        int connLimit = (int) properties.getOrDefault(FP_CONN_LIMIT_PROP_NAME, FP_CONN_LIMIT_DEFAULT);
        int limit = (int) properties.getOrDefault(FP_LIMIT_PROP_NAME, FP_LIMIT_DEFAULT);
        int burstLimit = (int) properties.getOrDefault(FP_BURST_LIMIT_PROP_NAME, FP_BURST_LIMIT_DEFAULT);
        int rstLimit = (int) properties.getOrDefault(FP_RST_LIMIT_PROP_NAME, FP_RST_LIMIT_DEFAULT);
        int rstBurstLimit = (int) properties.getOrDefault(FP_RST_BURST_LIMIT_PROP_NAME, FP_RST_BURST_LIMIT_DEFAULT);
        this.idsConfig = new IntrusionDetectionConfiguration(enabled, connLimit, limit, burstLimit, rstLimit,
                rstBurstLimit);
    }

    public String getPid() {
        return PID;
    }

    public IntrusionDetectionConfiguration getConfiguration() {
        return this.idsConfig;
    }

    public Tocd getDefinition() {
        ObjectFactory objectFactory = new ObjectFactory();
        Tocd tocd = objectFactory.createTocd();
        tocd.setName("Flooding Protection Service");
        tocd.setId(PID);
        tocd.setDescription(FP_DESCRIPTION);

        Tad tadEnabled = objectFactory.createTad();
        tadEnabled.setId(FP_ENABLED_PROP_NAME);
        tadEnabled.setName(FP_ENABLED_PROP_NAME);
        tadEnabled.setType(Tscalar.BOOLEAN);
        tadEnabled.setRequired(true);
        tadEnabled.setDefault("false");
        tadEnabled.setDescription(FP_ENABLED_DESCRIPTION);
        tocd.addAD(tadEnabled);

        Tad tadConnLimit = objectFactory.createTad();
        tadConnLimit.setId(FP_CONN_LIMIT_PROP_NAME);
        tadConnLimit.setName(FP_CONN_LIMIT_PROP_NAME);
        tadConnLimit.setType(Tscalar.INTEGER);
        tadConnLimit.setRequired(true);
        tadConnLimit.setDefault("111");
        tadConnLimit.setDescription(FP_CONN_LIMIT_DESCRIPTION);
        tocd.addAD(tadConnLimit);

        Tad tadLimit = objectFactory.createTad();
        tadLimit.setId(FP_LIMIT_PROP_NAME);
        tadLimit.setName(FP_LIMIT_PROP_NAME);
        tadLimit.setType(Tscalar.INTEGER);
        tadLimit.setRequired(true);
        tadLimit.setDefault("60");
        tadLimit.setDescription(FP_LIMIT_DESCRIPTION);
        tocd.addAD(tadLimit);

        Tad tadBurstLimit = objectFactory.createTad();
        tadBurstLimit.setId(FP_BURST_LIMIT_PROP_NAME);
        tadBurstLimit.setName(FP_BURST_LIMIT_PROP_NAME);
        tadBurstLimit.setType(Tscalar.INTEGER);
        tadBurstLimit.setRequired(true);
        tadBurstLimit.setDefault("20");
        tadBurstLimit.setDescription(FP_BURST_LIMIT_DESCRIPTION);
        tocd.addAD(tadBurstLimit);

        Tad tadRSTLimit = objectFactory.createTad();
        tadRSTLimit.setId(FP_RST_LIMIT_PROP_NAME);
        tadRSTLimit.setName(FP_RST_LIMIT_PROP_NAME);
        tadRSTLimit.setType(Tscalar.INTEGER);
        tadRSTLimit.setRequired(true);
        tadRSTLimit.setDefault("2");
        tadRSTLimit.setDescription(FP_RST_LIMIT_DESCRIPTION);
        tocd.addAD(tadRSTLimit);

        Tad tadRSTBurstLimit = objectFactory.createTad();
        tadRSTBurstLimit.setId(FP_RST_BURST_LIMIT_PROP_NAME);
        tadRSTBurstLimit.setName(FP_RST_BURST_LIMIT_PROP_NAME);
        tadRSTBurstLimit.setType(Tscalar.INTEGER);
        tadRSTBurstLimit.setRequired(true);
        tadRSTBurstLimit.setDefault("2");
        tadRSTBurstLimit.setDescription(FP_RST_BURSTLIMIT_DESCRIPTION);
        tocd.addAD(tadRSTBurstLimit);

        return tocd;
    }
}
