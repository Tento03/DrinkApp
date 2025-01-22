DrinkApp
DrinkApp adalah aplikasi Android yang menampilkan berbagai jenis minuman dari API eksternal. Aplikasi ini menggunakan Retrofit untuk mendapatkan data minuman dari API dan Room untuk menyimpan minuman favorit pengguna secara offline.

Fitur
Tampilkan Daftar Minuman: Aplikasi akan mengambil dan menampilkan berbagai jenis minuman dari API eksternal.
Detail Minuman: Pengguna dapat melihat detail dari setiap minuman yang ditampilkan.
Simpan Minuman ke Favorit: Pengguna dapat menandai minuman favorit, yang akan disimpan secara lokal menggunakan Room Database.
Tampilkan Minuman Favorit: Pengguna dapat melihat daftar minuman yang telah disimpan ke favorit bahkan tanpa koneksi internet.
Teknologi yang Digunakan
Retrofit: Untuk mengambil data minuman dari API eksternal.
Room: Untuk menyimpan dan mengelola data minuman favorit secara lokal.
ViewModel & LiveData: Untuk memisahkan logika UI dari data dan melakukan pembaruan UI secara efisien.
RecyclerView: Untuk menampilkan daftar minuman.
Coroutines: Untuk menangani operasi asynchronous secara efisien.
