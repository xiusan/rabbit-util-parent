package com.unioncloud.xjl.producer.broker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unioncloud.xjl.api.Message;
import com.unioncloud.xjl.api.MessageProducer;
import com.unioncloud.xjl.api.MessageType;
import com.unioncloud.xjl.api.SendCallback;
import com.unioncloud.xjl.api.exception.MessageRunTimeException;
import com.google.common.base.Preconditions;

/**
 * 	$ProducerClient 发送消息的实际实现类
 * @author xjl
 *
 */
@Component
public class ProducerClient implements MessageProducer {

	@Autowired
	private RabbitBroker rabbitBroker;
	
	@Override
	public void send(Message message) throws MessageRunTimeException {
		Preconditions.checkNotNull(message.getTopic());
		String messageType = message.getMessageType();
		switch (messageType) {
			case MessageType.RAPID:
				rabbitBroker.rapidSend(message);
				break;
			case MessageType.CONFIRM:
				rabbitBroker.confirmSend(message);
				break;
			case MessageType.RELIANT:
				rabbitBroker.reliantSend(message);
				break;
		default:
			break;
		}
	}

	/**
	 * 	$send Messagetype
	 */
	@Override
	public void send(List<Message> messages) throws MessageRunTimeException {
		messages.forEach( message -> {
			message.setMessageType(MessageType.RAPID);
			MessageHolder.add(message);
		});
		rabbitBroker.sendMessages();
	}
	
	@Override
	public void send(Message message, SendCallback sendCallback) throws MessageRunTimeException {
		// TODO Auto-generated method stub
		
	}

}
