public class PushNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Firebase Cloud Messaging (FCM) servisi ile kimlik doğrulaması yapılıyor...");
        System.out.println("PUSH bildirimi gönderiliyor -> Cihaz ID: " + recipient + " | Mesaj: " + message);
    }
}
