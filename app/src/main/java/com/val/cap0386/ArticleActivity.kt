package com.`val`.cap0386

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        var theopt = intent.getStringExtra("x")
        if (theopt == "1"){
            txtJudul.setText("How to minimize outbreak?")
            txtKonten.setText("Untuk demam berdarah:\n" +
                    "1. Menguras bak mandi seminggu sekali\n" +
                    "2. Bersihkan juga wadah penampung air lainnya\n" +
                    "3. Pasang kasa dan kelambu nyamuk\n" +
                    "4. Jangan menumpuk atau menggantung baju terlalu lama\n" +
                    "5. Gunakan lotion atau krim antinyamuk\n" +
                    "6. Gunakan pakaian tertutup saat keluar rumah\n" +
                    "7. Fogging\n" +
                    "8. Pangkas dan bersihkan tanaman liar di pekarangan rumah\n" +
                    "9. Hias rumah dengan tanaman antinyamuk alami\n" +
                    "10. Vaksin DBD\n")
        }
        if (theopt == "2"){
            txtJudul.setText("What to do when outbreak occur?")
            txtKonten.setText("Wabah dapat datang dari banyak sumber (alami atau buatan) dan menyebar melalui banyak transmisi seperti yang kita tahu " +
                    "pada istilah carriers seperti nyamuk dan kutu, mengontaminasi air atau makanan atau bahkan dengan kontak manusia sederhana. " +
                    "Karena banyak penyakit menular hanya dapat ditangani dan tidak dapat disembuhkan, proteksi, prevensi, dan sumber penyembuhan sangat " +
                    "penting dalam wabah yang sedang berlangsung. Usaha dan respon medis sering kali diberikan melalui program edukasional, disertai dengan " +
                    "vaksinasi (jika ada) dan berbagai program pencegahan lainnya. Pengetahuan komunitas dapat menjadi komponen yang paling efektif dalam pencegahan.")
        }
    }
}