# ☕ CaféConnect - Smart Food Ordering for College Campuses

**CaféConnect** is a smart, student-friendly food ordering Android application built using **Android Studio** and **Firebase**. Designed for college cafeterias, it replaces long queues with smooth, token-based pickups and a digital ordering experience—all in real time.

---

## 🚀 Key Features

### 👨‍🎓 Student-Centered Experience
- 🔐 **Register & Login** securely with email and SAP ID  
- 🍽️ **Digital Menu** with item names, prices, and descriptions  
- 🛒 **Cart Management**: Add, remove, update quantities  
- 💳 **Simulated Payment Flow** (UI-based)  
- 🎟️ **Token Generation** for each order after checkout  
- 🧾 **Live Order Status Display** using token logic  
- 🧑‍💼 **User Profile Module**: View & edit user info  
- 📱 **Clean UI** optimized for all Android devices  

---

## 🛠️ Tech Stack

| Component            | Technology                      |
|----------------------|----------------------------------|
| Platform             | Android (Java/XML)               |
| Backend              | Firebase Realtime Database       |
| Authentication       | Firebase Authentication          |
| UI/UX                | Material Design Components       |
| Data Sync            | Firebase Live Data Integration   |

---

## 🔋 Firebase Structure

ProfileNode/
  └── userID/
       ├── name
       ├── email
       ├── sapId
       └── orderHistory (if extended)
---
## 🧭 App Flow

1. **Login/Register** using email & SAP ID  
2. **Browse Menu** with simple and clean layout  
3. **Add Items** to Cart and review your selection  
4. **Confirm Order** and generate your **Token**  
5. **Track Token** on-screen until your food is ready  
6. **Pickup** from the cafeteria with ease  

---

## 🏁 How to Run

> 🛠️ Requires Android Studio (Flamingo or higher recommended) + Firebase setup

1. Clone this repo  
2. Open in Android Studio  
3. Connect your Firebase project  
4. Add `google-services.json` to `app/`  
5. Run the app on emulator or device  

---

## 📸 Screenshots (Add Your Screenshots Here)

- ✅ Start of App
![Start](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/WhatsApp%20Image%202025-06-22%20at%2010.49.41.jpeg?raw=true)
- ✅ Login/Register Page
![Login](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105108.png?raw=true)
- ✅ Menu Display
![Menu Display](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105118.png?raw=true)
![Menu Display1](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105132.png?raw=true)
![Menu Display2](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105141.png?raw=true)
![Menu Display3](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105148.png?raw=true)

- ✅ Cart Page
![Cart Page](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105156.png?raw=true)
- ✅ Token Display Page
![Token1](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105202.png?raw=true)
![Token2](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105208.png?raw=true)
![Token3](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105216.png?raw=true)
- ✅ Profile Module
![P1](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105229.png?raw=true)
![p2](https://github.com/sakshi01coder/Cafateria/blob/main/screenshots/Screenshot%202025-06-22%20105238.png?raw=true)

## 📜 License

This project is licensed under the **MIT License**.  
See the [LICENSE](LICENSE) file for details.
