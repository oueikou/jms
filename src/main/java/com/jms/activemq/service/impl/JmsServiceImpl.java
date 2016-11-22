package com.jms.activemq.service.impl;

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

	@Resource
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(Destination destination, final String message) {
		System.out.println("开始发送消息");
		jmsTemplate.send(destination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}

}
