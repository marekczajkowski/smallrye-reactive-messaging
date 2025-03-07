package io.smallrye.reactive.messaging.mqtt.session;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.netty.handler.logging.ByteBufFormat;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.ClientOptionsBase;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.JksOptions;
import io.vertx.core.net.KeyCertOptions;
import io.vertx.core.net.OpenSSLEngineOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.core.net.PemTrustOptions;
import io.vertx.core.net.PfxOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.SSLEngineOptions;
import io.vertx.core.net.TrustOptions;
import io.vertx.mqtt.MqttClientOptions;

public class MqttClientSessionOptions extends MqttClientOptions {

    private static final ReconnectDelayOptions DEFAULT_RECONNECT_DELAY = new ConstantReconnectDelayOptions();
    private static final Optional<String> DEFAULT_SERVER_NAME = Optional.empty();

    private String hostname = MqttClientOptions.DEFAULT_HOST;
    private Optional<String> serverName = DEFAULT_SERVER_NAME;
    private int port = MqttClientOptions.DEFAULT_PORT;
    private ReconnectDelayOptions reconnectDelay = DEFAULT_RECONNECT_DELAY;
    private boolean unsubscribeOnDisconnect = false;

    /**
     * Default constructor
     */
    public MqttClientSessionOptions() {
        super();
    }

    /**
     * Copy constructor
     *
     * @param other the options to copy
     */
    public MqttClientSessionOptions(MqttClientSessionOptions other) {
        super(other);
        this.hostname = other.hostname;
        this.port = other.port;
        this.serverName = other.serverName;
        this.reconnectDelay = other.reconnectDelay.copy();
    }

    public int getPort() {
        return this.port;
    }

    public MqttClientSessionOptions setPort(int port) {
        this.port = port;
        return this;
    }

    public String getHostname() {
        return this.hostname;
    }

    public MqttClientSessionOptions setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    public MqttClientSessionOptions setReconnectDelay(ReconnectDelayOptions reconnectDelay) {
        this.reconnectDelay = reconnectDelay;
        return this;
    }

    public ReconnectDelayOptions getReconnectDelay() {
        return this.reconnectDelay;
    }

    public Optional<String> getServerName() {
        return serverName;
    }

    public MqttClientSessionOptions setServerName(Optional<String> serverName) {
        this.serverName = serverName;
        return this;
    }

    public boolean isUnsubscribeOnDisconnect() {
        return unsubscribeOnDisconnect;
    }

    public void setUnsubscribeOnDisconnect(boolean unsubscribeOnDisconnect) {
        this.unsubscribeOnDisconnect = unsubscribeOnDisconnect;
    }

    @Override
    public MqttClientSessionOptions setClientId(String clientId) {
        super.setClientId(clientId);
        return this;
    }

    @Override
    public MqttClientSessionOptions setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    public MqttClientSessionOptions setPassword(String password) {
        super.setPassword(password);
        return this;
    }

    @Override
    public MqttClientSessionOptions setWillTopic(String willTopic) {
        super.setWillTopic(willTopic);
        return this;
    }

    @Override
    @Deprecated
    public MqttClientSessionOptions setWillMessage(String willMessage) {
        super.setWillMessage(willMessage);
        return this;
    }

    @Override
    public MqttClientOptions setWillMessageBytes(Buffer willMessage) {
        super.setWillMessageBytes(willMessage);
        return this;
    }

    @Override
    public MqttClientSessionOptions setCleanSession(boolean cleanSession) {
        super.setCleanSession(cleanSession);
        return this;
    }

    @Override
    public MqttClientSessionOptions setWillFlag(boolean willFlag) {
        super.setWillFlag(willFlag);
        return this;
    }

    @Override
    public MqttClientSessionOptions setWillQoS(int willQoS) {
        super.setWillQoS(willQoS);
        return this;
    }

    @Override
    public MqttClientSessionOptions setWillRetain(boolean willRetain) {
        super.setWillRetain(willRetain);
        return this;
    }

    @Override
    public MqttClientSessionOptions setKeepAliveInterval(int keepAliveInterval) {
        super.setKeepAliveInterval(keepAliveInterval);
        return this;
    }

    @Override
    public MqttClientSessionOptions setAckTimeout(int ackTimeoutSeconds) {
        super.setAckTimeout(ackTimeoutSeconds);
        return this;
    }

