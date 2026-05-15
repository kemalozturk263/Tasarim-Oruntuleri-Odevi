# UML Sınıf Diyagramı - Faz 1 (Factory Method Uygulaması)

## Öncesi
```mermaid
classDiagram
    class NotificationSender {
        +sendNotification(String type, String message, String recipient)
    }
    Main --> NotificationSender
```

## Sonrası
```mermaid
classDiagram
    class Notification {
        <<interface>>
        +send(String message, String recipient)
    }

    class EmailNotification {
        +send(String message, String recipient)
    }

    class SmsNotification {
        +send(String message, String recipient)
    }

    class PushNotification {
        +send(String message, String recipient)
    }

    class NotificationFactory {
        +createNotification(String type) Notification
    }

    class Main {
        +main(String[] args)
    }

    Notification <|.. EmailNotification
    Notification <|.. SmsNotification
    Notification <|.. PushNotification
    NotificationFactory --> Notification : creates
    Main --> NotificationFactory : uses
```

## Açıklama
God Class olan `NotificationSender` kaldırıldı. Yerine `Notification` arayüzü ve her bildirim tipi için ayrı sınıflar oluşturuldu. `NotificationFactory` nesne yaratımını merkezi hale getirdi.
