package com.example.project101.Service;
import com.example.project101.model.SMS;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.net.URI;

@Component
public class SMSService {

    @Value("#{systemEnvironment['AC7ee2204724e1b8ea2ad3d15e84be9b14']}")
    private String ACCOUNT_SID="AC7ee2204724e1b8ea2ad3d15e84be9b14";

    @Value("#{systemEnvironment['254325f075d02a41f1579ec0423ee3dd']}")
    private String AUTH_TOKEN="254325f075d02a41f1579ec0423ee3dd";

    @Value("#{systemEnvironment['+17726004502']}")
    private String FROM_NUMBER="+17726004502";

    public void send(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}