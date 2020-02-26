package guru.springframework.sfgjms.sender;

import guru.springframework.sfgjms.config.JmsConfig;
import guru.springframework.sfgjms.model.MyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MyMessageSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 3000) //will be generated every 3 seconds
    public  void sendMessage() {
        LocalTime time = LocalTime.now();
        String msg = "msg time - " + time.getSecond();
        MyMessage myMessage = MyMessage.builder()
                .id(UUID.randomUUID())
                .messageText(msg)
                .build();

        System.out.println("sending " + msg);

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, myMessage);
    }
}
