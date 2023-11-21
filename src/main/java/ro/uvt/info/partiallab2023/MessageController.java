package ro.uvt.info.partiallab2023;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MessageController {

    public void processMessages() throws IOException {
        List<Message> messages = readMessagesFromFile();

        for (Message message : messages) {
            String decodedMessage = message.decodeMessage();
            System.out.println(decodedMessage);
        }
    }

    private List<Message> readMessagesFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // For handling Date/Time types
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL fileUrl = new URL("file:src/messages.json");
        return objectMapper.readValue(fileUrl, new TypeReference<List<Message>>() {});
    }
}

