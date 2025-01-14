package com.ziqni.jenkins.plugins.rabbit.consumer.listeners;

import com.ziqni.jenkins.plugins.rabbit.consumer.channels.AbstractRMQChannel;

/**
 * Listener interface for RabbitMQ Channel.
 *
 * @author rinrinne a.k.a. rin_ne
 */
public interface RMQChannelListener {
    /**
     * Calls when close process for channel is completed.
     *
     * @param rmqChannel
     *            the closed channel.
     */
    void onCloseCompleted(AbstractRMQChannel rmqChannel);

    /**
     * Calls when channel is opend.
     *
     * @param rmqChannel
     *            the channel.
     */
    void onOpen(AbstractRMQChannel rmqChannel);
}
