import java.util.ArrayList;
import java.util.Scanner;

public class Note {
    private SheetMusic sheetMusic;
    private Melody newMelody;
    private GUIGameViewer frontEnd;

    public Note() {
        frontEnd = new GUIGameViewer(this);
        sheetMusic = new SheetMusic(frontEnd);
        newMelody = new Melody(-1);

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
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Music Generator!");

        // Loop until there is a winner or no more turns
        boolean stopPlay = false;
        while(!stopPlay) {
            this.printSheetMusic();
            System.out.println("Enter 1 to generate music");
            System.out.println("Enter 2 to change existing sheet music");
            System.out.println("Enter 0 to stop playing");
            int choice = input.nextInt();
            if(choice == 0)
            {
                stopPlay = true;
                continue;
            }
            else if(choice == 2)
            {
                System.out.println("Enter a number between 0 to 3 to select a melody to change.");
                int melodyPosition = input.nextInt();
                if(melodyPosition < 0 || melodyPosition > 3)
                {
                    System.out.println("Wrong choice. Please try again.");
                    continue;
                }
                Melody changeMelody = this.sheetMusic.melodyList.get(melodyPosition);
                System.out.println("Enter row/col/string to change to true.");
                String phrasing = input.nextLine();
                changeMelody.clearMelody();
                for(int i = 0; i + 1 < phrasing.length(); i++)
                {
                    int chordTone = (int)(phrasing.charAt(i) - '0');
                    int notePosition = (int)(phrasing.charAt(i + 1) - '0');
                    changeMelody.setNote(chordTone, notePosition, true);
                }
            }
            else if(choice == 1)
            {

            }
            else
            {
                System.out.println("Wrong choice. Please try again.");
            }
        }


    }

    private void printSheetMusic() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        int row = 0;
        for(int i = 0; i < this.sheetMusic.melodyList.size(); i++)
        {
            Melody currentMelody = this.sheetMusic.melodyList.get(i);
            currentMelody.display(frontEnd.getGraphics());
        }
        frontEnd.invalidate();
        frontEnd.validate();
        frontEnd.repaint();
    }

    //main function
    public static void main(String[] args) {
        Note game = new Note();
        game.run();
    }

}
