public class LoggingDecorator extends NotificationDecorator {
    public LoggingDecorator(Notification wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message, String recipient) {
        System.out.println("[LOG] Bildirim gönderim işlemi başlatıldı. Alıcı: " + recipient);
        super.send(message, recipient);
        System.out.println("[LOG] Bildirim başarıyla gönderildi ve sisteme kaydedildi.");
    }
}
