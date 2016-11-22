package com.jms.activemq.service;

import javax.jms.Destination;

public interface JmsService {
	public void sendMessage(Destination destination, final String message);
}
