public class Main {
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender();
        
        System.out.println("--- Bildirimler Gönderiliyor ---");
        
        sender.sendNotification("EMAIL", "Siparişiniz kargoya verildi!", "kullanici@example.com");
        System.out.println();
        
        sender.sendNotification("SMS", "Doğrulama kodunuz: 123456", "+905551234567");
        System.out.println();
        
        sender.sendNotification("PUSH", "Yeni bir mesajınız var.", "device_token_abc123");
        System.out.println();
    }
}
