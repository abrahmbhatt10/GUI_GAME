import java.awt.*;
import java.util.ArrayList;



public class Melody {
    private boolean[][] currentMelody = new boolean[7][16];
    private GUIGameViewer frontEnd;
    private int melodyPosition;

    public Melody(int melodyPosition)
    {
        this.melodyPosition = melodyPosition;
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                currentMelody[i][j] = false;
            }
        }



    }

    public void clearMelody()
    {
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                currentMelody[i][j] = false;
            }
        }
    }

    public boolean[][] getCurrentMelody() {
        return currentMelody;
    }

    public void setCurrentMelody(boolean[][] currentMelody) {
        this.currentMelody = currentMelody;
    }

    public GUIGameViewer getFrontEnd() {
        return frontEnd;
    }

    public void setFrontEnd(GUIGameViewer frontEnd) {
        this.frontEnd = frontEnd;
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

    public void setNote(int chordTone, int notePosition, boolean noteValue)
    {
        currentMelody[chordTone][notePosition] = noteValue;
    }

    public void display(Graphics g)
    {

        //fills in the rectangle with 4 lines
        int xOffset = frontEnd.getX_OFFSET();
        int length = frontEnd.getSquareLength();
        int yOffset = frontEnd.getY_OFFSET() + 9 * melodyPosition * length;
        for(int i = 0; i < 7; i++)
        {
            g.setColor(Color.WHITE);
            g.drawRect((int)(xOffset * 0.5),yOffset + (i * length) + length, length, length);
            g.setColor(Color.RED);
            Font stringFont = new Font("Times New Roman", Font.PLAIN, 24);
            g.setFont(stringFont);
            g.drawString(Integer.toString(i), (int) (xOffset * 0.5), yOffset + (i * length) + length);
            for(int j = 0; j < 16; j++)
            {
                g.setColor(Color.WHITE);
                g.drawRect(xOffset,yOffset - (int)(1.5 * length),length * 16,length);
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
