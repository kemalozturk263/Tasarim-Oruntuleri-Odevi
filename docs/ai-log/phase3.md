# Yapay Zeka Eşliğinde Programlama Günlüğü - Faz 3

## AI ile Pair Programming Süreci Özeti
Bu faz için AI ile genişletilebilirlik üzerine çalıştık. İlk hedefimiz, bildirim formatını çalışma zamanında değiştirebilmek ve bir olay (event) olduğunda ilgili kullanıcılara otomatik mesaj atabilmekti.

- **Tartışma:** AI'a "Sisteme Observer ve Strategy örüntülerini ekleyerek nasıl tam Open/Closed (OCP) uyumlu hale getirebilirim?" diye sordum.
- **Karar:** 
  1. `MessageFormatStrategy` arayüzü ile Strategy örüntüsünü kurmaya karar verdik. Mesajların formatlanması (Plain text veya HTML) artık çalışma zamanında değiştirilebiliyor.
  2. `SystemPublisher` (Event Publisher) ve `UserSubscriber` (Observer) sınıflarını kurduk. Bir "Sipariş Kargolandı" olayı olduğunda, publisher sadece abonelere (subscribers) bu mesajı iletiyor. Yeni bir abone tipi eklemek istersek mevcut kodu hiç değiştirmiyoruz.

## Refleksiyon (AI olmadan bu faz ne kadar sürerdi? AI sizi nerede yanılttı?)
* **Süre:** AI olmadan Observer ve Strategy örüntülerinin arasındaki veri akışını doğru kurmak, birbirine bağlamak (özellikle Facade ile entegre etmek) en az 3-4 saatimi alabilirdi. AI, bağlamı çok iyi kurduğu için süreci oldukça hızlandırdı (sadece 30-40 dakikaya düşürdü).
* **AI'ın Yanılttığı Yerler:** AI başlarda `SystemPublisher` içerisine direkt `EmailNotification` nesnesini bağlamayı önerdi. Ancak bu önceki fazlarda kurduğumuz `NotificationFacade` yapısını bypass etmek demekti (mimari bütünlüğü bozuyordu). AI'ı uyararak `UserSubscriber` içerisine doğrudan `Facade` nesnesini enjekte etmesini sağladım. Bu sayede hem Observer çalıştı hem de önceki fazdaki Facade mimarimiz korundu.
