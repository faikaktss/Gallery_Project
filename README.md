# 🚗 Galeri Projesi - Backend (Java & Spring Boot)

---

## 🌟 Proje Tanımı

**Galeri Projesi**, bir araç galerisi için yazılmış, profesyonel ve güvenli bir backend uygulamasıdır. Proje, araç, müşteri, galerist ve ilgili varlıkların yönetimini; kullanıcı kimlik doğrulama ve yetkilendirme işlemlerini; güncel döviz kurları entegrasyonunu ve hatalara karşı gelişmiş yönetimi sağlar. Tüm katmanlar modern Java (Spring Boot) teknolojileri ile geliştirilmiştir.

Veritabanı bilgileri Geçerli Değildir. Random bilgilerdir:)

---

## 🎯 Özellikler

- **JWT ile Kimlik Doğrulama:** Kayıt, giriş, token yenileme ve güvenli oturum yönetimi.
- **Rol ve Yetki Yönetimi:** Her istekte güvenli erişim kontrolü.
- **Varlık Yönetimi:** Araç, müşteri, galerist, hesap, adres ve daha fazlası için CRUD işlemleri.
- **Döviz Kuru Entegrasyonu:** TCMB API’dan canlı USD/TL kurları.
- **Global Exception Handling:** Anlaşılır hata mesajları ve kodları.
- **DTO & Entity Kullanımı:** Katmanlar arası güvenli veri transferi.
- **Temiz Kod Mimari:** SOLID prensipleri, best practice ve modüler yapı.

---

## 🏗️ Mimarisi

```
Kullanıcı → Controller → Service → Repository → Entity (JPA) → PostgreSQL
         → Güvenlik (JWT, BCrypt) → Exception Handler
```

- **Controller:** REST API uç noktaları.
- **Service:** İş mantığı ve validasyon.
- **Repository:** Veritabanı işlemleri.
- **Model/Entity:** Veritabanı tabloları.
- **DTO:** API veri transfer nesneleri.
- **SecurityConfig:** Spring Security & JWT entegrasyonu.

---

## 📚 Temel Varlıklar (Entities)

- `User` (Kullanıcı)
- `Account` (Hesap)
- `Address` (Adres)
- `Car` (Araç)
- `Customer` (Müşteri)
- `Gallerist` (Galerist)
- `GalleristCar` (Galerist-Araba ilişkisi)
- `ResfrehToken` (Token yenileme)
- `SaledCar` (Satış kaydı)

Her varlığın DTO’ları ile API’ye özel veri alışverişi sağlanır.

---

## 🛡️ Güvenlik & Kimlik Doğrulama

- JWT tabanlı kimlik doğrulama sistemi
- Giriş (`/authenticate`), kayıt (`/register`), token yenileme (`/refreshToken`)
- BCrypt ile şifre saklama
- Spring Security ile role dayalı erişim

---

## 📲 API Uç Noktaları (Örnekler)

| Endpoint                                    | Metot | Açıklama                   |
|----------------------------------------------|-------|----------------------------|
| `/register`                                 | POST  | Kullanıcı kaydı            |
| `/authenticate`                             | POST  | Giriş/JWT alma             |
| `/refreshToken`                             | POST  | Token yenileme             |
| `/rest/api/car/save`                        | POST  | Araç ekleme                |
| `/rest/api/customer/save`                   | POST  | Müşteri ekleme             |
| `/rest/api/account/save`                    | POST  | Hesap ekleme               |
| `/rest/api/address/save`                    | POST  | Adres ekleme               |
| `/rest/api/gallerist/save`                  | POST  | Galerist ekleme            |
| `/rest/api/GalleristCar/save`               | POST  | Galerist-Araba ekleme      |
| `/rest/api/currency-rest/currency-rest`     | GET   | Döviz kuru sorgulama       |

---

## 🛑 Hata Yönetimi

- `BaseException` ve özel hata kodları (`MessageType`)
- Global Exception Handler ile detaylı API hata cevapları
- Girdi doğrulamada otomatik hata yakalama

---

## 💱 Döviz Kuru Entegrasyonu

- TCMB API’dan USD/TL kuru çekilir
- Güvenli API anahtarı ile istekte bulunulur
- Tarih aralığına göre güncel veri

---

## 🛠️ Kurulum & Çalıştırma

1. **Projeyi Klonlayın:**
   ```bash
   git clone https://github.com/faikaktss/Gallery_Project.git
   cd Gallery_Project
   ```

2. **Veritabanı ve ayarları yapılandırın:**
   - `application.properties` dosyasına veritabanı, JWT secret, vs. girin.

3. **Projeyi derleyip başlatın:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **API testleri için Postman veya benzeri araçlar kullanın.**

---

## 💻 Teknolojiler

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **Maven**
- **PostgreSQL**
- **Lombok**

---

## 📦 Proje Dizilimi

```
src/
├── java/com/faik/
│   ├── Config/
│   ├── Controller/
│   ├── Dto/
│   ├── Model/
│   ├── Repository/
│   ├── Service/
│   ├── Jwt/
│   ├── Exception/
│   ├── Handler/
│   ├── enums/
│   ├── Starter/
└── resources/application.properties
```

---

## 🤝 Katkı Sağlamak

Pull request ve issue açarak projeye katkı sağlayabilirsiniz.  
Kodunuzu temiz ve anlaşılır tutmaya özen gösterin.

---

## 📄 Lisans

MIT License

---

> **Hazır, güvenli ve profesyonel bir galeri yönetimi — Java ile!**
