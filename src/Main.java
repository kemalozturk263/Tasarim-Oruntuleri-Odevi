public class Main {
    public static void main(String[] args) {
        NotificationFacade facade = new NotificationFacade();
        
        System.out.println("--- Gözlemci (Observer) ve Strateji (Strategy) Örüntüleri ---");
        
        // Stratejiyi belirliyoruz (Önce Düz Metin)
        SystemPublisher publisher = new SystemPublisher(new PlainTextStrategy());
        
        // Aboneleri (Gözlemcileri) oluşturup sisteme kaydediyoruz
        UserSubscriber user1 = new UserSubscriber("Ahmet", "ahmet@example.com", facade);
        UserSubscriber user2 = new UserSubscriber("Ayşe", "ayse@example.com", facade);
        
        publisher.subscribe(user1);
        publisher.subscribe(user2);
        
        System.out.println("\n[SİSTEM] 'Sipariş Kargolandı' olayı tetikleniyor (Düz Metin):");
        publisher.notifySubscribers("Sipariş Kargolandı", "Siparişiniz yola çıkmıştır. Takip no: 12345");
        
        System.out.println("\n[SİSTEM] Strateji HTML olarak değiştiriliyor...");
        // Çalışma zamanında algoritmayı (Stratejiyi) değiştiriyoruz
        publisher.setFormatStrategy(new HtmlStrategy());
        
        System.out.println("\n[SİSTEM] 'Kampanya' olayı tetikleniyor (HTML Metin):");
        publisher.notifySubscribers("Yeni Kampanya", "Tüm ürünlerde %50 indirim fırsatını kaçırmayın!");
    }
}
