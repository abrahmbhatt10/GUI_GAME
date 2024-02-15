import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

public class GUIGameViewer extends JFrame {
    private boolean isComplete = false;
    public final int BOX_SIZE = 50;
    public final int WINDOW_HEIGHT = 33 * BOX_SIZE;
    public final int WINDOW_WIDTH = 18 * BOX_SIZE;
    public final int TITLE_BAR_HEIGHT = 50;
    public final int Y_OFFSET = BOX_SIZE;
    public final int X_OFFSET = BOX_SIZE;
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
        //Display the first column axis numbering
        for(int i = 0; i < gameNote.get().length; i++)
        {
            g.setColor(Color.WHITE);
            g.drawRect(BOX_SIZE,BOX_SIZE * i,BOX_SIZE, BOX_SIZE);
            g.setColor(Color.RED);
            Font stringFont = new Font("Times New Roman", Font.PLAIN, 24);
            g.setFont(stringFont);
            g.drawString(Integer.toString(i), (int) (0.5 * BOX_SIZE), (int) (BOX_SIZE * (i + 1) + 0.5 * BOX_SIZE));
        }
        //Display the first row axis numbering for each grid
        for(int i = 0; i < gameNote.get()[0].length; i++)
        {
            g.setColor(Color.WHITE);
            g.drawRect(i * BOX_SIZE,BOX_SIZE,BOX_SIZE,BOX_SIZE);
            g.setColor(Color.RED);
            Font stringFont = new Font("Times New Roman", Font.PLAIN, 24);
            g.setFont(stringFont);
            g.drawString(Integer.toString(i), (int) ((i + 1) * BOX_SIZE + 0.5 * BOX_SIZE), (int) (0.5 * BOX_SIZE));
        }
        //Display the grid with each square
        g.setColor(Color.BLACK);
        for(int i = 0; i < backEnd.getBoard().length; i++)
        {
            for(int j = 0; j < backEnd.getBoard()[0].length; j++)
            {
                backEnd.getBoard()[i][j].draw(g);
            }
        }
        //Display the Game Over Status String - Tie or Winner
        if(backEnd.isGameOver())
        {
            g.setColor(Color.WHITE);
            g.drawRect(BOX_SIZE,4 * BOX_SIZE,5 * BOX_SIZE,BOX_SIZE);
            g.setColor(Color.BLACK);
            Font stringFont = new Font("Times New Roman", Font.BOLD, 48);
            g.setFont(stringFont);
            g.drawString(backEnd.getGameOverStatus(), BOX_SIZE, (int) (4 * BOX_SIZE + 0.5 * BOX_SIZE));
        }
    }
}
