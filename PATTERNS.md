# Tasarım Örüntüleri Dokümantasyonu

## Faz 1: Creational (Yaratımsal) Örüntüler

### 1. Factory Method (Fabrika Metodu)
* **Kullanıldığı Yer:** `NotificationFactory` sınıfı ve `Main` içindeki nesne yaratım süreçleri.
* **Hangi Sorunu Çözdü?** Önceden `NotificationSender` (God Class) içindeki devasa `if-else` yapısını ortadan kaldırdık. Hangi tipte bir bildirim nesnesi oluşturulacağına istemcinin (`Main.java`) karar vermesini sağladık, ancak yaratım mantığını gizledik.
* **Ne Kazandırdı?** Single Responsibility Principle (SRP) sağlandı. Artık her bildirim tipinin kendi sınıfı var (`EmailNotification`, `SmsNotification` vb.). İleride yeni bir bildirim tipi (örneğin Slack) eklemek istediğimizde, sadece `Notification` arayüzünden türeyen yeni bir sınıf yazıp, Factory sınıfına küçük bir ekleme yapacağız. Mevcut sınıfların kodlarına dokunmamış olacağız (kısmen OCP'ye de hazırlık yapmış olduk).

## Faz 2: Structural (Yapısal) Örüntüler

### 2. Decorator (Dekoratör)
* **Kullanıldığı Yer:** `NotificationDecorator` soyut sınıfı ile `LoggingDecorator` ve `EncryptedDecorator` sınıfları.
* **Hangi Sorunu Çözdü?** Mevcut bildirim sınıflarını (SMS, Email) hiç değiştirmeden (Open/Closed Principle uyumlu), onlara çalışma zamanında yeni özellikler (loglama, şifreleme) kazandırdık. Eğer if-else veya kalıtım kullansaydık `EncryptedAndLoggedSmsNotification` gibi saçma sınıflar türetmek zorunda kalacaktık.
* **Ne Kazandırdı?** Sınıf patlamasını (class explosion) engelledi. İstemci istediği özellikleri (şifreleme, loglama) bir Lego gibi üst üste ekleyebilir duruma geldi.

### 3. Facade (Cephe)
* **Kullanıldığı Yer:** `NotificationFacade` sınıfı.
* **Hangi Sorunu Çözdü?** Factory ve Decorator örüntülerini ekledikten sonra istemcinin (`Main`) bu nesneleri oluşturması ve sarmalaması çok karmaşıklaşabilirdi. 
* **Ne Kazandırdı?** Karmaşık alt sistemleri basit metotların (`sendSecureSms` vb.) arkasına gizledi. İstemcinin sistemi kullanımını son derece basit ve anlaşılır hale getirdi.

## Faz 3: Behavioral (Davranışsal) Örüntüler

### 4. Strategy (Strateji)
* **Kullanıldığı Yer:** `MessageFormatStrategy` arayüzü ve onu uygulayan `PlainTextStrategy`, `HtmlStrategy` sınıfları.
* **Hangi Sorunu Çözdü?** Mesaj formatlama işlemlerini kodun içine gömmek (hardcode) yerine dışarıdan enjekte edilebilir hale getirdik.
* **Ne Kazandırdı?** Algoritmayı çalışma zamanında (runtime) değiştirebilme yeteneği. Bildirim formatını anında HTML'den Plain Text'e değiştirebiliyoruz ve bunun için asıl sınıflara dokunmuyoruz. (Open/Closed Prensibi)

### 5. Observer (Gözlemci)
* **Kullanıldığı Yer:** `Subscriber` arayüzü, `UserSubscriber` ve `SystemPublisher` sınıfları.
* **Hangi Sorunu Çözdü?** Bir olay olduğunda (örneğin sipariş kargolandığında) kime mesaj gideceğini ana akışın bilmesi gerekmiyor. Olay tabanlı (event-driven) bir yapı kurduk.
* **Ne Kazandırdı?** Publisher (Yayıncı) ve Subscriber (Abone) arasındaki sıkı bağımlılığı kopardı. Publisher kimin abone olduğunu bilmez, sadece `update` metodunu tetikler. Yeni bir abone tipi eklendiğinde Publisher kodu hiç değişmez. (Yine tam Open/Closed Prensibi uyumu).