    @Override
    public MqttClientSessionOptions setMaxInflightQueue(int maxInflightQueue) {
        super.setMaxInflightQueue(maxInflightQueue);
        return this;
    }

    @Override
    public MqttClientSessionOptions setAutoKeepAlive(boolean isAutoKeepAlive) {
        super.setAutoKeepAlive(isAutoKeepAlive);
        return this;
    }

    @Override
    public MqttClientSessionOptions setAutoGeneratedClientId(boolean isAutoGeneratedClientId) {
        super.setAutoGeneratedClientId(isAutoGeneratedClientId);
        return this;
    }

    @Override
    public MqttClientSessionOptions setReceiveBufferSize(int receiveBufferSize) {
        super.setReceiveBufferSize(receiveBufferSize);
        return this;
    }

    @Override
    public MqttClientSessionOptions setMaxMessageSize(int maxMessageSize) {
        super.setMaxMessageSize(maxMessageSize);
        return this;
    }

    @Override
    public MqttClientSessionOptions setIdleTimeout(int idleTimeout) {
        super.setIdleTimeout(idleTimeout);
        return this;
    }

    @Override
    public MqttClientSessionOptions setSsl(boolean ssl) {
        super.setSsl(ssl);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTrustStoreOptions(JksOptions options) {
        super.setTrustStoreOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTrustAll(boolean trustAll) {
        super.setTrustAll(trustAll);
        return this;
    }

    @Override
    public MqttClientSessionOptions setKeyCertOptions(KeyCertOptions options) {
        super.setKeyCertOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setKeyStoreOptions(JksOptions options) {
        super.setKeyStoreOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setPfxKeyCertOptions(PfxOptions options) {
        super.setPfxKeyCertOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setPemKeyCertOptions(PemKeyCertOptions options) {
        super.setPemKeyCertOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTrustOptions(TrustOptions options) {
        super.setTrustOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setPemTrustOptions(PemTrustOptions options) {
        super.setPemTrustOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions setPfxTrustOptions(PfxOptions options) {
        super.setPfxTrustOptions(options);
        return this;
    }

    @Override
    public MqttClientSessionOptions addEnabledCipherSuite(String suite) {
        super.addEnabledCipherSuite(suite);
        return this;
    }

    @Override
    public MqttClientSessionOptions addEnabledSecureTransportProtocol(String protocol) {
        super.addEnabledSecureTransportProtocol(protocol);
        return this;
    }

    @Override
    public MqttClientSessionOptions addCrlPath(String crlPath) throws NullPointerException {
        super.addCrlPath(crlPath);
        return this;
    }

    @Override
    public MqttClientSessionOptions addCrlValue(Buffer crlValue) throws NullPointerException {
        super.addCrlValue(crlValue);
        return this;
    }

    @Override
    public MqttClientSessionOptions setSendBufferSize(int sendBufferSize) {
        super.setSendBufferSize(sendBufferSize);
        return this;
    }

    @Override
    public MqttClientSessionOptions setReuseAddress(boolean reuseAddress) {
        super.setReuseAddress(reuseAddress);
        return this;
    }

    @Override
    public MqttClientSessionOptions setReusePort(boolean reusePort) {
        super.setReusePort(reusePort);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTrafficClass(int trafficClass) {
        super.setTrafficClass(trafficClass);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTcpNoDelay(boolean tcpNoDelay) {
        super.setTcpNoDelay(tcpNoDelay);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTcpKeepAlive(boolean tcpKeepAlive) {
        super.setTcpKeepAlive(tcpKeepAlive);
        return this;
    }

    @Override
    public MqttClientSessionOptions setSoLinger(int soLinger) {
        super.setSoLinger(soLinger);
        return this;
    }

    @Override
    public MqttClientSessionOptions setReadIdleTimeout(int idleTimeout) {
        super.setReadIdleTimeout(idleTimeout);
        return this;
    }

    @Override
    public MqttClientSessionOptions setWriteIdleTimeout(int idleTimeout) {
        super.setWriteIdleTimeout(idleTimeout);
        return this;
    }

    @Override
    public MqttClientSessionOptions setIdleTimeoutUnit(TimeUnit idleTimeoutUnit) {
        super.setIdleTimeoutUnit(idleTimeoutUnit);
        return this;
    }

    @Override
    public MqttClientSessionOptions removeEnabledCipherSuite(String suite) {
        super.removeEnabledCipherSuite(suite);
        return this;
    }

    @Override
    public MqttClientSessionOptions removeEnabledSecureTransportProtocol(String protocol) {
        super.removeEnabledSecureTransportProtocol(protocol);
        return this;
    }

    @Override
    public MqttClientSessionOptions setUseAlpn(boolean useAlpn) {
        super.setUseAlpn(useAlpn);
        return this;
    }

    @Override
    public MqttClientSessionOptions setSslEngineOptions(SSLEngineOptions sslEngineOptions) {
        super.setSslEngineOptions(sslEngineOptions);
        return this;
    }

    @Override
    public MqttClientSessionOptions setJdkSslEngineOptions(JdkSSLEngineOptions sslEngineOptions) {
        super.setJdkSslEngineOptions(sslEngineOptions);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTcpFastOpen(boolean tcpFastOpen) {
        super.setTcpFastOpen(tcpFastOpen);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTcpCork(boolean tcpCork) {
        super.setTcpCork(tcpCork);
        return this;
    }

    @Override
    public MqttClientSessionOptions setTcpQuickAck(boolean tcpQuickAck) {
        super.setTcpQuickAck(tcpQuickAck);
        return this;
    }

    @Override
    public ClientOptionsBase setOpenSslEngineOptions(OpenSSLEngineOptions sslEngineOptions) {
        super.setOpenSslEngineOptions(sslEngineOptions);
        return this;
    }

    @Override
    public MqttClientSessionOptions setConnectTimeout(int connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public MqttClientSessionOptions setMetricsName(String metricsName) {
        super.setMetricsName(metricsName);
        return this;
    }

    @Override
    public MqttClientSessionOptions setReconnectAttempts(int attempts) {
        super.setReconnectAttempts(attempts);
        return this;
    }

    @Override
    public MqttClientSessionOptions setReconnectInterval(long interval) {
        super.setReconnectInterval(interval);
        return this;
    }

    @Override
    public MqttClientSessionOptions setHostnameVerificationAlgorithm(String hostnameVerificationAlgorithm) {
        super.setHostnameVerificationAlgorithm(hostnameVerificationAlgorithm);
        return this;
    }

    @Override
    public MqttClientSessionOptions setApplicationLayerProtocols(List<String> protocols) {
        super.setApplicationLayerProtocols(protocols);
        return this;
    }

    @Override
    public MqttClientSessionOptions setLogActivity(boolean logEnabled) {
        super.setLogActivity(logEnabled);
        return this;
    }

    @Override
    public MqttClientSessionOptions setActivityLogDataFormat(ByteBufFormat activityLogDataFormat) {
        super.setActivityLogDataFormat(activityLogDataFormat);
        return this;
    }

    @Override
    public MqttClientSessionOptions setProxyOptions(ProxyOptions proxyOptions) {
        super.setProxyOptions(proxyOptions);
        return this;
    }

    @Override
    public MqttClientSessionOptions setNonProxyHosts(List<String> nonProxyHosts) {
        super.setNonProxyHosts(nonProxyHosts);
        return this;
    }

    @Override
    public MqttClientSessionOptions addNonProxyHost(String nonProxyHost) {
        super.addNonProxyHost(nonProxyHost);
        return this;
    }

    @Override
    public MqttClientSessionOptions setLocalAddress(String localAddress) {
        super.setLocalAddress(localAddress);
        return this;
    }

    @Override
    public MqttClientSessionOptions setEnabledSecureTransportProtocols(Set<String> enabledSecureTransportProtocols) {
        super.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols);
        return this;
    }

    @Override
    public MqttClientSessionOptions setSslHandshakeTimeout(long sslHandshakeTimeout) {
        super.setSslHandshakeTimeout(sslHandshakeTimeout);
        return this;
    }

    @Override
    public MqttClientSessionOptions setSslHandshakeTimeoutUnit(TimeUnit sslHandshakeTimeoutUnit) {
        super.setSslHandshakeTimeoutUnit(sslHandshakeTimeoutUnit);
        return this;
    }

    @Override
    public ClientOptionsBase setTcpUserTimeout(int tcpUserTimeout) {
        super.setTcpUserTimeout(tcpUserTimeout);
        return this;
    }
}
