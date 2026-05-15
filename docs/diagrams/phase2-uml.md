# UML Sınıf Diyagramı - Faz 2 (Decorator & Facade Uygulaması)

```mermaid
classDiagram
    class Notification {
        <<interface>>
        +send(String message, String recipient)
    }

    class EmailNotification {
        +send()
    }

    class SmsNotification {
        +send()
    }

    class PushNotification {
        +send()
    }

    class NotificationDecorator {
        <<abstract>>
        #Notification wrappee
        +send()
    }

    class LoggingDecorator {
        +send()
    }

    class EncryptedDecorator {
        +send()
        -encrypt(String message) String
    }

    class NotificationFactory {
        +createNotification(String type) Notification
    }

    class NotificationFacade {
        -NotificationFactory factory
        +sendStandardEmail()
        +sendSecureSms()
        +sendLoggedAndSecurePush()
    }

    Notification <|.. EmailNotification
    Notification <|.. SmsNotification
    Notification <|.. PushNotification
    Notification <|.. NotificationDecorator
    NotificationDecorator <|-- LoggingDecorator
    NotificationDecorator <|-- EncryptedDecorator
    NotificationDecorator o-- Notification : wraps
    NotificationFacade --> NotificationFactory
    NotificationFactory --> Notification : creates
```

## Açıklama
Decorator örüntüsü ile mevcut bildirim sınıflarını değiştirmeden loglama ve şifreleme özellikleri eklendi. Facade örüntüsü ile karmaşık alt sistem basit metotların arkasına gizlendi.
