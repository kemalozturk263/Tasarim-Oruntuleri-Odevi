public class SmsNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        if (message.length() > 160) {
            System.out.println("Uyarı: SMS 160 karakterden uzun, kırpılıyor...");
            message = message.substring(0, 160);
        }
        System.out.println("Twilio/SMS Gateway API'sine bağlanılıyor...");
        System.out.println("SMS gönderiliyor -> Alıcı: " + recipient + " | Mesaj: " + message);
    }
}
