public class Main {
    public static void main(String[] args) {
        NotificationFacade facade = new NotificationFacade();
        
        System.out.println("--- Facade ve Decorator Örüntüleri ile Bildirimler Gönderiliyor ---");
        
        System.out.println("\n1. Standart E-posta:");
        facade.sendStandardEmail("Siparişiniz kargoya verildi!", "kullanici@example.com");
        
        System.out.println("\n2. Şifrelenmiş SMS:");
        facade.sendSecureSms("Doğrulama kodunuz: 123456", "+905551234567");
        
        System.out.println("\n3. Loglanan ve Şifrelenen Push Bildirimi:");
        facade.sendLoggedAndSecurePush("Yeni bir mesajınız var.", "device_token_abc123");
    }
}
