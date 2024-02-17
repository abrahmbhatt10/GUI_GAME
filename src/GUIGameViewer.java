import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GUIGameViewer extends JFrame {
    //declares class variables
    public final int BOX_SIZE = 25;
    public final int WINDOW_HEIGHT = 33 * BOX_SIZE;
    public final int WINDOW_WIDTH = 100 * BOX_SIZE;

    public final int Y_OFFSET = BOX_SIZE * 2;
    public final int X_OFFSET = BOX_SIZE * 2;
    //points to back end
    private Note gameNote;
    //Image variables for the Piano Keys jpg
    private Image newMelodyImage, scaledNewMelodyImage;

    //constructor
    public GUIGameViewer(Note gameNote) {
        this.gameNote = gameNote;
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setTitle("Music Generator");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        try {
            newMelodyImage = ImageIO.read(new File("Resources/PianoKeys.jpg"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        scaledNewMelodyImage = newMelodyImage.getScaledInstance(4*BOX_SIZE, 4*BOX_SIZE, 0);
    }
    //getters and setters
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
        g.drawImage(scaledNewMelodyImage, getX_OFFSET() + 24 * BOX_SIZE, getY_OFFSET() + 4 * BOX_SIZE,null);

        //Display the four melodies squares from the sheet music
        g.setColor(Color.BLACK);
        if(gameNote.getSheetMusic() != null)
        {
            for(int i = 0; i < 4; i++)
            {
                gameNote.getSheetMusic().melodyList.get(i).display(g);
            }
        }
        //check whether computer has generated a new melody
        if(gameNote.isNewMelodyCreated())
        {
            g.setColor(Color.ORANGE);
            Font stringFont = new Font("Times New Roman", Font.BOLD, 60);
            g.setFont(stringFont);
            g.drawString("* * * * *", (int) (getX_OFFSET() + 24 * BOX_SIZE), getY_OFFSET() + BOX_SIZE);
            gameNote.getNewMelody().display(g);
        }
        //prints out game rules in window
        g.setColor(Color.BLUE);
        Font stringFont = new Font("Times New Roman", Font.PLAIN, 20);
        g.setFont(stringFont);
        g.drawString("GAME RULES: ", (int) (getX_OFFSET() + 18 * BOX_SIZE), getY_OFFSET() + 20 * BOX_SIZE);
        g.drawString("Rule 1: The four melodies on the right are existing sheet music.", (int) (getX_OFFSET() + 18 * BOX_SIZE), getY_OFFSET() + 21 * BOX_SIZE);
        g.drawString("Rule 2: You can revise or change any notes you like by giving its position.", (int) (getX_OFFSET() + 18 * BOX_SIZE), getY_OFFSET() + 22 * BOX_SIZE);
        g.drawString("Rule 3: You can command the game to generate new music using existing sheet music.", (int) (getX_OFFSET() + 18 * BOX_SIZE), getY_OFFSET() + 23 * BOX_SIZE);

    }
}
