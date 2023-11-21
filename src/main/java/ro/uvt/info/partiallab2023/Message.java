package ro.uvt.info.partiallab2023;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import java.util.Date;

// Composite Pattern
@Getter
public class Message {
    @JsonProperty("date")
    @JsonSetter
    private Date date;
    @JsonProperty("message")
    @JsonSetter
    private String message;

    @JsonProperty("house")
    @JsonSetter()
    private String house;

    private DecoderStrategy getDecoderStrategy() {
        return switch (house) {
            case "atreides" -> new AtreidesDecoder();
            case "harkonnen" -> new HarkonnenDecoder();
            default -> throw new IllegalArgumentException("Invalid house: " + house);
        };
    }

    String decodeMessage() {
        DecoderStrategy decoderStrategy = getDecoderStrategy();
        return decoderStrategy.decode(message);
    }
}
