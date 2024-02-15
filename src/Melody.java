import java.awt.*;
import java.util.ArrayList;



public class Melody {
    private boolean[][] currentMelody = new boolean[7][16];
    private GUIGameViewer frontEnd;

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
        int xOffset = backEnd.getxOffset();
        int yOffset = backEnd.getyOffset();
        int length = backEnd.getsLength();

        g.drawRect(xOffset+col*length, yOffset+ row*length, length, length);

        //fills rectangle in green if won
        if(getIsWinningSquare())
        {   g.setColor(Color.GREEN);
            g.fillRect(xOffset+col*length, yOffset+row*length, length, length);
        }

        if(marker.equals(backEnd.X_MARKER))
        {
            g.drawRect( xOffset+col*length,yOffset+row*length, length, length);
            g.drawImage(backEnd.getxMarkerImage(), xOffset + col * length, yOffset + row * length,null);
        }
        if(marker.equals(backEnd.O_MARKER))
        {
            g.drawRect( xOffset+col*length, yOffset+row*length, length, length);
            g.drawImage(backEnd.getoMarkerImage(),  xOffset + col * length, yOffset + row * length,null);
        }
    }





}
