public class HtmlStrategy implements MessageFormatStrategy {
    @Override
    public String format(String message) {
        return "<html><body><h2>Bildirim</h2><p>" + message + "</p></body></html>";
    }
}
