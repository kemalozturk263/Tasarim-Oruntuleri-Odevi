# UML Sınıf Diyagramı - Faz 3 (Strategy & Observer Uygulaması - Final Mimari)

```mermaid
classDiagram
    class SystemPublisher {
        -List~Subscriber~ subscribers
        -MessageFormatStrategy formatStrategy
        +subscribe(Subscriber)
        +unsubscribe(Subscriber)
        +setFormatStrategy(MessageFormatStrategy)
        +notifySubscribers(String event, String message)
    }

    class Subscriber {
        <<interface>>
        +update(String event, String message)
    }

    class UserSubscriber {
        -String username
        -String email
        -NotificationFacade facade
        +update(String event, String message)
    }

    class MessageFormatStrategy {
        <<interface>>
        +format(String message) String
    }

    class PlainTextStrategy {
        +format(String message) String
    }

    class HtmlStrategy {
        +format(String message) String
    }

    class NotificationFacade {
        -NotificationFactory factory
        +sendStandardEmail()
        +sendSecureSms()
        +sendLoggedAndSecurePush()
    }

    class NotificationFactory {
        +createNotification(String type) Notification
    }

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

    SystemPublisher o-- Subscriber
    SystemPublisher o-- MessageFormatStrategy
    Subscriber <|.. UserSubscriber
    MessageFormatStrategy <|.. PlainTextStrategy
    MessageFormatStrategy <|.. HtmlStrategy
    UserSubscriber --> NotificationFacade
    NotificationFacade --> NotificationFactory
    NotificationFactory --> Notification : creates
    Notification <|.. EmailNotification
    Notification <|.. SmsNotification
    Notification <|.. PushNotification
    Notification <|.. NotificationDecorator
    NotificationDecorator o-- Notification : wraps
    NotificationDecorator <|-- LoggingDecorator
    NotificationDecorator <|-- EncryptedDecorator
```

## Açıklama
Strategy örüntüsü ile mesaj formatlama algoritması çalışma zamanında değiştirilebilir hale geldi. Observer örüntüsü ile olay tabanlı bildirim dağıtımı kuruldu. Yeni davranış eklemek için mevcut kodu değiştirmeye gerek kalmadı (OCP).
