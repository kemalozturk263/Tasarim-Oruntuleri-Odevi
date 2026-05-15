# Yapay Zeka Eşliğinde Programlama Günlüğü - Faz 1

## Prompt (AI'a ne sordum?)
*"Nesne yaratma sorumluluğunu merkezi ve esnek bir yapıya taşımak için Creational örüntü uygulamamız gerekiyor. NotificationSender sınıfındaki new ve if-else yapılarından kurtulmak için ne önerirsin? Factory Method veya Builder'dan hangisi daha uygun olur?"*

## AI'ın Yanıtı Özeti
AI, **Factory Method** (Fabrika Metodu) tasarım örüntüsünün bu durum için daha uygun olduğunu belirtti. Çünkü nesnelerimizin (Email, SMS, Push) yapısı basit; adım adım karmaşık bir inşa süreci gerektirmiyor (bu yüzden Builder gereksiz karmaşıklık yaratırdı). Ancak her birinin yaratım sürecini ve implementasyonunu birbirinden ayırmamız gerekiyordu.

AI'ın önerdiği temel adımlar şunlardı:
1. `Notification` adında bir interface (arayüz) oluşturulması.
2. `EmailNotification`, `SmsNotification` gibi sınıfların bu interface'i implemente etmesi.
3. `NotificationFactory` sınıfının oluşturulup `createNotification(String type)` metodu ile nesne yaratımından sorumlu hale getirilmesi.

## Benim Uygulamam
AI'ın önerisini kabul ettim ve kodu tamamen bu mantığa göre yeniden yazdım. 
- Eskiden olan "God Class" (`NotificationSender`) tamamen silindi. 
- Onun yerine Factory sınıfını ve implementasyon sınıflarını ekledik.
- `Main` sınıfını `NotificationFactory`'yi kullanacak şekilde güncelledik.

AI'ın önerisinden tek farkımız, Exception mekanizmasını biraz daha detaylı yazarak geçersiz bir bildirim tipi (type) girildiğinde sistemin `IllegalArgumentException` fırlatmasını sağlamak oldu.
