package com.jms.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.Message;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<Message>{

	public void onMessage(Message message, Session session) throws JMSException {
		TextMessage textMsg = (TextMessage) message;
		System.out.println("消息内容是：" + textMsg.getText());
	}

}
