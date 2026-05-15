public class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Bildirim tipi boş olamaz!");
        }
        
        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SmsNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Hata: Bilinmeyen bildirim tipi: " + type);
        }
    }
}
