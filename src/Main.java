public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        
        System.out.println("--- Factory Pattern ile Bildirimler Gönderiliyor ---");
        
        Notification email = factory.createNotification("EMAIL");
        email.send("Siparişiniz kargoya verildi!", "kullanici@example.com");
        System.out.println();
        
        Notification sms = factory.createNotification("SMS");
        sms.send("Doğrulama kodunuz: 123456", "+905551234567");
        System.out.println();
        
        Notification push = factory.createNotification("PUSH");
        push.send("Yeni bir mesajınız var.", "device_token_abc123");
        System.out.println();
    }
}
