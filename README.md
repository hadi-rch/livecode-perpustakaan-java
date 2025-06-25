# Enigma Library Inventory System

Sistem Inventaris Perpustakaan Enigma adalah aplikasi konsol Java sederhana untuk mengelola inventaris buku dan majalah.

## Fitur

*   Menambahkan buku atau majalah baru ke dalam inventaris.
*   Mencari buku berdasarkan judul.
*   Memperbarui informasi buku yang sudah ada.
*   Menghapus buku dari inventaris.
*   Menampilkan semua buku dalam inventaris.

## Struktur Proyek

```
C:/Java/live-code/
├───.gitignore
├───live-code.iml
├───.git/...
├───.idea/...
├───out/...
└───src/
    ├───Book.java
    ├───InventoryService.java
    ├───Magazine.java
    ├───Novel.java
    └───com/
        └───enigma/
            └───gosling/
                └───Main.java
```

*   **`src/`**: Direktori ini berisi semua kode sumber Java.
*   **`Book.java`**: Kelas abstrak yang menjadi dasar untuk semua jenis buku.
*   **`Novel.java`**: Kelas yang merepresentasikan sebuah novel, merupakan turunan dari `Book`.
*   **`Magazine.java`**: Kelas yang merepresentasikan sebuah majalah, merupakan turunan dari `Book`.
*   **`InventoryService.java`**: Antarmuka (interface) untuk layanan inventaris.
*   **`com/enigma/gosling/Main.java`**: Kelas utama yang berisi titik masuk (entry point) aplikasi dan antarmuka pengguna (UI) konsol.

## Cara Menjalankan Proyek

1.  **Kompilasi Kode:**
    Buka terminal atau command prompt, arahkan ke direktori `src`, dan kompilasi semua file Java:
    ```bash
    javac ./**/*.java
    ```

2.  **Jalankan Aplikasi:**
    Setelah kompilasi berhasil, jalankan aplikasi dari kelas `Main`:
    ```bash
    java com.enigma.gosling.Main
    ```
