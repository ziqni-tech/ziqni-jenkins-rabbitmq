package com.ziqni.jenkins.plugins.rabbit.consumer.logger;

import hudson.Extension;
import com.ziqni.jenkins.plugins.rabbit.consumer.RabbitMqConsumeItem;
import com.ziqni.jenkins.plugins.rabbit.consumer.extensions.MessageQueueListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Extension for logging messages. This is debug purpose.
 *
 * @author rinrinne a.k.a. rin_ne
 */
@Extension
public class MessageLogger extends MessageQueueListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageLogger.class);
    private static final String PLUGIN_NAME = "Message Logger for debug";

    /**
     * {@inheritDoc}
     *
     * @return the name.
     */
    public String getName() {
        return PLUGIN_NAME;
    }

    /**
     * {@inheritDoc}
     *
     * @return the application id.
     */
    public String getAppId() {
        return RabbitMqConsumeItem.DEBUG_APPID;
    }

    /**
     * {@inheritDoc}
     *
     * @param queueName
     *            the queue name that bind to.
     */
    public void onBind(String queueName) {
        LOGGER.info("Bind to " + queueName);
    }

    /**
     * {@inheritDoc}
     *
     * @param queueName
     *            the queue name that unbind from.
     */
    public void onUnbind(String queueName) {
        LOGGER.info("Unbind from " + queueName);
    }

    /**
     * {@inheritDoc}
     *
     * @param queueName
     *            the queue name that receive from.
     * @param contentType
     *            the type of content.
     * @param headers
     *            the map of message headers.
     * @param body
     *            the content body.
     */
    public void onReceive(String queueName, String contentType, Map<String, Object> headers, byte[] body) {
        String msg;
        try {
            msg = new String(body, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            msg = "<Unsupported Encoding>";
        }
        LOGGER.info("Receive: ({}) {}", contentType, msg);
    }
}