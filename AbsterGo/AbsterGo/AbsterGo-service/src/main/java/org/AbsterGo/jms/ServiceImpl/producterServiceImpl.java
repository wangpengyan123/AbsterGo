package org.AbsterGo.jms.ServiceImpl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.AbsterGo.jms.Service.producterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class producterServiceImpl implements producterService{

	public JmsTemplate getJms() {
		return jms;
	}
	public void setJms(JmsTemplate jms) {
		this.jms = jms;
	}
	private JmsTemplate jms;
	@Override
	public void sendMessage(Destination destination,final String message) {
		// TODO Auto-generated method stub
		System.out.println("---------------生产者发送消息-----------------");   
        System.out.println("---------------生产者发了一个消息：" + message);
        System.out.println(jms);   
        jms.send(destination, new MessageCreator() {   
            public Message createMessage(Session session) throws JMSException {   
                return session.createTextMessage(message);   
            }   
        });   
	}
}
