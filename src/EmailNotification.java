public class EmailNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        System.out.println("SMTP sunucusuna bağlanılıyor (mail.example.com)...");
        System.out.println("Mesaj HTML formatına çevriliyor...");
        System.out.println("EMAIL gönderiliyor -> Alıcı: " + recipient + " | Mesaj: " + message);
    }
}
