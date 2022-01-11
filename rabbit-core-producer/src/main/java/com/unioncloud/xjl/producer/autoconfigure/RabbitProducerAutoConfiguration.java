package com.unioncloud.xjl.producer.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.unioncloud.xjl.task.annotation.EnableElasticJob;

/**
 * 	$RabbitProducerAutoConfiguration 自动装配 
 * @author xjl
 *
 */
@EnableElasticJob
@Configuration
@ComponentScan({"com.unioncloud.xjl.producer.*"})
public class RabbitProducerAutoConfiguration {


}
