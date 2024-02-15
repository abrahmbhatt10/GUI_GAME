import java.util.ArrayList;
import java.util.Scanner;

public class Note {
    private SheetMusic sheetMusic;
    private Melody newMelody;
    private GUIGameViewer frontEnd;

    public Note() {
        frontEnd = new GUIGameViewer(this);
        sheetMusic = new SheetMusic(frontEnd);
        newMelody = new Melody();

    }

    public SheetMusic getSheetMusic() {
        return sheetMusic;
    }

    public GUIGameViewer getFrontEnd()
    {
        return frontEnd;
    }

    public void setSheetMusic(SheetMusic sheetMusic) {
        this.sheetMusic = sheetMusic;
    }

    public Melody getNewMelody() {
        return newMelody;
    }

    public void setNewMelody(Melody newMelody) {
        this.newMelody = newMelody;
    }

    public void run()
    {
    }

    private void printSheetMusic() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        int row = 0;
        for(int i = 0; i < this.sheetMusic.melodyList.size(); i++)
        {
            Melody currentMelody = this.sheetMusic.melodyList.get(i);
            currentMelody.display();
        }
        TTTWindow.invalidate();
        TTTWindow.validate();
        TTTWindow.repaint();
    }

    //main function
    public static void main(String[] args) {
        Note game = new Note();
        game.run();
    }

}
