package org.AbsterGo.jms.Service;

import javax.jms.Destination;

public interface producterService {
   void sendMessage(Destination destination,final String message); 
}
