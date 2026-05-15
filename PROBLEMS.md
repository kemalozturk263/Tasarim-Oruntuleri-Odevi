# Tasarım Sorunları Analizi (Faz 0)

## Gözlemlenen Sorunlar (Kendi Analizim)
1. **Single Responsibility Principle (SRP) İhlali:** `NotificationSender` sınıfı hem Email, hem SMS, hem de Push bildirimlerinin nasıl gönderileceğini biliyor. Bağlantı kurma, formatlama ve gönderme işlemleri tek sınıfta toplanmış. Sınıfın birden fazla değişme nedeni var.
2. **Open/Closed Principle (OCP) İhlali:** Sisteme yeni bir bildirim tipi (örneğin Slack veya WhatsApp) eklemek istediğimizde mevcut `sendNotification` metodunu değiştirmek ve yeni bir `else if` bloğu eklemek zorundayız. Kod gelişime açık, değişime kapalı değil.
3. **Yüksek Bağımlılık (High Coupling):** Bildirim mantıkları birbirine ve ana sınıfa çok sıkı bağlı. Herhangi bir bildirim türündeki bir değişiklik (örneğin SMS API'sinin değişmesi), tüm bildirim sistemini barındıran sınıfı etkileyebilir.
4. **Test Edilebilirlik Sorunu (Hard to Test):** Bildirim gönderme mantığı doğrudan sınıfın içine yazıldığı için (örneğin SMTP sunucusuna bağlanma), bu sınıfı birim testine (unit test) tabi tutmak çok zordur. Servisleri mock'lamak (taklit etmek) imkansız hale gelir.
5. **Kod Tekrarı ve Karmaşıklık (Spaghetti Code):** Bildirim tipleri arttıkça `sendNotification` metodu devasa bir boyuta ulaşacak (God Method). Gelecekte kodu okumak ve bakımını yapmak çok zorlaşacak.

---

## AI Analizi
*Not: Bu bölüm AI Pair Programmer (Antigravity) tarafından ödevin yönergelerine uygun olarak değerlendirilmiştir.*

**AI'ın Gördüğü Sorunlar:**
- Sınıfın her şeyi yapan bir **God Class** (Tanrı Sınıfı) anti-pattern'ine dönüşme eğiliminde olduğu görülüyor.
- if-else zincirleri, polimorfizm (çok biçimlilik) eksikliğini net bir şekilde gösteriyor.
- Bağımlılıkların tersine çevrilmesi (Dependency Inversion) prensibi ihlal edilmiş; yüksek seviyeli `NotificationSender` modülü, düşük seviyeli bildirim gönderme detaylarına doğrudan bağlı.

**Önerilen Tasarım Örüntüleri:**
1. **Factory Method / Abstract Factory (Creational):** Bildirim nesnelerinin yaratılış sürecini `NotificationSender` sınıfından ayırmak için kullanılabilir.
2. **Strategy Pattern (Behavioral):** `if-else` zincirinden kurtulup, her bildirim tipini kendi strateji sınıfına (Strategy) dönüştürmek için idealdir. (Açık/Kapalı prensibini çözer).
3. **Decorator (Structural):** Eğer gelecekte aynı anda hem e-posta hem SMS atma, veya mesaja şifreleme/loglama ekleme gibi ihtiyaçlar olursa mesajları dinamik olarak sarmalamak için kullanılabilir.

**Kendi Analizim vs. AI Analizi Karşılaştırması:**
AI'ın analizi ile benim analizim büyük ölçüde örtüşüyor. Ben daha çok SOLID prensiplerinin ihlallerine (SRP ve OCP) odaklandım. AI ise bu prensip ihlallerini doğruladı ve bu sorunları çözmek için kullanabileceğimiz somut tasarım örüntülerini (Factory Method, Strategy, Decorator) ismen önerdi. Temel sorunları tespit etme konusunda aramızda bir fark yok, ancak AI çözüm mimarisini daha teknik bir dille özetledi.
