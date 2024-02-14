import java.util.ArrayList;



public class Melody {
    private static boolean[][] currentMelody = new boolean[7][16];

    public Melody()
    {
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                currentMelody[i][j] = false;
            }
        }



    }

    public void setPhrase(int chordTone, boolean[] phrase)
    {
        if(chordTone < 0 || chordTone > 6)
        {
            return;
        }
        if(phrase.length != 16)
        {
            return;
        }
        for(int j = 0; j < 16; j++)
        {
            currentMelody[chordTone][j] = phrase [j];
        }
    }
}
