package ro.uvt.info.partiallab2023;

public class HarkonnenDecoder implements DecoderStrategy {
    @Override
    public String decode(String encodedMessage) {
        StringBuilder decodededMessage = new StringBuilder();
        for (int i = 0; i < encodedMessage.length(); i++)
            decodededMessage.append((char) (encodedMessage.charAt(i) - 2));
        return "Mesaj din partea casei Harkonnen: " + decodededMessage;
    }
}
