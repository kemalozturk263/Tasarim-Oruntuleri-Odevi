# UML Sınıf Diyagramı - Faz 0 (Başlangıç - Kötü Tasarım)

```mermaid
classDiagram
    class NotificationSender {
        +sendNotification(String type, String message, String recipient)
    }

    class Main {
        +main(String[] args)
    }

    Main --> NotificationSender : uses
```

## Açıklama
Başlangıç tasarımında tek bir sınıf (`NotificationSender`) tüm bildirim tiplerinin (Email, SMS, Push) gönderim mantığını if-else zincirleriyle içinde barındırıyor. Bu sınıf bir **God Class** anti-pattern'idir.
