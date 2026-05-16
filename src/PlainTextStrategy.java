public class PlainTextStrategy implements MessageFormatStrategy {
    @Override
    public String format(String message) {
        return message; // Düz metin, herhangi bir formatlama yok
    }
}
