import java.util.ArrayList;

public class Melody {
    private ArrayList<Phrase> melody;

    public Melody(ArrayList<Phrase> melody) {
        this.melody = melody;
    }

    public ArrayList<Phrase> getMelody() {
        return melody;
    }

    public void setMelody(ArrayList<Phrase> melody) {
        this.melody = melody;
    }
}
