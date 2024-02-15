import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

public class GUIGameViewer extends JFrame {
    private boolean isComplete = false;
    public final int BOX_SIZE = 25;
    public final int WINDOW_HEIGHT = 33 * BOX_SIZE;
    public final int WINDOW_WIDTH = 18 * BOX_SIZE;
    public final int TITLE_BAR_HEIGHT = 50;
    public final int Y_OFFSET = BOX_SIZE * 2;
    public final int X_OFFSET = BOX_SIZE * 2;
    private Note gameNote;

    public GUIGameViewer(Note gameNote) {
        this.gameNote = gameNote;
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setTitle("Music Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public int getTITLE_BAR_HEIGHT() {
        return TITLE_BAR_HEIGHT;
    }

    public int getSquareLength() {
        return BOX_SIZE;
    }

    public int getY_OFFSET() {
        return Y_OFFSET;
    }

    public int getX_OFFSET() {
        return X_OFFSET;
    }

    //paints squares
    public void paint(Graphics g)
    {
        //clears screen
        g.setColor(Color.WHITE);
        g.drawRect(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);
        g.fillRect(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);

        //Display the grid with each square
        g.setColor(Color.BLACK);
        for(int i = 0; i < 4; i++)
        {
            gameNote.getSheetMusic().melodyList.get(i).display(g);
        }
    }
}
