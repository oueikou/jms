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
	private Destination destination;
	
	@Test
	public void testSendMsg(){
		for(int i=0; i<10; i++){
			jmsService.sendMessage(destination, "我是消息"+i);
		}
	}
	
}
