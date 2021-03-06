package com.unioncloud.xjl.common.convert;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import com.google.common.base.Preconditions;

/**
 * 	$RabbitMessageConverter
 * @author xjl
 *
 */
public class RabbitMessageConverter implements MessageConverter {

	private GenericMessageConverter delegate;
	
//	private final String delaultExprie = String.valueOf(24 * 60 * 60 * 1000);
	
	public RabbitMessageConverter(GenericMessageConverter genericMessageConverter) {
		Preconditions.checkNotNull(genericMessageConverter);
		this.delegate = genericMessageConverter;
	}
	
	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
//		messageProperties.setExpiration(delaultExprie);
		com.unioncloud.xjl.api.Message message = (com.unioncloud.xjl.api.Message)object;
		messageProperties.setDelay(message.getDelayMills());
		return this.delegate.toMessage(object, messageProperties);
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		com.unioncloud.xjl.api.Message msg = (com.unioncloud.xjl.api.Message) this.delegate.fromMessage(message);
		return msg;
	}

}
