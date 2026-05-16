# Yapay Zeka Eşliğinde Programlama Günlüğü - Faz 2

## Prompt (AI'a ne sordum?)
*"Sisteme yeni özellikler (loglama ve şifreleme) eklemek istiyorum ama mevcut bildirim kodlarını değiştirmek istemiyorum. Adapter pattern burada uygun mu, yoksa Facade veya Decorator mı? Farkını açıkla."*

## AI'ın Yanıtı Özeti
AI, bu senaryo için **Decorator** örüntüsünün en doğru seçim olduğunu belirtti. 
- **Adapter**, var olan iki uyumsuz arayüzü (interface) birbiriyle konuşturmak için kullanılır (örneğin eski bir 3. parti kütüphaneyi bizim sisteme uydurmak). Bizim durumumuzda arayüz uyumsuzluğu yok.
- **Facade**, karmaşık bir alt sistemi basit bir arayüz arkasına gizlemek için kullanılır. Sınıflara yeni davranış eklemez.
- **Decorator**, nesnelere çalışma zamanında (runtime) dinamik olarak yeni davranışlar (loglama, şifreleme) eklemek için kullanılır ve tam olarak bizim aradığımız çözümdür.

Ayrıca AI, bu kadar çok örüntü eklendiğinde `Main` sınıfının (istemcinin) işinin zorlaşacağını, bu yüzden Factory ve Decorator nesnelerinin yaratımını gizlemek için bir **Facade** örüntüsü (NotificationFacade) eklememizin de çok iyi bir yapısal tasarım olacağını önerdi.

## AI'ın Yanlış/Eksik Önerisi ve Benim Yaklaşımım
AI'ın açıklamaları teorik olarak doğruydu, ancak Decorator ile Facade'ı aynı anda kullanmanın istemci tarafındaki (Main) esnekliği kısıtlayabileceğini fark ettim. Facade kullandığımda, dinamik davranış ekleme özelliğini sadece Facade içine yazdığım metotlarla sınırlandırmış oldum (`sendLoggedAndSecurePush` gibi). Normalde Decorator'ın en büyük gücü istemcinin istediği kombinasyonu anında yaratabilmesidir. Yine de sistemin kullanımını basitleştirmek adına bu trade-off'u (ödünleşmeyi) kabul edip hem **Decorator** hem de **Facade** örüntüsünü uyguladım.
