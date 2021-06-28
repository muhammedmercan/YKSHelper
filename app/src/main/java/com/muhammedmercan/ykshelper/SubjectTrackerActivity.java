package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import java.util.ArrayList;

public class SubjectTrackerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<String> typeOfExam;

    ArrayList<Subject> subjects;
    private SubjectRecyclerViewAdapter subjectRecyclerViewAdapter;
    private RecyclerView subjectRecView;
    private CardView cardViewSubjectTrackerTyt;

    private Spinner spinner;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_tracker);

        initViews();
        typeOfExam = new ArrayList<>();
        subjects = new ArrayList<>();

        setTypeOfExam();

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,typeOfExam);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        showSubjects(typeOfExam.get(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }

    private void setSubjectsData(String[] data) {

        for (String eachData: data) {
            subjects.add(new Subject(eachData));

        }

    }

    private void showSubjects(String typeOfExam) {


        switch (typeOfExam) {

            case "TYT Türkçe":
                subjects.clear();

                String[] data = new String[] {"Sözcükte Anlam", "Cümlede Anlam", "Paragrafta Anlam", "Ses Bilgisi", "Yazım Kuralları", "Noktalama İşaretleri", "Sözcükte Yapı", "İsimler (Adlar)", "Sıfatlar (Ön Adlar)", "Zamirler (Adıllar)", "Zarflar (Belirteç)", "Edat, Bağlaç, Ünlem", "Fiiler (Eylemler)", "Ek Fiil", "Fiilimsi", "Fiilde Çatı", "Cümlenin Ögeleri", "Cümle Türleri", "Anlatım Bozuklukları"};
                setSubjectsData(data);
                break;

            case "TYT Tarih":
                subjects.clear();
                String[] data7 = new String[] {"Tarih Bilimi", "İlk Uygarlıklar", "İlk Türk Devletleri", "İslam Tarihi ve Uygarlığı", "Türk-İslam Devletleri", "Orta Çağ ve Avrupa Tarihi", "Türkiye Tarihi", "Beylikten Devlete (1300-1453)", "Dünya Gücü: Osmanlı Devleti (1453-1600)", "Osmanlı Kültür ve Medeniyeti", "Yeni ve Yakın Çağda Avrupa Tarihi", "Arayış Yılları (17. Yüzyıl)", "Yeni Çağda Avrupa", "En Uzun Yüzyıl (1800-1922)", "20. Yüzyıl Başlarında Osmanlı Devleti", "1. Dünya Savaşı – Milli Mücadeleye Hazırlık Dönemi", "Kurtuluş Savaşı ve Antlaşmalar", "I. TBMM Dönemi", "Türk İnkılabı", "Atatürkçülük ve Atatürk İlkeleri", "Türk Dış Politikası"};
                setSubjectsData(data7);
                break;

            case "TYT Coğrafya":
                subjects.clear();
                String[] data8 = new String[] {"Doğa ve İnsan", "Dünya’nın Şekli ve Hareketleri", "Coğrafi Konum", "Harita Bilgisi", "Atmosfer ve Sıcaklık", "İklimler", "Basınç ve Rüzgarlar", "Nem, Yağış ve Buharlaşma", "İç Kuvvetler / Dış Kuvvetler", "Su – Toprak ve Bitkiler", "Nüfus", "Göç", "Yerleşme", "Türkiye’nin Yer Şekilleri", "Ekonomik Faaliyetler", "Bölgeler", "Uluslararası Ulaşım Hatları", "Çevre ve Toplum", "Doğal Afetler"};
                setSubjectsData(data8);
                break;

            case "TYT Felsefe":
                subjects.clear();
                String[] data25 = new String[] {"Felsefe’nin Konusu", "Bilgi Felsefesi", "Varlık Felsefesi", "Ahlak Felsefesi", "Sanat Felsefesi", "Din Felsefesi", "Siyaset Felsefesi", "Bilim Felsefesi"};
                setSubjectsData(data25);
                break;

            case "TYT Din":
                subjects.clear();
                String[] data9 = new String[] {"Bilgi ve İnanç", "İslam ve İbadet", "Ahlak ve Değerler", "Allah İnsan İlişkisi", "Hz. Muhammed (S.A.V.)", "Vahiy ve Akıl", "İslam Düşüncesinde Yorumlar, Mezhepler", "Din, Kültür ve Medeniyet", "İslam ve Bilim, Estetik, Barış", "Yaşayan Dinler"};
                setSubjectsData(data9);
                break;

            case "TYT Matematik":
                subjects.clear();
                String[] data2 = new String[] {"Temel Kavramlar", "Sayı Basamakları", "Bölme ve Bölünebilme", "EBOB – EKOK", "Rasyonel Sayılar", "Basit Eşitsizlikler", "Mutlak Değer", "Üslü Sayılar", "Köklü Sayılar", "Çarpanlara Ayırma", "Oran Orantı", "Denklem Çözme", "Problemler", "Kümeler", "Kartezyen Çarpım", "Mantık", "Fonskiyonlar", "Polinomlar", "2.Dereceden Denklemler", "Permütasyon ve Kombinasyon", "Olasılık", "İstatistik"};
                setSubjectsData(data2);
                break;

            case "TYT Geometri":
                subjects.clear();
                String[] data3 = new String[] {"Temel Kavramlar", "Doğruda Açılar", "Üçgende Açılar", "Özel Üçgenler", "Açıortay", "Kenarortay", "Üçgende Alan", "Üçgende Benzerlik", "Açı Kenar Bağıntıları", "Çokgenler", "Özel Dörtgenler", "Çember ve Daire", "Noktanın Analitiği", "Doğrunun Analitiği", "Katı Cisimler"};
                setSubjectsData(data3);
                break;

            case "TYT Fizik":
                subjects.clear();
                String[] data4 = new String[] {"Fizik Bilimine Giriş", "Madde ve Özellikleri", "Sıvıların Kaldırma Kuvveti", "Basınç", "Isı, Sıcaklık ve Genleşme", "Hareket", "Dinamik", "İş, Güç ve Enerji", "Elektrik", "Optik", "Manyetizma", "Dalgalar"};
                setSubjectsData(data4);
                break;

            case "TYT Kimya":
                subjects.clear();
                String[] data5 = new String[] {"Kimya Bilimi", "Atom ve Periyodik Sistem", "Kimyasal Türler Arası Etkileşimler", "Kimyasal Hesaplamalar", "Kimyanın Temel Kanunları", "Asit, Baz ve Tuz", "Maddenin Halleri", "Karışımlar", "Doğa ve Kimya", "Kimya Her Yerde"};
                setSubjectsData(data5);
                break;

            case "TYT Biyoloji":
                subjects.clear();
                String[] data6 = new String[] {"Canlıların Ortak Özellikleri", "Canlıların Temel Bileşenleri", "Hücre ve Organelleri", "Hücre Zarından Madde Geçişi", "Canlıların Sınıflandırılması", "Mitoz ve Eşeysiz Üreme", "Mayoz ve Eşeyli Üreme", "Kalıtım", "Ekosistem Ekolojisi", "Güncel Çevre Sorunları"};
                setSubjectsData(data6);
                break;



            case "AYT Matematik":
                subjects.clear();
                String[] data10 = new String[] {"Temel Kavramlar", "Sayı Basamakları", "Bölme ve Bölünebilme", "EBOB – EKOK", "Rasyonel Sayılar", "Basit Eşitsizlikler", "Mutlak Değer", "Üslü Sayılar", "Köklü Sayılar", "Çarpanlara Ayırma", "Oran Orantı", "Denklem Çözme", "Problemler", "Kümeler", "Kartezyen Çarpım", "Mantık", "Fonskiyonlar", "Polinomlar", "2.Dereceden Denklemler", "Permütasyon ve Kombinasyon", "Binom ve Olasılık", "İstatistik", "Karmaşık Sayılar", "2.Dereceden Eşitsizlikler", "Parabol", "Trigonometri", "Logaritma", "Diziler", "Limit", "Türev", "İntegral"};
                setSubjectsData(data10);
                break;

            case "AYT Fizik":
                subjects.clear();
                String[] data11 = new String[] {"Vektörler", "Kuvvet, Tork ve Denge", "Kütle Merkezi", "Basit Makineler", "Hareket", "Newton’un Hareket Yasaları", "İş, Güç ve Enerji II", "Atışlar", "İtme ve Momentum", "Elektrik Alan ve Potansiyel", "Paralel Levhalar ve Sığa", "Manyetik Alan ve Manyetik Kuvvet", "İndüksiyon, Alternatif Akım ve Transformatörler", "Çembersel Hareket", "Kütle Çekim ve Kepler Yasaları", "Basit Harmonik Hareket", "Dalga Mekaniği ve Elektromanyetik Dalgalar", "Atom Modelleri", "Büyük Patlama ve Radyoaktivite", "Modern Fizik", "Modern Fiziğin Teknolojideki Uygulamaları"};
                setSubjectsData(data11);
                break;

            case "AYT Kimya":
                String[] data21 = new String[] {"Kimya Bilimi", "Atom ve Periyodik Sistem", "Kimyasal Türler Arası Etkileşimler", "Kimyasal Hesaplamalar", "Kimyanın Temel Kanunları", "Asit, Baz ve Tuz", "Maddenin Halleri", "Karışımlar", "Doğa ve Kimya", "Kimya Her Yerde", "Modern Atom Teorisi", "Gazlar", "Çözeltiler", "Kimyasal Tepkimelerde Enerji", "Kimyasal Tepkimelerde Hız", "Kimyasal Tepkimelerde Denge", "Asit-Baz Dengesi", "Çözünürlük Dengesi", "Kimya ve Elektrik", "Karbon Kimyasına Giriş", "Organik Kimya"};
                        setSubjectsData(data21);
                subjects.clear();
                break;

            case "AYT Biyoloji":
                subjects.clear();
                String[] data12 = new String[] {"Sinir Sistemi", "Endokrin Sistem", "Duyu Organları", "Destek ve Hareket Sistemi", "Sindirim Sistemi", "Dolaşım ve Bağışıklık Sistemi", "Solunum Sistemi", "Üriner Sistem", "Üreme Sistemi ve Embriyonik Gelişim", "Komünite ve Popülasyon Ekolojisi", "Nükleik Asitler", "Genetik Şifre ve Protein Sentezi", "Canlılık ve Enerji", "Fotosentez ve Kemosentez", "Hücresel Solunum", "Bitki Biyolojisi", "Canlılar ve Çevre"};
                setSubjectsData(data12);
                break;

            case "AYT Edebiyat":
                subjects.clear();
                String[] data13 = new String[] {"Anlam Bilgisi", "Dil Bilgisi", "Güzel Sanatlar ve Edebiyat", "Metinlerin Sınıflandırılması", "Şiir Bilgisi", "Edebi Sanatlar", "Türk Edebiyatı Dönemleri", "İslamiyet Öncesi Türk Edebiyatı ve Geçiş Dönemi", "Halk Edebiyatı", "Divan Edebiyatı", "Tanzimat Edebiyatı", "Servet-i Fünun Edebiyatı", "Fecr-i Ati Edebiyatı", " Milli Edebiyat", "Cumhuriyet Şiiri", "Cumhuriyet Romanı", "Cumhuriyet Dönemi", "Edebiyat Akımları", "Dünya Edebiyatı"};
                setSubjectsData(data13);
                break;

            case "AYT Tarih":
                subjects.clear();
                String[] data14 = new String[] {"Tarih Bilimi", "İlk Uygarlıklar", "İlk Türk Devletleri", "İslam Tarihi ve Uygarlığı", "Türk-İslam Devletleri", "Orta Çağ ve Avrupa Tarihi", "Türkiye Tarihi", "Beylikten Devlete (1300-1453)", "Dünya Gücü: Osmanlı Devleti (1453-1600)", "Osmanlı Kültür ve Medeniyeti", "Yeni ve Yakın Çağda Avrupa Tarihi", "Arayış Yılları (17. Yüzyıl)", "Yeni Çağda Avrupa", "En Uzun Yüzyıl (1800-1922)", "20. Yüzyıl Başlarında Osmanlı Devleti", "1. Dünya Savaşı – Milli Mücadeleye Hazırlık Dönemi", "Kurtuluş Savaşı ve Antlaşmalar", "I. TBMM Dönemi", "Türk İnkılabı", "Atatürkçülük ve Atatürk İlkeleri", "Türk Dış Politikası", "Atatürk’ün Ölümü", "20. yy Başlarında Dünya", "İkinci Dünya Savaşı", "Soğuk Savaş Dönemi", "Yumuşama Dönemi ve Sonrası", "Küreselleşen Dünya", "XXI. Yüzyılın Eşiğinde Türkiye ve Dünya"};
                setSubjectsData(data14);
                break;

            case "AYT Coğrafya":
                subjects.clear();
                String[] data15 = new String[] {"Ekosistem", "Doğadaki Ekstrem Olaylar", "İlk Medeniyet ve Şehirler", "Nüfus Politikaları", " Türkiye’de Nüfus ve Yerleşme", "Ekonomik Faaliyetler", "Göç ve Şehirleşme", "Türkiye Ekonomisi", "Türkiye’nin Jeopolitik Konumu", "Bölgesel Kalkınma Projeleri", "İklim ve Yer şekilleri", "Ülkeler Arası Etkileşim", "Küresel ve Bölgesel Örgütler", "Üretim Alanları ve Ulaşım Ağları", "Bölgeler ve Ülkeler", "Çevre ve Toplum", "Doğal Afetler"};
                setSubjectsData(data15);
                break;

            case "AYT Felsefe":
                subjects.clear();
                String[] data18 = new String[] {"Felsefe’nin Konusu", "Bilgi Felsefesi", "Varlık Felsefesi", "Ahlak Felsefesi", "Sanat Felsefesi", "Din Felsefesi", "Siyaset Felsefesi", "Bilim Felsefesi", "Mantığa Giriş", "Klasik Mantık", "Mantık ve Dil", "Sembolik Mantık", "Psikoloji Bilimini Tanıyalım", "Psikolojinin Temel Süreçleri", "Öğrenme Bellek Düşünme", "Ruh Sağlığının Temelleri", "Sosyolojiye Giriş", "Birey ve Toplum", "Toplumsal Yapı", "Toplumsal Değişme ve Gelişme", "Toplum ve Kültür", "Toplumsal Kurumlar"};
                setSubjectsData(data18);
                break;

            case "AYT Din":
                subjects.clear();
                String[] data19 = new String[] {"Dünya ve Ahiret", "Kur’an’a Göre Hz. Muhammed", "Kur’an’da Bazı Kavramlar", "Kur’an’dan Mesajlar", "İnançla İlgili Meseleler", "İslam ve Bilim", "Anadolu’da İslam", "İslam Düşüncesinde Tasavvufi Yorumlar ve Mezhepler", "Güncel Dini Meseleler", "Yaşayan Dinler"};
                setSubjectsData(data19);
                break;

            case "AYT Dil":
                subjects.clear();
                String[] data20 = new String[] {"Kelime Bilgisi", "Dil Bilgisi", "Cloze Test", "Cümleyi Tamamlama", "İngilizce Cümlenin Türkçe Karşılığını Bulma", "Türkçe Cümlenin İngilizce Karşılığını Bulma", "Paragraf Anlamca Yakın Cümleyi Bulma", "Paragrafta Anlam Bütünlüğünü Sağlayacak Cümleyi Bulma", "Verilen Durumda Söylenecek İfadeyi Bulma", "Diyalog Tamamlama", "Anlam Bütünlüğünü Bozan Cümleyi Bulma"};
                setSubjectsData(data20);
                break;


        }


        subjectRecyclerViewAdapter = new SubjectRecyclerViewAdapter(subjects);
        subjectRecView.setAdapter(subjectRecyclerViewAdapter);
        subjectRecView.setLayoutManager(new LinearLayoutManager(this));
        subjectRecyclerViewAdapter.notifyDataSetChanged();

    }

    private void setTypeOfExam() {
        typeOfExam.add("TYT Türkçe");
        typeOfExam.add("TYT Matematik");
        typeOfExam.add("TYT Geometri");
        typeOfExam.add("TYT Fizik");
        typeOfExam.add("TYT Kimya");
        typeOfExam.add("TYT Biyoloji");
        typeOfExam.add("TYT Tarih");
        typeOfExam.add("TYT Coğrafya");
        typeOfExam.add("TYT Felsefe");
        typeOfExam.add("TYT Din");

        typeOfExam.add("AYT Matematik");
        typeOfExam.add("AYT Fizik");
        typeOfExam.add("AYT Kimya");
        typeOfExam.add("AYT Biyoloji");
        typeOfExam.add("AYT Edebiyat");
        typeOfExam.add("AYT Tarih");
        typeOfExam.add("AYT Coğrafya");
        typeOfExam.add("AYT Felsefe");
        typeOfExam.add("AYT Din");
        typeOfExam.add("AYT Dil");


    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        cardViewSubjectTrackerTyt = findViewById(R.id.parent);
        subjectRecView = findViewById(R.id.subjectRecView);
        checkBox = findViewById(R.id.subjectCheckBox);



    }



}