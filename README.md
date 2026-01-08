
---

# 📱 Android Navigation Drawer Assignment

## 📌 Overview

This project is an Android application developed as part of an interview assignment for the **Android Developer** position.
The application implements a **custom navigation drawer** that dynamically loads user profile details and menu items from a REST API, following the provided UI design reference.

### 📥 APK Download

👉 **[Download App APK](https://drive.google.com/file/d/17WUQBgljPG-DdzYlp2sOL1E4ikh-B3to/view?usp=sharing)**

---

## 🎯 Features Implemented

### 🔹 Navigation Drawer UI

* Custom navigation drawer layout based on the provided design.
* Responsive UI optimized for different screen sizes.
* Clean and modern Material Design components.

### 🔹 Profile Section

* Displays user **name** and **profile picture**.
* Data is dynamically fetched from the API.
* Graceful handling of missing or invalid profile data.

### 🔹 Drawer Items

* Menu items are populated dynamically from the API response.
* **Apps section**:

  * Initially displays **only 4 items**.
  * Includes a **“See More”** option.
  * On click, expands to show **all available items**.
* Other sections display **all items by default**, as per API data.

### 🔹 API Integration

* Fetches navigation data from the provided REST API.
* Handles:

  * Loading states
  * API success responses
  * Error and failure cases

---

## 🌐 API Used

**Endpoint**


(CompanyProvided)


**Parameters**

* `restApi`: Sesapi
* `sesapi_platform`: 1
* `auth_token`: Provided token

---

## 🛠 Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose / XML
* **Architecture:** MVVM
* **Networking:** Retrofit
* **State Management:** ViewModel
* **Image Loading:** Coil / Glide
* **Design:** Material Components

---

## 🧠 Implementation Details

* API data is parsed and mapped into UI models.
* Modular layouts/composables for profile and drawer sections.
* State-driven UI handling **See More / See Less** functionality.
* Clean separation of UI, data, and business logic.

---

## 🚀 How to Run

1. Clone the repository:

```bash
git clone <your-repo-url>
```

2. Open the project in **Android Studio**
3. Sync Gradle files
4. Run the app on an emulator or physical device

---

## 📸 Screenshots



<p align="center">
  <img src="https://github.com/user-attachments/assets/a0750320-967f-4d80-a420-70f313fda48a" width="220"/>
  <img src="https://github.com/user-attachments/assets/c93f3115-9723-4469-a4af-6c8a9a29b66e" width="220"/>
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/29f317e2-4d88-4f35-9f4c-c9db1c6f0a70" width="220"/>
  <img src="https://github.com/user-attachments/assets/651f250f-542d-499d-b6e1-14e6283b18bb" width="220"/>
</p>

---

## 📄 Assignment Reference

This project was implemented based on the interview assignment requirements provided by
**Ahead WebSoft Technologies Pvt Ltd**, including UI design, API usage, and interaction behavior.

---

## ✍️ Author

**Aditya Singh**
Android Developer
📧 [adi965051@gmail.com](mailto:adi965051@gmail.com)

---
