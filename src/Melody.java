import java.awt.*;

public class Melody {
    //declares class variables
    public final int CHORD_TONE_TOTAL = 7;
    public final int NOTES_TOTAL = 16;
    private boolean[][] currentMelody = new boolean[CHORD_TONE_TOTAL][NOTES_TOTAL];
    private GUIGameViewer frontEnd;
    private int melodyPosition;

    //constructor
    public Melody(int melodyPosition)
    {
        this.melodyPosition = melodyPosition;
        for(int i = 0; i < CHORD_TONE_TOTAL; i++)
        {
            for(int j = 0; j < NOTES_TOTAL; j++)
            {
                currentMelody[i][j] = false;
            }
        }
    }
    //getters and setters
    public boolean[][] getCurrentMelody() {
        return currentMelody;
    }
    public void setFrontEnd(GUIGameViewer frontEnd) {
        this.frontEnd = frontEnd;
    }
    public void setPhrase(int chordTone, int sheetTone, Melody sheetMelody)
    {
        if(chordTone < 0 || chordTone > CHORD_TONE_TOTAL - 1)
        {
            return;
        }
        for(int j = 0; j < NOTES_TOTAL; j++)
        {
            this.currentMelody[chordTone][j] = sheetMelody.getCurrentMelody()[sheetTone][j];
        }
    }

    public void setPhrase(int chordTone, boolean[] phrase)
    {
        if(chordTone < 0 || chordTone > CHORD_TONE_TOTAL - 1)
        {
            return;
        }
        if(phrase.length != NOTES_TOTAL)
        {
            return;
        }
        for(int j = 0; j < NOTES_TOTAL; j++)
        {
            currentMelody[chordTone][j] = phrase[j];
        }
    }

    public boolean getNote(int chordTone, int notePosition)
    {
        return currentMelody[chordTone][notePosition];
    }

    public void setNote(int chordTone, int notePosition, boolean noteValue)
    {
        currentMelody[chordTone][notePosition] = noteValue;
    }

    //acts as a display
    public void display(Graphics g)
    {
        //fills in the rectangle with 4 lines
        int xOffset = frontEnd.getX_OFFSET();
        int length = frontEnd.getSquareLength();
        int yOffset = frontEnd.getY_OFFSET() + 9 * melodyPosition * length;
        if(melodyPosition < 0)
        {
            xOffset = frontEnd.getX_OFFSET() + 18*length;
            yOffset = frontEnd.getY_OFFSET() + 12*length;
        }
        for(int i = 0; i < CHORD_TONE_TOTAL; i++)
        {
            g.setColor(Color.WHITE);
            if(melodyPosition < 0)
            {
                g.drawRect((int)(xOffset - (length)),yOffset + (i * length) + length, length, length);
            }
            else {
                g.drawRect((int)(xOffset * 0.5),yOffset + (i * length) + length, length, length);
            }
            g.setColor(Color.RED);
            Font stringFont = new Font("Times New Roman", Font.PLAIN, 24);
            g.setFont(stringFont);
            if(melodyPosition < 0)
            {
                g.drawString(Integer.toString(i), (int) (xOffset - (length)), yOffset + (i * length) + length);

            }
            else{
                g.drawString(Integer.toString(i), (int) (xOffset * 0.5), yOffset + (i * length) + length);

            }
            for(int j = 0; j < NOTES_TOTAL; j++)
            {
                g.setColor(Color.WHITE);
                g.drawRect(xOffset,yOffset - (int)(1.5 * length),length * NOTES_TOTAL,length);
                g.setColor(Color.RED);
                stringFont = new Font("Times New Roman", Font.PLAIN, 24);
                g.setFont(stringFont);
                g.drawString(Integer.toString(j), xOffset + (length * j), yOffset - (int)(0.5 * length));
                if(currentMelody[i][j])
                {
                    g.setColor(Color.GREEN);
                    g.fillRect(xOffset+j*length, yOffset+i*length, length, length);
                    g.setColor(Color.BLACK);
                    g.drawRect(xOffset+j*length, yOffset+ i*length, length, length);
                }
                else
                {
                    g.setColor(Color.WHITE);
                    g.fillRect(xOffset+j*length, yOffset+i*length, length, length);
                    g.setColor(Color.BLACK);
                    g.drawRect(xOffset+j*length, yOffset+ i*length, length, length);
                }
            }
        }
    }
}
