package io.smallrye.reactive.messaging.mqtt;

import java.util.concurrent.TimeUnit;

import io.vertx.core.net.JksOptions;
import io.vertx.core.net.KeyCertOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.core.net.PemTrustOptions;
import io.vertx.core.net.PfxOptions;
import io.vertx.core.net.TrustOptions;
import io.vertx.mqtt.MqttClientOptions;

public class MqttHelpers {

    private MqttHelpers() {
        // avoid direct instantiation.
    }

    static MqttClientOptions createMqttClientOptions(MqttConnectorCommonConfiguration config) {
        MqttClientOptions options = new MqttClientOptions();
        options.setCleanSession(config.getAutoCleanSession());
        options.setAutoGeneratedClientId(config.getAutoGeneratedClientId());
        options.setAutoKeepAlive(config.getAutoKeepAlive());
        options.setClientId(config.getClientId().orElse(null));
        options.setConnectTimeout(config.getConnectTimeoutSeconds());
        options.setKeepAliveInterval(config.getKeepAliveSeconds());
        options.setMaxInflightQueue(config.getMaxInflightQueue());
        options.setMaxMessageSize(config.getMaxMessageSize());
        options.setPassword(config.getPassword().orElse(null));
        options.setReconnectAttempts(config.getReconnectAttempts());
        options.setReconnectInterval(TimeUnit.SECONDS.toMillis(config.getReconnectIntervalSeconds()));
        options.setSsl(config.getSsl());
        options.setKeyCertOptions(getKeyCertOptions(config));
        options.setTrustOptions(getTrustOptions(config));
        options.setTrustAll(config.getTrustAll());
        options.setUsername(config.getUsername().orElse(null));
        options.setWillQoS(config.getWillQos());
        options.setWillFlag(config.getWillFlag());
        options.setWillRetain(config.getWillRetain());
        return options;
    }

    /**
     * Create KeyCertOptions value from the configuration.
     * Attribute Name: ssl.keystore
     * Description: Set whether keystore type, location and password. In case of pem type the location and password are the cert
     * and key path.
     * Default Value: PfxOptions
     * 
     * @return the KeyCertOptions
     */
    private static KeyCertOptions getKeyCertOptions(MqttConnectorCommonConfiguration config) {

        if (config.getSsl() && config.getSslKeystoreLocation().isPresent()) {
            String keyStoreLocation = config.getSslKeystoreLocation().get();
            String sslKeystoreType = config.getSslKeystoreType();

            if (config.getSslKeystorePassword().isPresent()) {
                String keyStorePassword = config.getSslKeystorePassword().get();
                if ("jks".equalsIgnoreCase(sslKeystoreType)) {
                    return new JksOptions()
                            .setPath(keyStoreLocation)
                            .setPassword(keyStorePassword);
                } else if ("pem".equalsIgnoreCase(sslKeystoreType)) {
                    return new PemKeyCertOptions()
                            .setCertPath(keyStoreLocation)
                            .setKeyPath(keyStorePassword);
                }
                // Default
                return new PfxOptions()
                        .setPath(keyStoreLocation)
                        .setPassword(keyStorePassword);
            } else {
                new IllegalArgumentException("The attribute `ssl.keystore.password` on connector 'smallrye-mqtt' (channel: "
                        + config.getChannel() + ") must be set for `ssl.keystore.type`" + sslKeystoreType);
            }
        }
        return null;
    }

    /**
     * Gets the truststore value from the configuration.
     * Attribute Name: ssl.truststore
     * Description: Set whether keystore type, location and password. In case of pem type the location is the cert path.
     * Default Value: PfxOptions
     * 
     * @return the TrustOptions
     */

    private static TrustOptions getTrustOptions(MqttConnectorCommonConfiguration config) {

        if (config.getSsl() && config.getSslTruststoreLocation().isPresent()) {
            String truststoreLocation = config.getSslTruststoreLocation().get();
            String truststoreType = config.getSslTruststoreType();

            if ("pem".equalsIgnoreCase(truststoreType)) {
                return new PemTrustOptions()
                        .addCertPath(truststoreLocation);
            } else if (config.getSslTruststorePassword().isPresent()) {
                String truststorePassword = config.getSslTruststorePassword().get();
                if ("jks".equalsIgnoreCase(truststoreType)) {
                    return new JksOptions()
                            .setPath(truststoreLocation)
                            .setPassword(truststorePassword);
                }
                // Default
                return new PfxOptions()
                        .setPath(truststoreLocation)
                        .setPassword(truststorePassword);
            } else {
                new IllegalArgumentException("The attribute `ssl.keystore.password` on connector 'smallrye-mqtt' (channel: "
                        + config.getChannel() + ") must be set for `ssl.keystore.type`" + truststoreType);
            }
        }
        return null;
    }

}
