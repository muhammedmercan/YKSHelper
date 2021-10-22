package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.MultiAutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashSet;


public class RobotActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTypeOfPoint, btnTypeofUniversity, btnTypeOfDepartment, btnLanguage, btnShowResults;
    MultiAutoCompleteTextView multiAutoCompleteTextViewDepartment;
    MultiAutoCompleteTextView multiAutoCompleteTextViewCity;
    MultiAutoCompleteTextView multiAutoCompleteTextViewUniversity;
    TextInputEditText txtInputEditTextMinPoint, txtInputEditTextMaxPoint, txtInputEditTextMinPlacementRanking, txtInputEditTextMaxPlacementRanking;
    CheckBox checkBoxAssociateDegree, checkBoxDegree, checkBoxNotFilled, checkBoxNew;
    HashSet<String> notIncluded = new HashSet<String>();

    boolean[] departmentCheckedItems = {true, true, true, true, true,true, true, true, true, true, true};
    boolean[] languageCheckedItems = {true, true, true, true, true, true, true, true, true, true, true, true, true, true};
    boolean[] pointCheckedItems = {true, true, true, true, true, true, true, true, true, true, true, true, true, true};
    boolean[] universityCheckedItems= {true, true, true, true, true, true, true, true, true, true, true, true, true, true};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);
        initViews();
        setAutoCompleteContent();





    }

    private void setAutoCompleteContent() {
        String[] cities ={"ADANA", "ADIYAMAN", "AYFONKARAHİSAR", "AĞRI", "AKSARAY", "AMASYA", "ANKARA", "ANTALYA", "ARDAHAN", "ARTVİN", "AYDIN", "BALIKESİR", "BARTIN", "BATMAN", "BAYBURT", "BİLECİK", "BİNGÖL", "BİTLİS", "BOLU", "BURDUR", "BURSA", "ÇANAKKALE", "ÇANKIRI", "ÇORUM", "DENİZLİ", "DİYARBAKIR", "DÜZCE", "EDİRNE", "ELAZIĞ", "ERZİNCAN", "ERZURUM", "ESKİŞEHİR", "GAZİANTEP", "GİRESUN", "GÜMÜŞHANE", "HAKKÂRİ", "HATAY", "IĞDUR", "ISPARTA", "İSTANBUL", "İZMİR", "KAHRAMANMARAŞ", "KARABÜK", "KARAMAN", "KARS", "KASTAMON", "KAYSERİ", "KİLİS", "KIRIKKALE", "KIRKLARELİ", "KIRŞEHİR", "KOCAELİ", "KONYA", "KÜTAHYA", "Malatya", "MANİSA", "MARDİN", "MERSİN", "MUĞLA", "MUŞ", "NEVŞEHİR", "NİĞDE", "ORDU", "OSMANİYE", "RİZE", "SAKARYA", "SAMSUN", "ŞANLIURFA", "SİİRT", "SİNOP", "SİVAS", "ŞIRNAK", "TEKİRDAĞ", "TOKAT", "TRABZON", "TUNCELİ", "UŞAK", "VAN", "YALOVA", "YOZGAT", "ZONGULDAK"};
        String[] universities = {"İSTANBUL MEDİPOL ÜNİVERSİTESİ", "ACIBADEM MEHMET ALİ AYDINLAR ÜNİVERSİTESİ", "KOÇ ÜNİVERSİTESİ", "BOĞAZİÇİ ÜNİVERSİTESİ", "HACETTEPE ÜNİVERSİTESİ", "SABANCI ÜNİVERSİTESİ", "İSTANBUL ÜNİVERSİTESİ", "ÖZYEĞİN ÜNİVERSİTESİ", "İSTANBUL TEKNİK ÜNİVERSİTESİ", "TOBB EKONOMİ VE TEKNOLOJİ ÜNİVERSİTESİ", "BAHÇEŞEHİR ÜNİVERSİTESİ", "İSTİNYE ÜNİVERSİTESİ", "İHSAN DOĞRAMACI BİLKENT ÜNİVERSİTESİ", "EGE ÜNİVERSİTESİ", "ORTA DOĞU TEKNİK ÜNİVERSİTESİ", "YEDİTEPE ÜNİVERSİTESİ", "ANKARA ÜNİVERSİTESİ", "BAŞKENT ÜNİVERSİTESİ", "MARMARA ÜNİVERSİTESİ", "GALATASARAY ÜNİVERSİTESİ", "SAĞLIK BİLİMLERİ ÜNİVERSİTESİ", "AKDENİZ ÜNİVERSİTESİ", "ANKARA YILDIRIM BEYAZIT ÜNİVERSİTESİ", "İSTANBUL MEDENİYET ÜNİVERSİTESİ", "ATILIM ÜNİVERSİTESİ", "TÜRK HAVA KURUMU ÜNİVERSİTESİ", "BİRUNİ ÜNİVERSİTESİ", "BEZM-İ ÂLEM VAKIF ÜNİVERSİTESİ", "ESKİŞEHİR TEKNİK ÜNİVERSİTESİ", "GAZİ ÜNİVERSİTESİ", "DOKUZ EYLÜL ÜNİVERSİTESİ", "KTO KARATAY ÜNİVERSİTESİ", "ANKARA MEDİPOL ÜNİVERSİTESİ", "MALTEPE ÜNİVERSİTESİ", "İZMİR EKONOMİ ÜNİVERSİTESİ", "ESKİŞEHİR OSMANGAZİ ÜNİVERSİTESİ", "BURSA ULUDAĞ ÜNİVERSİTESİ", "İSTANBUL OKAN ÜNİVERSİTESİ", "İZMİR KATİP ÇELEBİ ÜNİVERSİTESİ", "UFUK ÜNİVERSİTESİ", "KOCAELİ ÜNİVERSİTESİ", "LOKMAN HEKİM ÜNİVERSİTESİ", "İSTANBUL AYDIN ÜNİVERSİTESİ", "YÜKSEK İHTİSAS ÜNİVERSİTESİ", "SELÇUK ÜNİVERSİTESİ", "YILDIZ TEKNİK ÜNİVERSİTESİ", "ONDOKUZ MAYIS ÜNİVERSİTESİ", "MERSİN ÜNİVERSİTESİ", "MANİSA CELÂL BAYAR ÜNİVERSİTESİ", "ÇANAKKALE ONSEKİZ MART ÜNİVERSİTESİ", "ÇUKUROVA ÜNİVERSİTESİ", "DEMİROĞLU BİLİM ÜNİVERSİTESİ", "ÜSKÜDAR ÜNİVERSİTESİ", "İZMİR BAKIRÇAY ÜNİVERSİTESİ", "ERCİYES ÜNİVERSİTESİ", "GİRNE AMERİKAN ÜNİVERSİTESİ", "PAMUKKALE ÜNİVERSİTESİ", "TRAKYA ÜNİVERSİTESİ", "BANDIRMA ONYEDİ EYLÜL ÜNİVERSİTESİ", "NECMETTİN ERBAKAN ÜNİVERSİTESİ", "SAKARYA ÜNİVERSİTESİ", "AYDIN ADNAN MENDERES ÜNİVERSİTESİ", "İNÖNÜ ÜNİVERSİTESİ", "MUĞLA SITKI KOÇMAN ÜNİVERSİTESİ", "İSTANBUL YENİ YÜZYIL ÜNİVERSİTESİ", "ANTALYA BİLİM ÜNİVERSİTESİ", "İZMİR DEMOKRASİ ÜNİVERSİTESİ", "İZMİR TINAZTEPE ÜNİVERSİTESİ", "BEYKENT ÜNİVERSİTESİ", "KARADENİZ TEKNİK ÜNİVERSİTESİ", "TEKİRDAĞ NAMIK KEMAL ÜNİVERSİTESİ", "İSTANBUL ATLAS ÜNİVERSİTESİ", "ATATÜRK ÜNİVERSİTESİ", "DOĞU AKDENİZ ÜNİVERSİTESİ", "ALANYA ALAADDİN KEYKUBAT ÜNİVERSİTESİ", "GAZİANTEP ÜNİVERSİTESİ", "SÜLEYMAN DEMİREL ÜNİVERSİTESİ", "HALİÇ ÜNİVERSİTESİ", "GİRNE ÜNİVERSİTESİ", "AMASYA ÜNİVERSİTESİ", "İSTANBUL BİLGİ ÜNİVERSİTESİ", "BOLU ABANT İZZET BAYSAL ÜNİVERSİTESİ", "BALIKESİR ÜNİVERSİTESİ", "KIRIKKALE ÜNİVERSİTESİ", "KARAMANOĞLU MEHMETBEY ÜNİVERSİTESİ", "DİCLE ÜNİVERSİTESİ", "ALTINBAŞ ÜNİVERSİTESİ", "TÜRK-ALMAN ÜNİVERSİTESİ", "İSTANBUL SAĞLIK VE TEKNOLOJİ ÜNİVERSİTESİ", "DÜZCE ÜNİVERSİTESİ", "ZONGULDAK BÜLENT ECEVİT ÜNİVERSİTESİ", "SİVAS CUMHURİYET ÜNİVERSİTESİ", "HATAY MUSTAFA KEMAL ÜNİVERSİTESİ", "İZMİR YÜKSEK TEKNOLOJİ ENSTİTÜSÜ  ", "UŞAK ÜNİVERSİTESİ", "MALATYA TURGUT ÖZAL ÜNİVERSİTESİ", "KAHRAMANMARAŞ SÜTÇÜ İMAM ÜNİVERSİTESİ", "KARABÜK ÜNİVERSİTESİ", "RECEP TAYYİP ERDOĞAN ÜNİVERSİTESİ", "GİRESUN ÜNİVERSİTESİ", "NİĞDE ÖMER HALİSDEMİR ÜNİVERSİTESİ", "TOKAT GAZİOSMANPAŞA ÜNİVERSİTESİ", "AFYONKARAHİSAR SAĞLIK BİLİMLERİ ÜNİVERSİTESİ", "KIRKLARELİ ÜNİVERSİTESİ", "KÜTAHYA SAĞLIK BİLİMLERİ ÜNİVERSİTESİ", "ORDU ÜNİVERSİTESİ", "FIRAT ÜNİVERSİTESİ", "SANKO ÜNİVERSİTESİ", "AKSARAY ÜNİVERSİTESİ", "MEF ÜNİVERSİTESİ", "VAN YÜZÜNCÜ YIL ÜNİVERSİTESİ", "KIRŞEHİR AHİ EVRAN ÜNİVERSİTESİ", "HARRAN ÜNİVERSİTESİ", "HİTİT ÜNİVERSİTESİ", "YOZGAT BOZOK ÜNİVERSİTESİ", "KADİR HAS ÜNİVERSİTESİ", "SİİRT ÜNİVERSİTESİ", "KAFKAS ÜNİVERSİTESİ", "YAKIN DOĞU ÜNİVERSİTESİ", "KASTAMONU ÜNİVERSİTESİ", "AĞRI İBRAHİM ÇEÇEN ÜNİVERSİTESİ", "GEBZE TEKNİK ÜNİVERSİTESİ", "ADIYAMAN ÜNİVERSİTESİ", "ERZİNCAN BİNALİ YILDIRIM ÜNİVERSİTESİ", "NUH NACİ YAZGAN ÜNİVERSİTESİ", "AZERBAYCAN TIP ÜNİVERSİTESİ", "İSTANBUL KENT ÜNİVERSİTESİ", "KOCAELİ SAĞLIK VE TEKNOLOJİ ÜNİVERSİTESİ", "KAPADOKYA ÜNİVERSİTESİ", "İSTANBUL GELİŞİM ÜNİVERSİTESİ", "TED ÜNİVERSİTESİ", "ÇANKIRI KARATEKİN ÜNİVERSİTESİ", "İSTANBUL GALATA ÜNİVERSİTESİ", "BİNGÖL ÜNİVERSİTESİ", "YAŞAR ÜNİVERSİTESİ", "ÇANKAYA ÜNİVERSİTESİ", "KIBRIS SAĞLIK VE TOPLUM BİLİMLERİ ÜNİVERSİTESİ", "ADA KENT ÜNİVERSİTESİ", "LEFKE AVRUPA ÜNİVERSİTESİ", "İSTANBUL KÜLTÜR ÜNİVERSİTESİ", "ANADOLU ÜNİVERSİTESİ", "IŞIK ÜNİVERSİTESİ", "OSTİM TEKNİK ÜNİVERSİTESİ", "DOĞUŞ ÜNİVERSİTESİ", "HOCA AHMET YESEVİ ULUSLARARASI TÜRK-KAZAK ÜNİVERSİTESİ", "ABDULLAH GÜL ÜNİVERSİTESİ", "İSTANBUL SABAHATTİN ZAİM ÜNİVERSİTESİ", "ULUSLARARASI KIBRIS ÜNİVERSİTESİ", "İSTANBUL TİCARET ÜNİVERSİTESİ", "FATİH SULTAN MEHMET VAKIF ÜNİVERSİTESİ", "MİMAR SİNAN GÜZEL SANATLAR ÜNİVERSİTESİ", "SAMSUN ÜNİVERSİTESİ", "İSTANBUL AREL ÜNİVERSİTESİ", "ANKARA BİLİM ÜNİVERSİTESİ", "KONYA GIDA VE TARIM ÜNİVERSİTESİ", "BEYKOZ ÜNİVERSİTESİ", "PİRİ REİS ÜNİVERSİTESİ", "BURSA TEKNİK ÜNİVERSİTESİ", "İSTANBUL GEDİK ÜNİVERSİTESİ", "TRABZON ÜNİVERSİTESİ", "NİŞANTAŞI ÜNİVERSİTESİ", "FENERBAHÇE ÜNİVERSİTESİ", "AFYON KOCATEPE ÜNİVERSİTESİ", "İSTANBUL AYVANSARAY ÜNİVERSİTESİ", "NEVŞEHİR HACI BEKTAŞ VELİ ÜNİVERSİTESİ", "HASAN KALYONCU ÜNİVERSİTESİ", "KONYA TEKNİK ÜNİVERSİTESİ", "İSTANBUL RUMELİ ÜNİVERSİTESİ", "KÜTAHYA DUMLUPINAR ÜNİVERSİTESİ", "İSTANBUL ESENYURT ÜNİVERSİTESİ", "BURDUR MEHMET AKİF ERSOY ÜNİVERSİTESİ", "SAKARYA UYGULAMALI BİLİMLER ÜNİVERSİTESİ", "TOROS ÜNİVERSİTESİ", "SİNOP ÜNİVERSİTESİ", "MUŞ ALPARSLAN ÜNİVERSİTESİ", "BARTIN ÜNİVERSİTESİ", "YALOVA ÜNİVERSİTESİ", "ARTVİN ÇORUH ÜNİVERSİTESİ", "KİLİS 7 ARALIK ÜNİVERSİTESİ", "BAYBURT ÜNİVERSİTESİ", "ADANA ALPARSLAN TÜRKEŞ BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ", "AVRASYA ÜNİVERSİTESİ", "HAKKARİ ÜNİVERSİTESİ", "ALANYA HAMDULLAH EMİN PAŞA ÜNİVERSİTESİ", "MARDİN ARTUKLU ÜNİVERSİTESİ", "BATMAN ÜNİVERSİTESİ", "OSMANİYE KORKUT ATA ÜNİVERSİTESİ", "GAZİANTEP İSLAM BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ", "BİLECİK ŞEYH EDEBALİ ÜNİVERSİTESİ", "TARSUS ÜNİVERSİTESİ", "MUNZUR ÜNİVERSİTESİ", "ISPARTA UYGULAMALI BİLİMLER ÜNİVERSİTESİ", "BİTLİS EREN ÜNİVERSİTESİ", "İSKENDERUN TEKNİK ÜNİVERSİTESİ", "GÜMÜŞHANE ÜNİVERSİTESİ", "IĞDIR ÜNİVERSİTESİ", "KIRGIZİSTAN-TÜRKİYE MANAS ÜNİVERSİTESİ", "KIBRIS İLİM ÜNİVERSİTESİ", "ERZURUM TEKNİK ÜNİVERSİTESİ", "ULUSLARARASI FİNAL ÜNİVERSİTESİ", "ANKARA HACI BAYRAM VELİ ÜNİVERSİTESİ", "ARDAHAN ÜNİVERSİTESİ", "ŞIRNAK ÜNİVERSİTESİ", "ARKIN YARATICI SANATLAR VE TASARIM ÜNİVERSİTESİ", "BAHÇEŞEHİR KIBRIS ÜNİVERSİTESİ", "KIBRIS AMERİKAN ÜNİVERSİTESİ", "KIBRIS BATI ÜNİVERSİTESİ", "RAUF DENKTAŞ ÜNİVERSİTESİ", "ULUSLARARASI SARAYBOSNA ÜNİVERSİTESİ", "ULUSLARARASI BALKAN ÜNİVERSİTESİ", "HOCA AHMET YESEVİ ULUSLARARASI TÜRKKAZAK ÜNİVERSİTESİ", "ANKARA SOSYAL BİLİMLER ÜNİVERSİTESİ", "İBN HALDUN ÜNİVERSİTESİ", "İSTANBUL 29 MAYIS ÜNİVERSİTESİ", "ÇAĞ ÜNİVERSİTESİ", "ANTALYA AKEV ÜNİVERSİTESİ", "KAYSERİ ÜNİVERSİTESİ", "AKDENİZ KARPAZ ÜNİVERSİTESİ", "AZERBAYCAN DEVLET PEDAGOJİ ÜNİVERSİTESİ", "AZERBAYCAN DİLLER ÜNİVERSİTESİ", "TOKAT GAZİOSMANPAŞA ", "KIRGIZİSTANTÜRKİYE MANAS ÜNİVERSİTESİ", "BAKÜ DEVLET ÜNİVERSİTESİ", "KAHRAMANMARAŞ İSTİKLAL ÜNİVERSİTESİ", "KOMRAT DEVLET ÜNİVERSİTESİ"};
        String[] departments = { "Tıp",  "Bilgisayar Mühendisliği",  "Elektrik-Elektronik Mühendisliği",  "Endüstri Mühendisliği",  "Mühendislik ve Doğa Bilimleri Programları",  "Matematik",  "Pilotaj (Fakülte)",  "Kimya-Biyoloji Mühendisliği",  "Makine Mühendisliği",  "Kimya",  "Fizik",  "Moleküler Biyoloji ve Genetik",  "Elektronik ve Haberleşme Mühendisliği",  "Yapay Zeka Mühendisliği",  "Yapay Zeka ve Veri Mühendisliği",  "Pilotaj (Yüksekokul)",  "Diş Hekimliği",  "Havacılık ve Uzay Mühendisliği",  "Uçak Mühendisliği",  "Uluslararası Tıp",  "Kimya Mühendisliği",  "Kontrol ve Otomasyon Mühendisliği",  "Mimarlık",  "Yazılım Mühendisliği",  "Uzay Mühendisliği",  "Elektrik Mühendisliği",  "İşletme Mühendisliği",  "Metalurji ve Malzeme Mühendisliği",  "Matematik Mühendisliği",  "İnşaat Mühendisliği",  "Eczacılık",  "Malzeme Bilimi ve Nanoteknoloji Mühendisliği",  "Mekatronik Mühendisliği",  "Bilişim Sistemleri ve Teknolojileri (Yüksekokul)",  "Biyomedikal Mühendisliği",  "Mühendislik Programları",  "Dijital Oyun Tasarımı",  "Matematik Öğretmenliği",  "Deniz Ulaştırma İşletme Mühendisliği (Fakülte)",  "Tıp Mühendisliği",  "Enerji Sistemleri Mühendisliği",  "Gemi İnşaatı ve Gemi Makineleri Mühendisliği",  "İlköğretim Matematik Öğretmenliği",  "Dil ve Konuşma Terapisi (Fakülte)",  "Endüstriyel Tasarım (Fakülte)",  "Gıda Mühendisliği",  "Fizik Mühendisliği",  "Genetik ve Biyomühendislik",  "Biyoloji",  "Tekstil Mühendisliği",  "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği",  "Veterinerlik",  "Elektronik Mühendisliği",  "İstatistik",  "Beslenme ve Diyetetik (Fakülte)",  "Çevre Mühendisliği",  "Fizik Öğretmenliği",  "Yazılım Geliştirme",  "Fizyoterapi ve Rehabilitasyon (Fakülte)",  "Kimya Öğretmenliği",  "Tasarım ve Mimarlık Fakültesi",  "Bilişim Sistemleri ve Teknolojileri (Fakülte)",  "Moleküler Biyoteknoloji",  "Hemşirelik (Fakülte)",  "Petrol ve Doğalgaz Mühendisliği",  "Bilgi Güvenliği Teknolojisi (Fakülte)",  "İç Mimarlık",  "Dil ve Konuşma Terapisi (Yüksekokul)",  "Havacılık Elektrik ve Elektroniği (Fakülte)",  "Kentsel Tasarım ve Peyzaj Mimarlığı",  "Bilişim Sistemleri Mühendisliği",  "Gemi Makineleri İşletme Mühendisliği (Fakülte)",  "Uçak Gövde ve Motor Bakımı (Fakülte)",  "Maden Mühendisliği",  "Odyoloji (Fakülte)",  "Jeoloji Mühendisliği",  "Uçak Gövde ve Motor Bakımı (Yüksekokul)",  "Otomotiv Mühendisliği",  "Biyoenformatik ve Genetik",  "Biyomühendislik",  "Malzeme Bilimi ve Teknolojileri",  "Gemi ve Deniz Teknolojisi Mühendisliği",  "Adli Bilimler",  "Geomatik Mühendisliği",  "Fen Bilgisi Öğretmenliği",  "Şehir ve Bölge Planlama",  "Nükleer Enerji Mühendisliği",  "Beslenme ve Diyetetik (Yüksekokul)",  "Meteoroloji Mühendisliği",  "Uçak Elektrik ve Elektroniği",  "Genetik ve Yaşam Bilimleri Programları",  "Hemşirelik (Yüksekokul)",  "Ergoterapi (Fakülte)",  "Peyzaj Mimarlığı",  "Enerji Mühendisliği",  "Malzeme Bilimi ve Mühendisliği",  "Fizyoterapi ve Rehabilitasyon (Yüksekokul)",  "Bilgisayar Mühendisliği (M.T.O.K.)",  "Odyoloji (Yüksekokul)",  "Matematik ve Bilgisayar Bilimleri",  "Jeofizik Mühendisliği",  "Uçak Bakım ve Onarım (Yüksekokul)",  "Cevher Hazırlama Mühendisliği",  "Perfüzyon (Fakülte)",  "Harita Mühendisliği",  "Biyokimya",  "Elektrik-Elektronik Mühendisliği (M.T.O.K.)",  "Makine Mühendisliği (M.T.O.K.)",  "Gemi ve Yat Tasarımı",  "Ebelik (Fakülte)",  "Bilgisayar Bilimleri",  "Ebelik (Yüksekokul)",  "Havacılık Elektrik ve Elektroniği (Yüksekokul)",  "Perfüzyon (Yüksekokul)",  "Uzay ve Uydu Mühendisliği",  "Mekatronik Mühendisliği (M.T.O.K.)",  "Uçak Bakım ve Onarım (Fakülte)",  "Tekstil Mühendisliği (M.T.O.K.)",  "Endüstriyel Tasarım M��hendisliği",  "Bitki Koruma",  "Biyoloji Öğretmenliği",  "Güzel Sanatlar ve Tasarım Fakültesi",  "Ortez ve Protez",  "Mimarlık ve Tasarım Fakültesi",  "Adli Bilişim Mühendisliği",  "Yazılım Mühendisliği (M.T.O.K.)",  "Ergoterapi (Yüksekokul)",  "İş Sağlığı ve Güvenliği (Fakülte)",  "Fotonik",  "İmalat Mühendisliği",  "Biyomedikal Mühendisliği (M.T.O.K.)",  "Bahçe Bitkileri",  "Otomotiv Mühendisliği (M.T.O.K.)",  "Deri Mühendisliği",  "Metalurji ve Malzeme Mühendisliği (M.T.O.K.)",  "İnşaat Mühendisliği (M.T.O.K.)",  "Acil Yardım ve Afet Yönetimi (Fakülte)",  "Astronomi ve Uzay Bilimleri",  "Bilişim Sistemleri Mühendisliği (M.T.O.K.)",  "Enerji Sistemleri Mühendisliği (M.T.O.K.)",  "Bilgisayar Teknolojisi ve Bilişim Sistemleri",  "Tarımsal Genetik Mühendisliği",  "Aktüerya Bilimleri (Fakülte)",  "Orman Mühendisliği",  "Aktüerya Bilimleri (Yüksekokul)",  "Tarım Makineleri ve Teknolojileri Mühendisliği",  "Tarla Bitkileri",  "Su Bilimleri ve Mühendisliği",  "Uzay Bilimleri ve Teknolojileri",  "İstatistik ve Bilgisayar Bilimleri",  "Biyosistem Mühendisliği",  "Zootekni",  "Toprak Bilimi ve Bitki Besleme",  "Ağaç İşleri Endüstri Mühendisliği",  "Gerontoloji",  "Acil Yardım ve Afet Yönetimi (Yüksekokul)",  "Ziraat Mühendisliği Programları",  "Biyoteknoloji",  "Tarımsal Biyoteknoloji",  "Orman Endüstrisi Mühendisliği",  "Su Ürünleri Mühendisliği",  "Nanobilim ve Nanoteknoloji",  "Tarımsal Yapılar ve Sulama",  "Gıda Teknolojisi (Fakülte)",  "İş Sağlığı ve Güvenliği (Yüksekokul)",  "Bitkisel Üretim ve Teknolojileri",  "Hayvansal Üretim ve Teknolojileri",  "Basım Teknolojileri",  "Bilgi Güvenliği Teknolojisi (Yüksekokul)",  "İş Sağlığı ve Güvenliği (Açıköğretim)",  "Endüstriyel Tasarım (Yüksekokul)",  "Süt Teknolojisi",  "Tohum Bilimi ve Teknolojisi",  "Kanatlı Hayvan Yetiştiriciliği",  "Tasarım ve Güzel Sanatlar Fakültesi",  "Yaban Hayatı Ekolojisi ve Yönetimi",  "Tütün Eksperliği",  "Optik ve Akustik Mühendisliği",  "Balıkçılık Teknolojisi Mühendisliği",  "Polimer Malzeme Mühendisliği",  "Adli Bilişim Mühendisliği (M.T.O.K.)",  "Endüstriyel Tasarım Mühendisliği (M.T.O.K.)",  "Gıda Teknolojisi (Yüksekokul)",  "Hidrojeoloji Mühendisliği",  "Raylı Sistemler Mühendisliği",  "Elektronik ve Haberleşme Mühendisliği (M.T.O.K.)",  "Deniz Bilimleri ve Teknolojisi Mühendisliği",  "Nanoteknoloji Mühendisliği",  "ElektrikElektronik Mühendisliği",  "Deniz Ulaştırma İşletme Mühendisliği (Yüksekokul)",  "Gemi Makineleri İşletme Mühendisliği (Yüksekokul)",  "İlahiyat",  "Tarih",  "Arkeoloji ve Sanat Tarihi",  "Gastronomi ve Mutfak Sanatları (Yüksekokul)",  "Türk Dili ve Edebiyatı",  "Gazetecilik",  "İslami İlimler",  "Radyo",  "İletişim ve Tasarımı",  "Sanat ve Kültür Yönetimi",  "Sinema ve Televizyon",  "Reklam Tasarımı ve İletişimi",  "Yeni Medya ve İletişim",  "Türkçe Öğretmenliği",  "Özel Eğitim Öğretmenliği",  "Yeni Medya (Fakülte)",  "Görsel İletişim Tasarımı",  "Gastronomi ve Mutfak Sanatları (Fakülte)",  "Medya ve Görsel Sanatlar",  "İletişim",  "Halkla İlişkiler ve Tanıtım",  "Fotoğraf",  "Okul Öncesi Öğretmenliği",  "Reklamcılık",  "İletişim Tasarımı ve Yönetimi",  "Türk Dili ve Edebiyatı Öğretmenliği",  "Sinema ve Dijital Medya",  "Kültür ve İletişim Bilimleri",  "Televizyon Haberciliği ve Programcılığı (Fakülte)",  "Çizgi Film ve Animasyon",  "Halkla İlişkiler ve Reklamcılık (Fakülte)",  "İdari ve Sosyal Bilimler Fakültesi",  "Tarih Öğretmenliği",  "Film Tasarımı ve Yönetimi",  "Coğrafya Öğretmenliği",  "Tiyatro Eleştirmenliği ve Dramaturji",  "Sosyal Bilgiler Öğretmenliği",  "Sanat Tarihi",  "İletişim Bilimleri",  "Fotoğraf ve Video",  "Coğrafya",  "Film Tasarımı ve Yönetmenliği",  "Medya ve İletişim",  "Film Tasarımı ve Yazarlığı",  "Kurgu",  "Gastronomi ve Mutfak Sanatları (Fakülte) (M.T.O.K.)",  "Çağdaş Türk Lehçeleri ve Edebiyatları",  "Halkla İlişkiler ve Reklamcılık (Yüksekokul)",  "Basın ve Yayın",  "Televizyon Haberciliği ve Programcılığı (Yüksekokul)",  "İletişim Sanatları",  "Türk Halkbilimi",  "Rekreasyon Yönetimi (Fakülte)",  "Halkbilimi",  "Kürt Dili ve Edebiyatı",  "Sümeroloji",  "Görsel Sanatlar (M.T.O.K.)",  "El Sanatları",  "Türkoloji",  "Rekreasyon Yönetimi (Fakülte) (M.T.O.K.)",  "Rekreasyon Yönetimi (Yüksekokul)",  "Yeni Medya (Yüksekokul)",  "Halkla İlişkiler ve Reklamcılık (Açıköğretim)",  "Tarih (Açıköğretim)",  "Gürcü Dili ve Edebiyatı",  "İslam Bilimleri",  "Kazak Dili ve Edebiyatı",  "Geleneksel Türk Sanatları (M.T.O.K.)",  "El Sanatları (M.T.O.K.)",  "Çerkez Dili ve Kültürü",  "Azerbaycan Türkçesi ve Edebiyatı",  "Coğrafya (Açıköğretim)",  "Halkla İlişkiler ve Tanıtım (Açıköğretim)",  "Görsel Sanatlar ve İletişim Tasarımı",  "Halkla İlişkiler",  "Görsel Sanatlar",  "Türk Dili ve Edebiyatı (Açıköğretim)",  "Zaza Dili ve Edebiyatı",  "Reklamcılık (Açıköğretim)",  "Süryani Dili ve Edebiyatı",  "Karşılaştırmalı Edebiyat",  "İngilizce",  "Dilbilimi",  "İngilizce Öğretmenliği",  "Çeviribilimi",  "İngilizce Mütercim ve Tercümanlık (Fakülte)",  "Çince Mütercim ve Tercümanlık",  "Arapça Öğretmenliği",  "Rusça Mütercim ve Tercümanlık (Fakülte)",  "İngiliz Dili ve Edebiyatı",  "Fransız Dili ve Edebiyatı",  "Amerikan Kültürü ve Edebiyatı",  "Arapça Mütercim ve Tercümanlık (Fakülte)",  "İngiliz Dilbilimi",  "İngilizce Mütercim ve Tercümanlık (Yüksekokul)",  "Fransızca Mütercim ve Tercümanlık",  "Almanca Mütercim ve Tercümanlık (Fakülte)",  "Rus Dili ve Edebiyatı",  "İspanyol Dili ve Edebiyatı",  "Kore Dili ve Edebiyatı",  "Çin Dili ve Edebiyatı",  "Japon Dili ve Edebiyatı",  "Turizm Rehberliği (Yüksekokul)",  "Sinoloji",  "Japonca Öğretmenliği",  "İtalyan Dili ve Edebiyatı",  "Arapça Mütercim ve Tercümanlık (Yüksekokul)",  "Alman Dili ve Edebiyatı",  "Arap Dili ve Edebiyatı",  "Rusça Mütercim ve Tercümanlık (Yüksekokul)",  "Almanca Öğretmenliği",  "Fransızca Öğretmenliği",  "Latin Dili ve Edebiyatı",  "Turizm Rehberliği (Fakülte)",  "Ukrayna Dili ve Edebiyatı",  "Çağdaş Yunan Dili ve Edebiyatı",  "Leh Dili ve Edebiyatı",  "Eski Yunan Dili ve Edebiyatı",  "Yunan Dili ve Edebiyatı",  "Fars Dili ve Edebiyatı",  "Doğu Dilleri",  "Hititoloji",  "Almanca Mütercim ve Tercümanlık (Yüksekokul)",  "Ermeni Dili ve Kültürü",  "İbrani Dili ve Kültürü",  "Urdu Dili ve Edebiyatı",  "Farsça Mütercim ve Tercümanlık",  "Arnavut Dili ve Edebiyatı",  "Boşnak Dili ve Edebiyatı",  "Bulgarca Mü",  "Rus Dili ve Edebiyatı Öğretmenliği",  "Mütercim-Tercümanlık",  "İngiliz ve Rus Dilleri ve Edebiyatları",  "Hukuk",  "İşletme",  "Sanat ve Sosyal Bilimler Programları",  "Uluslararası İlişkiler",  "Siyaset Bilimi ve Uluslararası İlişkiler",  "Psikoloji",  "Sosyoloji",  "Yönetim Bilişim Sistemleri (Yüksekokul)",  "İktisat",  "Uluslararası Ticaret ve İşletmecilik (Fakülte)",  "Felsefe",  "Siyaset Bilimi",  "Ekonomi",  "Yönetim Bilimleri Programları",  "Yönetim Bilişim Sistemleri (Fakülte)",  "Uluslararası Girişimcilik",  "Uluslararası Finans",  "Uluslararası Ticaret (Yüksekokul)",  "Girişimcilik",  "Grafik Tasarımı",  "Siyaset Bilimi ve Kamu Yönetimi",  "Rehberlik ve Psikolojik Danışmanlık",  "Turizm İşletmeciliği (Yüksekokul)",  "Ekonomi ve Finans",  "İç Mimarlık ve Çevre Tasarımı",  "Elektronik Ticaret ve Yönetimi",  "Turizm ve Otel İşletmeciliği",  "Pazarlama (Fakülte)",  "Arkeoloji",  "Otel Yöneticiliği",  "Uluslararası Ticaret ve Finansman (Fakülte)",  "Küresel Siyaset ve Uluslararası İlişkiler",  "Lojistik Yönetimi (Fakülte)",  "Havacılık Yönetimi (Fakülte)",  "Uluslararası İşletme Yönetimi",  "Sınıf Öğretmenliği",  "Turizm İşletmeciliği (Fakülte)",  "Politika ve Ekonomi",  "Lojistik Yönetimi (Yüksekokul)",  "Kamu Yönetimi",  "Havacılık Yönetimi (Yüksekokul)",  "İktisadi ve İdari Bilimler Programları",  "İnsan Kaynakları Yönetimi (Yüksekokul)",  "Muhasebe ve Denetim",  "Tarım Ticareti ve İşletmeciliği",  "Maliye",  "Uluslararası Ulaştırma Sistemleri",  "Gayrimenkul Geliştirme ve Yönetimi (Yüksekokul)",  "Sosyal Hizmet (Fakülte)",  "Tekstil ve Moda Tasarımı (Fakülte)",  "Sağlık Yönetimi (Fakülte)",  "Çocuk Gelişimi (Fakülte)",  "Denizcilik İşletmeleri Yönetimi",  "Antropoloji",  "Uluslararası Ticaret (Fakülte)",  "Gümrük İşletme",  "Beden Eğitimi ve Spor Öğretmenliği (Fakülte)",  "Uluslararası Ticaret ve Lojistik (Fakülte)",  "Çalışma Ekonomisi ve Endüstri İlişkileri",  "Çocuk Gelişimi (Yüksekokul)",  "İktisadi ve İdari Programlar",  "İslam İktisadı ve Finans",  "Finans ve Bankacılık (Fakülte)",  "Beden Eğitimi ve Spor Öğretmenliği (Yüksekokul)",  "İnsan Kaynakları Yönetimi (Fakülte)",  "Teknoloji ve Bilgi Yönetimi",  "Tapu Kadastro",  "Felsefe Grubu Öğretmenliği",  "Muhasebe ve Finans Yönetimi (Fakülte)",  "Enerji Yönetimi",  "Sosyal Hizmet (Yüksekokul)",  "Bankacılık ve Sigortacılık (Fakülte)",  "Ekonometri",  "Sağlık Yönetimi (Yüksekokul)",  "Antrenörlük Eğitimi (Fakülte)",  "Bankacılık",  "Sermaye Piyasası (Fakülte)",  "Kültür Varlıklarını Koruma ve Onarım",  "Spor Yöneticiliği (Yüksekokul)",  "Spor Yöneticiliği (Fakülte)",  "Bilgi ve Belge Yönetimi",  "Sigortacılık (Fakülte)",  "Yerel Yönetimler",  "Tarım Ekonomisi",  "Sigortacılık (Yüksekokul)",  "Sermaye Piyasası (Yüksekokul)",  "Bankacılık ve Sigortacılık (Yüksekokul)",  "Uluslararası Finans ve Bankacılık",  "Moda Tasarımı (Yüksekokul)",  "Klasik Arkeoloji",  "Moda Tasarımı (Fakülte)",  "Finans ve Bankacılık (Yüksekokul)",  "Grafik Tasarımı (M.T.O.K.)",  "Sosyal Hizmet (Açıköğretim)",  "Aile ve Tüketici Bilimleri",  "Bilim Tarihi",  "Uluslararası Ticaret ve İşletmecilik (Yüksekokul)",  "Kuyumculuk ve Mücevher Tasarımı (Yüksekokul)",  "Tarih Öncesi Arkeolojisi",  "Siyasal Bilimler",  "Rekreasyon (Fakülte)",  "Protohistorya ve Ön Asya Arkeolojisi",  "Gayrimenkul Geliştirme ve Yönetimi (Fakülte)",  "Sigortacılık ve Sosyal Güvenlik",  "Egzersiz ve Spor Bilimleri",  "Antrenörlük Eğitimi (Yüksekokul)",  "Spor Yöneticiliği",  "Grafik",  "Moda Tasarımı (Fakülte) (M.T.O.K.)",  "Çocuk Gelişimi (Açıköğretim)",  "Tekstil Tasarımı",  "Uluslararası Ticaret ve Lojistik (Açıköğretim)",  "İnsan Kaynakları Yönetimi (Açıköğretim)",  "Uluslararası Ticaret ve Lojistik (Yüksekokul)",  "Sosyoloji (Açıköğretim)",  "İşletme (Açıköğretim)",  "Seyahat İşletmeciliği ve Turizm Rehberliği",  "Kuyumculuk ve Mücevher Tasarımı (Fakülte)",  "Müzecilik",  "Siyaset Bilimi ve Uluslararası İlişkiler (Açıköğretim)",  "Yönetim Bilişim Sistemleri (Açıköğretim)",  "Muhasebe ve Finans Yönetimi (Yüksekokul)",  "Yiyecek ve İçecek İşletmeciliği",  "Sağlık Yönetimi (Açıköğretim)",  "Siyaset Bilimi ve Kamu Yönetimi (Açıköğretim)",  "Takı Tasarımı",  "İktisat (Açıköğretim)",  "Uluslararası Ticaret ve Finansman (Yüksekokul)",  "Uluslararası Ticaret ve Finans",  "Rekreasyon (Yüksekokul)",  "Tekstil Tasarımı (M.T.O.K.)",  "Seyahat İşletmeciliği",  "Organik Tarım İşletmeciliği",  "Türk İslam Arkeolojisi",  "Maliye (Açıköğretim)",  "Felsefe (Açıköğretim)",  "Uluslararası İlişkiler (Açıköğretim)",  "Sigortacılık ve Risk Yönetimi",  "Havacılık Yönetimi (Açıköğretim)",  "Kamu Yönetimi (Açıköğretim)",  "Çalışma Ekonomisi ve Endüstri İlişkileri (Açıköğretim)",  "Uluslararası Ekonomik İlişkiler",  "Sigortacılık ve Aktüerya Bilimleri",  "Pazarlama (Yüksekokul)",  "Psikolojik Danışmanlık ve İşitme Engelliler Fakültesi",  "Sosyal ve Siyasal Bilimler",  "Psikolojik Danışmanlık ve Rehberlik",  "Bankacılık ve Finans",  "Grafik Sanatlar (Açıköğretim)",  "Tekstil ve Moda Tasarımı (Açıköğretim)",  "Egzersiz ve Spor Bilimleri (Açıköğretim)",  "Rekreasyon (Açıköğretim)",  "Tekstil ve Moda Tasarımı (Yüksekokul)",  "Ayakkabı Tasarımı ve Üretimi", "Acil Durum ve Afet Yönetimi","Adalet","Alternatif Enerji Kaynakları Teknolojisi","Ambalaj Tasarımı","Ameliyathane Hizmetleri","Anestezi","Atçılık ve Antrenörlüğü","Atık Yönetimi","Avcılık ve Yaban Hayatı","Ayakkabı Tasarım ve Üretimi","Ağız ve Diş Sağlığı","Aşçılık","Bahçe Tarımı","Bankacılık ve Sigortacılık","Basım ve Yayım Teknolojileri","Bağcılık","Bilgi Yönetimi","Bilgisayar Destekli Tasarım ve Animasyon","Bilgisayar Operatörlüğü","Bilgisayar Programcılığı","Bilgisayar Teknolojisi","Bilişim Güvenliği Teknolojisi","Bitki Koruma","Biyokimya","Biyomedikal Cihaz Teknolojisi","Boya Teknolojisi","Büro Yönetimi ve Yönetici Asistanlığı","Ceza İnfaz ve Güvenlik Hizmetleri","Coğrafi Bilgi Sistemleri","Deniz Brokerliği","Deniz Ulaştırma ve İşletme","Deniz ve Liman İşletmeciliği","Deri Konfeksiyon","Dezenfeksiyon","Dijital Fabrika Teknolojileri","Diyaliz","Diş Protez Teknolojisi","Doğal Yapı Taşları Teknolojisi","Doğalgaz ve Tesisatı Teknolojisi","Döküm","Dış Ticaret","E-Ticaret ve Pazarlama","Eczane Hizmetleri","Elektrik","Elektrik Enerjisi Üretim","Elektrikli Cihaz Teknolojisi","Elektronik Haberleşme Teknolojisi","Elektronik Teknolojisi","Elektronörofizyoloji","Emlak Yönetimi","Endüstri Ürünleri Tasarımı","Endüstriyel Cam ve Seramik","Endüstriyel Hammaddeler İşleme Teknolojisi","Endüstriyel Kalıpçılık","Enerji Tesisleri İşletmeciliği","Engelli Bakımı ve Rehabilitasyon","Engelliler İçin Gölge Öğreticilik","Eser Koruma","Et ve Ürünleri Teknolojisi","Ev İdaresi","Evde Hasta Bakımı","Fidan Yetiştiriciliği","Fizyoterapi","Fotoğrafçılık ve Kameramanlık","Fındık Eksperliği","Geleneksel El Sanatları","Gemi Makineleri İşletmeciliği","Gemi İnşaatı","Giyim Üretim Teknolojisi","Grafik Tasarımı","Gıda Kalite Kontrolü ve Analizi","Gıda Teknolojisi","Halkla İlişkiler ve Tanıtım","Halıcılık ve Kilimcilik","Harita ve Kadastro","Hasta Bakımı","Hava Lojistiği","Hibrid ve Elektrikli Taşıtlar Teknolojisi","Hukuk Büro Yönetimi ve Sekreterliği","Kaynak Teknolojisi","Kimya Teknolojisi","Kontrol ve Otomasyon Teknolojisi","Kooperatifçilik","Kozmetik Teknolojisi","Kuyumculuk ve Takı Tasarımı","Kültürel Miras ve Turizm","Kümes Hayvanları Yetiştiriciliği","Laborant ve Veteriner Sağlık","Laboratuvar Teknolojisi","Lojistik","Madencilik Teknolojisi","Makine","Makine Resim ve Konstrüksiyonu","Maliye","Mantarcılık","Marina ve Yat İşletmeciliği","Marka İletişimi","Medya ve İletişim","Mekatronik","Menkul Kıymetler ve Sermaye Piyasası","Mermer Teknolojisi","Metalurji","Meyve ve Sebze İşleme Teknolojisi","Mimari Dekoratif Sanatlar","Mimari Restorasyon","Mobil Teknolojileri","Mobilya ve Dekorasyon","Moda Tasarımı","Muhasebe ve Vergi Uygulamaları","Nüfus ve Vatandaşlık","Nükleer Teknoloji ve Radyasyon Güvenliği","Nükleer Tıp Teknikleri","Odyometri","Optisyenlik","Organik Tarım","Ormancılık ve Orman Ürünleri","Ortopedik Protez ve Ortez","Otobüs Kaptanlığı","Otomotiv Gövde ve Yüzey İşlem Teknolojileri","Otomotiv Teknolojisi","Pastacılık ve Ekmekçilik","Patoloji Laboratuvar Teknikleri","Pazarlama","Perakende Satış ve Mağaza Yönetimi","Peyzaj ve Süs Bitkileri Yetiştiriciliği","Podoloji","Polimer Teknolojisi","Posta Hizmetleri","Radyo ve Televizyon Programcılığı","Radyo ve Televizyon Teknolojisi","Radyoterapi","Rafineri ve Petro-Kimya Teknolojisi","Raylı Sistemler Elektrik ve Elektronik","Raylı Sistemler Makine Teknolojisi","Raylı Sistemler Makinistliği","Raylı Sistemler Yol Teknolojisi","Raylı Sistemler İşletmeciliği","Reklamcılık","Sahne Işık ve Ses Teknolojileri","Sahne ve Dekor Tasarımı","Saç Bakımı ve Güzellik Hizmetleri","Sağlık Bilgi Sistemleri Teknikerliği","Sağlık Kurumları İşletmeciliği","Sağlık Turizmi İşletmeciliği","Seracılık","Seramik ve Cam Tasarımı","Sivil Hava Ulaştırma İşletmeciliği","Sivil Havacılık Kabin Hizmetleri","Sivil Savunma ve İtfaiyecilik","Sondaj Teknolojisi","Sosyal Güvenlik","Sosyal Hizmetler","Sosyal Medya Yöneticiliği","Spor Yönetimi","Su Altı Teknolojisi","Su Ürünleri İşleme Teknolojisi","Sulama Teknolojisi","Süt ve Besi Hayvancılığı","Süt ve Ürünleri Teknolojisi","Tahribatsız Muayene","Tapu ve Kadastro","Tarla Bitkileri","Tarım Makineleri","Tarım ve Hayvancılık Meslek Yüksekokulu","Tarımsal İşletmecilik","Tekstil Teknolojisi","Tekstil ve Halı Makineleri","Tohumculuk Teknolojisi","Turist Rehberliği","Turizm Animasyonu","Turizm ve Otel İşletmeciliği","Turizm ve Seyahat Hizmetleri","Tıbbi Dokümantasyon ve Sekreterlik","Tıbbi Görüntüleme Teknikleri","Tıbbi Laboratuvar Teknikleri","Tıbbi Tanıtım ve Pazarlama","Tıbbi ve Aromatik Bitkiler","Ulaştırma ve Trafik Hizmetleri", "Un ve Unlu Mamuller Teknolojisi", "Uygulamalı Rusça Çevirmenlik", "Uygulamalı İngilizce Çevirmenlik", "Uygulamalı İspanyolca Çevirmenlik", "Uçak Teknolojisi", "Uçuş Harekat Yöneticiliği", "Web Tasarımı ve Kodlama", "Yapı Denetimi", "Yapı Tesisat Teknolojisi", "Yat Kaptanlığı", "Yağ Endüstrisi", "Yaşlı Bakımı", "Yeni Medya ve Gazetecilik", "Yerel Yönetimler", "Zeytincilik ve Zeytin İşleme Teknolojisi", "Çay Tarımı ve İşleme Teknolojisi", "Çağrı Merkezi Hizmetleri", "Çevre Koruma ve Kontrol", "Çevre Sağlığı", "Çevre Temizliği ve Denetimi", "Çim Alan Tesisi ve Yönetimi", "Çini Sanatı ve Tasarımı", "Çocuk Gelişimi", "Çocuk Koruma ve Bakım Hizmetleri", "Çok Boyutlu Modelleme ve Animasyon", "Özel Güvenlik ve Koruma", "Üretimde Kalite Kontrol", "İklimlendirme ve Soğutma Teknolojisi", "İkram Hizmetleri", "İlahiyat", "İlk ve Acil Yardım", "İnsan Kaynakları Yönetimi", "İnsansız Hava Aracı Teknolojisi ve Operatörlüğü", "İnternet ve Ağ Teknolojileri", "İnşaat Teknolojisi", "İslami İlimler", "İç Mekan Tasarımı", "İş Makineleri Operatörlüğü", "İş Sağlığı ve Güvenliği", "İş ve Uğraşı Terapisi", "İşletme Yönetimi", "Şarap Üretim Teknolojisi",
        };

        //Creating the instance of ArrayAdapter containing list of city names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,cities);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,universities);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,departments);
        //Getting the instance of AutoCompleteTextView


        multiAutoCompleteTextViewCity.setThreshold(1);//will start working from first character
        multiAutoCompleteTextViewCity.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        multiAutoCompleteTextViewCity.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        multiAutoCompleteTextViewUniversity.setThreshold(1);//will start working from first character
        multiAutoCompleteTextViewUniversity.setAdapter(adapter2);//setting the adapter data into the AutoCompleteTextView
        multiAutoCompleteTextViewUniversity.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        multiAutoCompleteTextViewDepartment.setThreshold(1);//will start working from first character
        multiAutoCompleteTextViewDepartment.setAdapter(adapter3);//setting the adapter data into the AutoCompleteTextView
        multiAutoCompleteTextViewDepartment.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }


    private void initViews() {
        btnTypeOfPoint = findViewById(R.id.btnTypeOfPoint);
        btnTypeofUniversity = findViewById(R.id.btnTypeofUniversty);
        btnTypeOfDepartment = findViewById(R.id.btnTypeOfDepartment);
        btnLanguage = findViewById(R.id.btnLanguage);
        btnShowResults = findViewById(R.id.btnShowResults);

        txtInputEditTextMinPoint = findViewById(R.id.txtInputEditTextMinPoint);
        txtInputEditTextMaxPoint = findViewById(R.id.txtInputEditTextMaxPoint);
        txtInputEditTextMinPlacementRanking = findViewById(R.id.txtInputEditTextMinPlacementRanking);
        txtInputEditTextMaxPlacementRanking = findViewById(R.id.txtInputEditTextMaxPlacementRanking);

        checkBoxAssociateDegree = findViewById(R.id.checkBoxAssociateDegree);
        checkBoxDegree = findViewById(R.id.checkBoxDegree);
        checkBoxNotFilled = findViewById(R.id.checkBoxNotFilled);
        checkBoxNew = findViewById(R.id.checkBoxNew);



        System.out.println(txtInputEditTextMinPoint.getText().toString());

        multiAutoCompleteTextViewCity = findViewById(R.id.multiAutoCompleteTextViewCity);
        multiAutoCompleteTextViewUniversity = findViewById(R.id.multiAutoCompleteTextViewUniversity);
        multiAutoCompleteTextViewDepartment = findViewById(R.id.multiAutoCompleteTextViewDepartment);

        btnTypeOfPoint.setOnClickListener(this);
        btnTypeofUniversity.setOnClickListener(this);
        btnTypeOfDepartment.setOnClickListener(this);
        btnLanguage.setOnClickListener(this);
        btnShowResults.setOnClickListener(this);

    }

    public void onClick(View view) {
        ArrayList<String> checkBoxContent = new ArrayList<>();


        switch (view.getId()) {

            case R.id.btnTypeOfPoint:
                checkBoxContent.add("TYT");
                checkBoxContent.add("SAYISAL");
                checkBoxContent.add("EŞİT AĞIRLIK");
                checkBoxContent.add("SÖZEL");
                checkBoxContent.add("DİL");
                showAllert(checkBoxContent,"Puan Türü",pointCheckedItems);
                checkBoxContent.clear();
                break;

            case R.id.btnTypeofUniversty:
                checkBoxContent.add("Devlet");
                checkBoxContent.add("Vakıf");
                checkBoxContent.add("KKTC");
                checkBoxContent.add("Yabancı");
                showAllert(checkBoxContent,"Üniversite Türü",universityCheckedItems);
                checkBoxContent.clear();
                break;

            case R.id.btnTypeOfDepartment:
                checkBoxContent.add("Ücretsiz");
                checkBoxContent.add("Burslu");
                checkBoxContent.add("%75 İndirimli");
                checkBoxContent.add("%50 İndirimli");
                checkBoxContent.add("%25 İndirimli");
                checkBoxContent.add("Ücretli");
                checkBoxContent.add("Örgün");
                checkBoxContent.add("Açıköğretim");
                checkBoxContent.add("İkinci");
                checkBoxContent.add("Uzaktan");
                showAllert(checkBoxContent,"Bölüm Türü",departmentCheckedItems);
                checkBoxContent.clear();
                break;

            case R.id.btnLanguage:
                checkBoxContent.add("Türkçe");
                checkBoxContent.add("İngilizce");
                checkBoxContent.add("Almanca");
                checkBoxContent.add("Fransızca");
                checkBoxContent.add("İspanyolca");
                showAllert(checkBoxContent, "Dil",languageCheckedItems);
                checkBoxContent.clear();
                break;

            case R.id.btnShowResults:


                String queryString = checkData();

                Intent intent3 = new Intent(this, showResultOfSearchActivity.class);
                intent3.putExtra("queryString",queryString);
                this.startActivity(intent3);
                break;

        }
    }

    private String checkData() {
        String queryString = "SELECT * FROM departments WHERE ";
        String[] multiAutoCompleteTextViewDepartmentText = multiAutoCompleteTextViewDepartment.getText().toString().split(",");
        String[] multiAutoCompleteTextViewCityText = multiAutoCompleteTextViewCity.getText().toString().split(",");
        String[] multiAutoCompleteTextViewUniversityText = multiAutoCompleteTextViewUniversity.getText().toString().split(",");
        String departmentQuery = "";
        String cityQuery = "";
        String universityQuery = "";


        for (int i = 1; i < multiAutoCompleteTextViewDepartmentText.length; i++ ) {

            if (i > 1) {
                departmentQuery += " OR ";
            }

            departmentQuery += "department = '" + multiAutoCompleteTextViewDepartmentText[i-1].trim() + "'";
        }

        queryString = sumQuery(queryString,departmentQuery);



        for (int i = 1; i < multiAutoCompleteTextViewCityText.length; i++ ) {

            if (i > 1) {
                cityQuery += " OR ";
            }

            cityQuery += "city = '" + multiAutoCompleteTextViewCityText[i-1].trim() + "'";
        }
        queryString = sumQuery(queryString,cityQuery);




        for (int i = 1; i < multiAutoCompleteTextViewUniversityText.length; i++ ) {

            if (i > 1) {
                universityQuery += " OR ";
            }

            universityQuery += "university = '" + multiAutoCompleteTextViewUniversityText[i-1].trim() + "'";
        }
        queryString = sumQuery(queryString,universityQuery);





        if (!txtInputEditTextMinPoint.getText().toString().isEmpty() && !txtInputEditTextMaxPoint.getText().toString().isEmpty()) {

            queryString = sumQuery(queryString,"placement_point2020 BETWEEN " + Integer.parseInt(txtInputEditTextMinPoint.getText().toString()) +
                    " AND " + Integer.parseInt(txtInputEditTextMaxPoint.getText().toString()));


        }



        if (!txtInputEditTextMinPoint.getText().toString().isEmpty() && txtInputEditTextMaxPoint.getText().toString().isEmpty()) {

            queryString = sumQuery(queryString,"placement_point2020 > " + Integer.parseInt(txtInputEditTextMinPoint.getText().toString()));


        }

        if (txtInputEditTextMinPoint.getText().toString().isEmpty() && !txtInputEditTextMaxPoint.getText().toString().isEmpty()) {

            queryString = sumQuery(queryString,"placement_point2020 < " + Integer.parseInt(txtInputEditTextMaxPoint.getText().toString()));



        }


        if (!txtInputEditTextMinPlacementRanking.getText().toString().isEmpty() && !txtInputEditTextMaxPlacementRanking.getText().toString().isEmpty()) {

            queryString = sumQuery(queryString,"placement_ranking2020 BETWEEN " + Integer.parseInt(txtInputEditTextMinPlacementRanking.getText().toString()) +
                    " AND " + Integer.parseInt(txtInputEditTextMaxPlacementRanking.getText().toString()));




        }

        if (!txtInputEditTextMinPlacementRanking.getText().toString().isEmpty() && txtInputEditTextMaxPlacementRanking.getText().toString().isEmpty()) {


            queryString = sumQuery(queryString,"placement_ranking2020 > " + Integer.parseInt(txtInputEditTextMinPlacementRanking.getText().toString()));



        }

        if (txtInputEditTextMinPlacementRanking.getText().toString().isEmpty() && !txtInputEditTextMaxPlacementRanking.getText().toString().isEmpty()) {

            queryString = sumQuery(queryString,"placement_ranking2020 < " + Integer.parseInt(txtInputEditTextMaxPlacementRanking.getText().toString()));


        }

        if (!checkBoxAssociateDegree.isChecked()) {

            queryString = sumQuery(queryString,"type_of_point != 'TYT'");


        }

        if (!checkBoxDegree.isChecked()) {

            queryString = sumQuery(queryString,"type_of_point != 'SAYISAL' AND type_ofpoint != 'EŞİT AĞIRLIK' AND type_of_point != 'DİL' AND type_of_point != 'SÖZEL'");



        }

        if (!checkBoxNew.isChecked()) {

            queryString = sumQuery(queryString,"status != 'Yeni'");


        }

        if (!checkBoxNotFilled.isChecked()) {

            queryString = sumQuery(queryString,"status != 'Dolmadı'");

        }


        if (!notIncluded.isEmpty()) {


            for (String x:notIncluded
                 ) {


                queryString = sumQuery(queryString,"type_of_point !='" + x + "' AND additional_info != '" + x + "' AND type_of_university !='" + x +
                        "' AND type_of_department != '" + x + "' AND language != '" + x + "' AND type_of_department2 != '" + x + "'");



                //TODO dillerde boş kalanlar problem yaratıyor.

            }


        }
        if (queryString.equals("SELECT * FROM departments WHERE ")) {
            queryString = "SELECT * FROM departments WHERE placement_ranking2020 > 0 ORDER BY placement_ranking2020   LIMIT 1000";
        }
        else {
            queryString += " AND placement_ranking2020 > 0 ORDER BY placement_ranking2020 LIMIT 1000";
        }

        return queryString;


    }

    private String sumQuery(String queryString, String query) {

        if (!query.equals("") && !queryString.equals("SELECT * FROM departments WHERE ")) {
            queryString += " AND (" + query + ")";
        }

        if (!query.equals("") && queryString.equals("SELECT * FROM departments WHERE ")) {
            queryString += "(" + query + ")";
        }
        return queryString;
    }

    private void showAllert(ArrayList<String> checkBoxContent, String title, boolean[] checkedItems) {

        // Set up the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        HashSet<String> flagHash = new HashSet<String>();
        flagHash = (HashSet<String>) notIncluded.clone();

        boolean[] copyBoolean = checkedItems;

        boolean[] geciciBoolean = new boolean[checkedItems.length];

        for (int i=0; i < checkedItems.length; i++) {
            geciciBoolean[i] = checkedItems[i];
        }
// Add a checkbox list
        String[] content = checkBoxContent.toArray(new String[0]);
        builder.setMultiChoiceItems(content, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // The user checked or unchecked a box


                if (!isChecked) {
                    notIncluded.add(content[which]);
                    checkedItems[which] = false;
                }

                else {
                    notIncluded.remove(content[which]);
                    checkedItems[which] = true;

                }

            }
        });

// Add OK and Cancel buttons
        builder.setPositiveButton("KAYDET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // The user clicked KAYDET
                System.out.println(notIncluded);




            }
        });
        HashSet<String> finalGeciciHash = flagHash;
        builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // The user clicked İPTAL

                notIncluded = (HashSet<String>) finalGeciciHash.clone();
                departmentCheckedItems = geciciBoolean;

                for (int i=0; i < checkedItems.length; i++) {
                    checkedItems[i] = geciciBoolean[i];
                }
                System.out.println(notIncluded);


            }
        });

// Create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}