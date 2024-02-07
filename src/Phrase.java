import java.util.ArrayList;

public class Phrase {
    private ArrayList<Note> phrase;
    private int chordTone;

    public Phrase(ArrayList<Note> phrase, int chordTone) {
        this.phrase = phrase;
        this.chordTone = chordTone;
    }

    public int getChordTone() {
        return chordTone;
    }

    public void setChordTone(int chordTone) {
        this.chordTone = chordTone;
    }

    public ArrayList<Note> getPhrase() {
        return phrase;
    }

    public void setPhrase(ArrayList<Note> phrase) {
        this.phrase = phrase;
    }
}
