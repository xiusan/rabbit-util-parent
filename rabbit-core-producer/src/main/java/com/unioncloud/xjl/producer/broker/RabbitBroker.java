package com.unioncloud.xjl.producer.broker;

import com.unioncloud.xjl.api.Message;

/**
 * 	$RabbitBroker 具体发送不同种类型消息的接口
 * @author xjl
 *
 */
public interface RabbitBroker {
	
	void rapidSend(Message message);
	
	void confirmSend(Message message);
	
	void reliantSend(Message message);
	
	void sendMessages();
	
}
