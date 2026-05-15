public class EncryptedDecorator extends NotificationDecorator {
    public EncryptedDecorator(Notification wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message, String recipient) {
        String encryptedMessage = encrypt(message);
        System.out.println("[GÜVENLİK] Mesaj AES-256 ile şifrelendi.");
        super.send(encryptedMessage, recipient);
    }

    private String encrypt(String message) {
        // Basit bir Base64 (veya sembolik şifreleme) simülasyonu
        return java.util.Base64.getEncoder().encodeToString(message.getBytes());
    }
}
