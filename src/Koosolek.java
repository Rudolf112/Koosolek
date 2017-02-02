import java.util.Date;

/**
 * Created by rudolf on 2.02.2017.
 */
public class Koosolek {
    Koosolek() {}
    double aeg;
    double onnestunud;
    double peetud;
    long startTime;
    long elapsedTime;

    void lisaInfo(double a, String t){
        aeg = a;
        String teema = t;
        startTime = System.currentTimeMillis();
    }
    String tulemus(){
        elapsedTime = (new Date()).getTime() - startTime;
        double aegMinutites = elapsedTime/1000/60;
        System.out.println("Millisekundites kulus: "+elapsedTime);
        System.out.println("Minutites kulus: "+elapsedTime/1000/60);
        if (aegMinutites<aeg){
            onnestunud += 1;
            peetud += 1;
            return "Koosolek õnnestus! Kokku õnnestunud koosolekuid " + onnestunud+" ja peetuid "+peetud;
        }else{
            peetud += 1;
            return "Koosolek ei õnnestunud. Kokku õnnestunud koosolekuid "+onnestunud+" ja peetuid "+peetud;}
    }
    String efektiivsus(){
        double efekt = onnestunud/peetud*100;
        if(efekt<50){
            return "Efektiivsus on "+efekt+"% e alla 50%! MOTIVATSIOONILAUSE!";
        }
        else{return "Efektiivsus on "+efekt+"% e vähemalt 50%!";}
    }
}
