import java.util.ArrayList;
import java.util.Scanner;

public class Note {
    //declares class variables
    private SheetMusic sheetMusic;
    private Melody newMelody;
    private GUIGameViewer frontEnd;
    private boolean newMelodyCreated;

    //constructor
    public Note() {
        frontEnd = new GUIGameViewer(this);
        sheetMusic = new SheetMusic(frontEnd);
        newMelody = new Melody(-1);
        newMelody.setFrontEnd(frontEnd);
        this.newMelodyCreated = false;
        frontEnd.invalidate();
        frontEnd.validate();
        frontEnd.repaint();
    }

    //getters and setters
    public boolean isNewMelodyCreated() {
        return newMelodyCreated;
    }
    public SheetMusic getSheetMusic() {
        return sheetMusic;
    }

    public Melody getNewMelody() {
        return newMelody;
    }

    //runs program
    public void run()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Music Generator!");

        //loop until user wants to stop generating new music
        boolean stopPlay = false;
        while(!stopPlay) {
            //generates menu on for the user to select on the console
            System.out.println("Enter 1 to generate music");
            System.out.println("Enter 2 to change existing sheet music");
            if(frontEnd.isVisible())
            {
                System.out.println("Enter 3 to close the game window");
            }
            else{
                System.out.println("Enter 3 to open the game window ");
            }
            System.out.println("Enter 0 to stop playing");
            int choice = input.nextInt();
            if(choice == 0)
            {
                stopPlay = true;
            }
            else if(choice == 1)
            {
                //Generating new music
                for(int i = 0; i < 4; i++)
                {
                    newMelody.setPhrase(i*2, i*2,sheetMusic.melodyList.get(i));
                }
                newMelodyCreated = true;
                newMelody.display(frontEnd.getGraphics());
                frontEnd.invalidate();
                frontEnd.validate();
                frontEnd.repaint();
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
                System.out.println("Now changing melody " + melodyPosition);
                Melody changeMelody = this.sheetMusic.melodyList.get(melodyPosition);
                boolean melodyFlag = true;
                while(melodyFlag)
                {
                    System.out.println("Enter chord tone number 0 - 6");
                    int chordTone = input.nextInt();
                    System.out.println("Enter note position 0 - 15");
                    int notePosition = input.nextInt();
                    if(chordTone < 0 || chordTone > 6 || notePosition < 0 || notePosition > 15)
                    {
                        System.out.println("Wrong choice. Please input a number within the bounds necessary");
                        continue;
                    }
                    boolean noteValue = sheetMusic.melodyList.get(melodyPosition).getNote(chordTone, notePosition);
                    if(noteValue)
                    {
                        noteValue = false;
                    }
                    else
                    {
                        noteValue = true;
                    }
                    sheetMusic.melodyList.get(melodyPosition).setNote(chordTone, notePosition, noteValue);
                    System.out.println("Do you want to change another note? Type y or n");
                    input.nextLine();
                    String response = input.nextLine();
                    if(response.equals("n") || response.equals("N"))
                    {
                        melodyFlag = false;
                    }
                }
                frontEnd.invalidate();
                frontEnd.validate();
                frontEnd.repaint();
            }
            else if(choice == 3)
            {
                if(frontEnd.isVisible())
                {
                    frontEnd.setVisible(false);
                }
                else{
                    frontEnd.setVisible(true);
                }
            }
            else
            {
                System.out.println("Wrong choice. Please try again.");
            }
        }


    }

    //main function
    public static void main(String[] args) {
        Note game = new Note();
        game.run();
        System.out.println("Exiting the game");
        game.frontEnd.dispose();
    }

}
