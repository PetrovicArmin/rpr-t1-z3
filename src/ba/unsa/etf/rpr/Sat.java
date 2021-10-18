package ba.unsa.etf.rpr;

public class Sat {
    private int sati;
    private int minute;
    private int sekunde;

    public int dajSate() {
        return sati;
    }

    public int dajMinute() {
        return minute;
    }

    public int dajSekunde() {
        return sekunde;
    }

    public Sat(int sati, int minute, int sekunde) {
        this.Postavi(sati, minute, sekunde);
    }

    private void Postavi(int sati, int minute, int sekunde) {
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }

    public static void main(String[] args) {
        Sat s = new Sat(15, 30, 45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
        s.Postavi(0, 0, 0);
        s.Ispisi();
    }

    private void PomjeriZa(int pomak) {
        if (pomak > 0)
            for (int i = 0; i < pomak; i++)
                this.Sljedeci();
        else
            for (int i = 0; i < pomak * (-1); i++)
                this.Prethodni();

    }

    private void Prethodni() {
        this.sekunde = this.sekunde - 1;
        if (this.sekunde == -1) {
            this.sekunde = 59;
            this.minute = this.minute - 1;
        }
        if (this.minute==-1) {
            this.minute=59;
            this.sati = this.sati - 1;
        }
        if (this.sati==-1)
            this.sati=23;
    }

    private void Sljedeci() {
        this.sekunde = this.sekunde + 1;
        if (this.sekunde == 60) {
            this.sekunde = 0;
            this.minute = this.minute + 1;
        }

        if (this.minute == 60) {
            this.sati = this.sati + 1;
            this.minute = 0;
        }

        if(this.sati == 24)
            this.sati = 0;
    }

    private void Ispisi() {
        System.out.println(this.sati + ":" + this.minute + ":" + this.sekunde);
    }
}
