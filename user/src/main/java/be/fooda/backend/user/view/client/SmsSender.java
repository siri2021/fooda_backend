package be.fooda.backend.user.view.client;

// Install the Java helper library from twilio.com/docs/libraries/java

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACa1ad857f793f2a4e54f575a869f5ad98";
    public static final String AUTH_TOKEN =
            "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+14159352345"), // to
                        new PhoneNumber("+14158141829"), // from
                        "Where's Wallace?")
                .create();

        System.out.println(message.getSid());
    }
}
