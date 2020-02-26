package guru.springframework.sfgjms.listener;

import guru.springframework.sfgjms.config.JmsConfig;
import guru.springframework.sfgjms.model.MyMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listener(@Payload MyMessage myMessage, @Headers MessageHeaders headers, Message message) {

        System.out.println(myMessage.getMessageText() + " received");
    }
}
