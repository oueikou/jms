package com.jms.activemq.listener;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.Message;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<Message>{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(ConsumerSessionAwareMessageListener.class);

	public void onMessage(Message message, Session session) throws JMSException {
		if (logger.isDebugEnabled()) {
			logger.debug("onMessage(Message, Session) - start");
		}

		if (message instanceof TextMessage) {
			TextMessage textMsg = (TextMessage) message;
			logger.info("消息内容是：" + textMsg.getText());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("onMessage(Message, Session) - end");
		}
	}

}
