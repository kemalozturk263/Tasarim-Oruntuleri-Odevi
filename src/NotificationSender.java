public class NotificationSender {
    public void sendNotification(String type, String message, String recipient) {
        if (type.equals("EMAIL")) {
            System.out.println("SMTP sunucusuna bağlanılıyor (mail.example.com)...");
            System.out.println("Mesaj HTML formatına çevriliyor...");
            System.out.println("EMAIL gönderiliyor -> Alıcı: " + recipient + " | Mesaj: " + message);
        } else if (type.equals("SMS")) {
            if (message.length() > 160) {
                System.out.println("Uyarı: SMS 160 karakterden uzun, kırpılıyor...");
                message = message.substring(0, 160);
            }
            System.out.println("Twilio/SMS Gateway API'sine bağlanılıyor...");
            System.out.println("SMS gönderiliyor -> Alıcı: " + recipient + " | Mesaj: " + message);
        } else if (type.equals("PUSH")) {
            System.out.println("Firebase Cloud Messaging (FCM) servisi ile kimlik doğrulaması yapılıyor...");
            System.out.println("PUSH bildirimi gönderiliyor -> Cihaz ID: " + recipient + " | Mesaj: " + message);
        } else {
            System.out.println("Hata: Bilinmeyen bildirim tipi!");
        }
    }
}
