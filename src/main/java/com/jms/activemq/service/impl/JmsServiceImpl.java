package com.jms.activemq.service.impl;

import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.jms.activemq.service.JmsService;

@Service
public class JmsServiceImpl implements JmsService{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(JmsServiceImpl.class);

	@Resource
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(Destination destination, final String message) {
		logger.info("开始发送消息，消息内容："+message);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message returnMessage = session.createTextMessage(message);
				return returnMessage;
			}
		});
	}

}
