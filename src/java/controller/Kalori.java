/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author niyobaskan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Mert Yılmaz
 */
@ManagedBean(name = "kalori")
@RequestScoped
//@SessionScoped
public class Kalori {

    private String yas, boy, kilo, calismaBicimi;
    private boolean cinsiyetE, cinsiyetK;
    private String bmi, kaloriIhtiyac, vucutYuzey, yagsizVucut, idealKilo, vucutKitle;
    private boolean sonuclarOnay = false;

    private String kisilikSayisi, kisilikMetin, kisilikBaslik;
    private boolean kisilikOnay = false;

    private boolean secenekA, secenekB, secenekC, secenekD, secenekE;
    private boolean kariyerOnay = false;
    private String kariyerMesaj;

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getCalismaBicimi() {
        return calismaBicimi;
    }

    public void setCalismaBicimi(String calismaBicimi) {
        this.calismaBicimi = calismaBicimi;
    }

    public boolean isCinsiyetE() {
        return cinsiyetE;
    }

    public void setCinsiyetE(boolean cinsiyetE) {
        this.cinsiyetE = cinsiyetE;
    }

    public boolean isCinsiyetK() {
        return cinsiyetK;
    }

    public void setCinsiyetK(boolean cinsiyetK) {
        this.cinsiyetK = cinsiyetK;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getKaloriIhtiyac() {
        return kaloriIhtiyac;
    }

    public void setKaloriIhtiyac(String kaloriIhtiyac) {
        this.kaloriIhtiyac = kaloriIhtiyac;
    }

    public String getVucutYuzey() {
        return vucutYuzey;
    }

    public void setVucutYuzey(String vucutYuzey) {
        this.vucutYuzey = vucutYuzey;
    }

    public String getYagsizVucut() {
        return yagsizVucut;
    }

    public void setYagsizVucut(String yagsizVucut) {
        this.yagsizVucut = yagsizVucut;
    }

    public String getIdealKilo() {
        return idealKilo;
    }

    public void setIdealKilo(String idealKilo) {
        this.idealKilo = idealKilo;
    }

    public String getVucutKitle() {
        return vucutKitle;
    }

    public void setVucutKitle(String vucutKitle) {
        this.vucutKitle = vucutKitle;
    }

    public boolean isSonuclarOnay() {
        return sonuclarOnay;
    }

    public void setSonuclarOnay(boolean sonuclarOnay) {
        this.sonuclarOnay = sonuclarOnay;
    }

    public String getKisilikSayisi() {
        return kisilikSayisi;
    }

    public void setKisilikSayisi(String kisilikSayisi) {
        this.kisilikSayisi = kisilikSayisi;
    }

    public String getKisilikMetin() {
        return kisilikMetin;
    }

    public void setKisilikMetin(String kisilikMetin) {
        this.kisilikMetin = kisilikMetin;
    }

    public boolean isKisilikOnay() {
        return kisilikOnay;
    }

    public void setKisilikOnay(boolean kisilikOnay) {
        this.kisilikOnay = kisilikOnay;
    }

    public String getKisilikBaslik() {
        return kisilikBaslik;
    }

    public void setKisilikBaslik(String kisilikBaslik) {
        this.kisilikBaslik = kisilikBaslik;
    }

    public boolean isSecenekA() {
        return secenekA;
    }

    public void setSecenekA(boolean secenekA) {
        this.secenekA = secenekA;
    }

    public boolean isSecenekB() {
        return secenekB;
    }

    public void setSecenekB(boolean secenekB) {
        this.secenekB = secenekB;
    }

    public boolean isSecenekC() {
        return secenekC;
    }

    public void setSecenekC(boolean secenekC) {
        this.secenekC = secenekC;
    }

    public boolean isSecenekD() {
        return secenekD;
    }

    public void setSecenekD(boolean secenekD) {
        this.secenekD = secenekD;
    }

    public boolean isSecenekE() {
        return secenekE;
    }

    public void setSecenekE(boolean secenekE) {
        this.secenekE = secenekE;
    }

    public boolean isKariyerOnay() {
        return kariyerOnay;
    }

    public void setKariyerOnay(boolean kariyerOnay) {
        this.kariyerOnay = kariyerOnay;
    }

    public String getKariyerMesaj() {
        return kariyerMesaj;
    }

    public void setKariyerMesaj(String kariyerMesaj) {
        this.kariyerMesaj = kariyerMesaj;
    }

    public String sonuclar() {

        sonuclarOnay = true;

        if (cinsiyetE == true) {

            bmi = String.format("%.0f", ((66) + (13.86 * (Double.parseDouble(kilo))) + (5.03 * (Double.parseDouble(boy))) - (6.8 * Double.parseDouble(yas))));
            vucutYuzey = String.format("%.2f", Math.sqrt(((Double.parseDouble(boy)) * (Double.parseDouble(kilo))) / 3600));
            yagsizVucut = String.format("%.0f", (1.1 * (Double.parseDouble(kilo))) - (128 * ((Math.pow((Double.parseDouble(kilo)), 2)) / (Math.pow((100 * ((Double.parseDouble(boy)) / 100)), 2)))));
            idealKilo = String.format("%.0f", (50) + ((2.3) * (((Double.parseDouble(boy)) * (0.39)) - (60))));
            vucutKitle = String.format("%.1f", ((Double.parseDouble(kilo))) / (Math.pow(((Double.parseDouble(boy)) / 100), 2)));

            switch (Integer.parseInt(calismaBicimi)) {
                case 1:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.2));
                    break;
                case 2:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.375));
                    break;
                case 3:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.55));
                    break;
                case 4:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.725));
                    break;
                case 5:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.9));
                    break;
                default:
                    break;
            }

        } else if (cinsiyetK == true) {

            bmi = String.format("%.0f", ((665) + (9.46 * (Double.parseDouble(kilo))) + (1.83 * (Double.parseDouble(boy))) - (4.7 * Double.parseDouble(yas))));
            vucutYuzey = String.format("%.2f", Math.sqrt(((Double.parseDouble(boy)) * (Double.parseDouble(kilo))) / 3600));
            yagsizVucut = String.format("%.0f", (1.07 * (Double.parseDouble(kilo))) - (148 * ((Math.pow((Double.parseDouble(kilo)), 2)) / (Math.pow((100 * ((Double.parseDouble(boy)) / 100)), 2)))));
            idealKilo = String.format("%.0f", (45.5) + ((2.3) * (((Double.parseDouble(boy)) * (0.39)) - (60))));
            vucutKitle = String.format("%.1f", ((Double.parseDouble(kilo))) / (Math.pow((Double.parseDouble(boy)), 2)));

            switch (Integer.parseInt(calismaBicimi)) {
                case 1:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.2));
                    break;
                case 2:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.375));
                    break;
                case 3:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.55));
                    break;
                case 4:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.725));
                    break;
                case 5:
                    kaloriIhtiyac = String.format("%.1f", (Double.parseDouble(bmi)) * (1.9));
                    break;
                default:
                    break;
            }

        }

        return null;
    }

    public String kisilikSonucu() {

        kisilikOnay = true;

        switch (Integer.parseInt(kisilikSayisi)) {
            case 1:
                kisilikMetin = "Baskıcı öğretmen portresi seçtiniz, Bilinçaltınızda bastırılmış saldırganlık ve alçaltıcı davranış eğilimi olabilir. "
                        + "Çocuklukta davranışlarınızda otoriterlik, yönetme ihtiyacı gibi eğilimleri tecrübe etmiş olabilirsiniz. ";
                kisilikBaslik = "Sadist";
                break;
            case 2:
                kisilikMetin = "Yuvarlak kafalı bu iri adam sizde tiksinti ve korkuya sebep olduysa çocukluğunuzun erken aşamalarında bazı duygularınızı bastırmış olabilirsiniz. "
                        + "Asabiyet, düşünmeden hareket etme, sinir patlamaları gibi belirtilere aşina olma ihtimaliniz yüksek. ";
                kisilikBaslik = "Epileptik";
                break;
            case 3:
                kisilikMetin = "Bu tip kişilikler genellikle aşırı hayal gücüyle karamsar bir yapıya sahip. "
                        + "Eğer bu kirli görünümlü ama mutlu adam sizde olumsuz bir etki bıraktıysa, zihninizin hiperaktif kısmını bastırmış olma ihtimaliniz var. ";
                kisilikBaslik = "Katatonik";
                break;
            case 4:
                kisilikMetin = "Şizofrenik kişilik yoğun umursamazlık, düşünce bozukluğu ve uyumsuz duygular olarak karakterize edilir. "
                        + "Eğer bu ruhsuz ve ifadesiz kadın portresi tüylerinizi ürperttiyse, çocukluğunuzda insanlara ilgisizlik, koşullardan ve olaylardan çabuk vazgeçme gibi duyguları bastırmış olmanız muhtemel. ";
                kisilikBaslik = "Şizofrenik";
                break;
            case 5:
                kisilikMetin = "Histerik insanların bazı özellikleri yapay, duygularında kararsız ve narsist olmalarıdır. "
                        + "Bu resmin sizi korkutma sebebi, dikkat çekme arzusunu ve beğenilmeye susamış olmayı bastırmış olmanızdan kaynaklanabilir. ";
                kisilikBaslik = "Histerik";
                break;
            case 6:
                kisilikMetin = "Öz saygı eksikliği, aşağılık ve suçluluk duygusu depresyonun ana semptomlarıdır. "
                        + "Bu zararsız görünümlü kadın sizde hoşnutsuzluk yarattıysa, zararsızlık sizin için nefretin ta kendisi ve bu öz saygı eksikliği, aşağılık ve suçluluk duygusu gibi semptomları bastırdığınız görülüyor. ";
                kisilikBaslik = "Depresif";
                break;
            case 7:
                kisilikMetin = "Dışa dönüklük, abartılı tepki ve duygu sergileme gibi özelliklere sahiptir. "
                        + "Eğer bu portredeki lütufkar yüz sizi tiksindiriyorsa ve eğer kontrol edilmezse sizi çıldırtacak düzeye getirecek bastırılmış bir coşkuya sahipsiniz. ";
                kisilikBaslik = "Manyak";
                break;
            case 8:
                kisilikMetin = "Bu tür kişilik tipi \"kişinin başkası olarak yaşamak ve öyle kabul edilmek istemesi\" olarak açıklanır. "
                        + "Eğer bu genç adamı tehlikeli ve uygunsuz olarak algıladıysanız, çocukluğunuzun erken dönemlerinde kimlik sorunu yaşamış ve bunu bastırmış olabilirsiniz. ";
                kisilikBaslik = "Kimlik Karmaşası";
                break;
            default:
                break;
        }

        return null;
    }

    public String kariyerSonucu() {

        kariyerOnay = true;

        if (secenekA == true) {
            kariyerMesaj = "Cesur ve girişkensiniz. İyi bir satış temsilcisi olursunuz.";
        } else if (secenekB == true) {
            kariyerMesaj = "Hedefe nasıl ve ne yöntemlerle ulaşacağınızı planlayabiliyorsunuz. İyi bir halkla ilişkiler müdürü olursunuz.";
        } else if (secenekC == true) {
            kariyerMesaj = "Saflık derecesinde iyimsersiniz. Ne yaparsanız yapın, sakın kendi işinizi kurmaya kalkmayın.";
        } else if (secenekD == true) {
            kariyerMesaj = "Kendi işinizi kurup çok başarılı ve ünlü olabilirsiniz.";
        } else if (secenekE == true) {
            kariyerMesaj = "Sorumluluğu başkalarına atmayı iyi beceriyorsunuz. İyi bir üst düzey yönetici olursunuz.";
        }

        return null;
    }

}
