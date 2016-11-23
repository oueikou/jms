package jms_l;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jms.activemq.service.JmsService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("/applicationContext.xml")
public class JsmTest {
	@Autowired
	private JmsService jmsService;
	@Autowired
	@Qualifier("queueDestination")
	private Destination queueDestination;
	@Autowired
	@Qualifier("topicDestination")
	private Destination topicDestination;
	
	@Test
	public void testSendQueueMsg(){
		for(int i=0; i<10; i++){
			jmsService.sendMessage(queueDestination, "我是queue消息"+i);
		}
	}
	
	@Test
	public void testSendTopicMsg(){
		for(int i=0; i<10; i++){
			jmsService.sendMessage(topicDestination, "我是topic消息"+i);
		}
	}
	
}
