public class NotificationFacade {
    private NotificationFactory factory;

    public NotificationFacade() {
        this.factory = new NotificationFactory();
    }

    public void sendStandardEmail(String message, String recipient) {
        Notification email = factory.createNotification("EMAIL");
        email.send(message, recipient);
    }

    public void sendSecureSms(String message, String recipient) {
        Notification sms = factory.createNotification("SMS");
        Notification secureSms = new EncryptedDecorator(sms);
        secureSms.send(message, recipient);
    }

    public void sendLoggedAndSecurePush(String message, String recipient) {
        Notification push = factory.createNotification("PUSH");
        // Önce şifreliyoruz, sonra logluyoruz (Sarmalama işlemi)
        Notification securePush = new EncryptedDecorator(push);
        Notification loggedSecurePush = new LoggingDecorator(securePush);
        loggedSecurePush.send(message, recipient);
    }
}
