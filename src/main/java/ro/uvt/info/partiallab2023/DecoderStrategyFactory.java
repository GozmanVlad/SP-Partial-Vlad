package ro.uvt.info.partiallab2023;

// Factory Pattern
public class DecoderStrategyFactory {
    public static DecoderStrategy getDecoderStrategy(String house) {
        if ("Atreides".equals(house)) {
            return new AtreidesDecoder();
        } else if ("Harkonnen".equals(house)) {
            return new HarkonnenDecoder();
        }
        throw new IllegalArgumentException("Invalid house: " + house);
    }
}
