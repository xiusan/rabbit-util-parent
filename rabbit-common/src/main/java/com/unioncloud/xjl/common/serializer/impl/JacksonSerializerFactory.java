package com.unioncloud.xjl.common.serializer.impl;

import com.unioncloud.xjl.api.Message;
import com.unioncloud.xjl.common.serializer.Serializer;
import com.unioncloud.xjl.common.serializer.SerializerFactory;

public class JacksonSerializerFactory implements SerializerFactory{

	public static final SerializerFactory INSTANCE = new JacksonSerializerFactory();
	
	@Override
	public Serializer create() {
		return JacksonSerializer.createParametricType(Message.class);
	}

}
