import java.util.ArrayList;
import java.util.Scanner;

public class Note {
    private int row;
    private int col;
    private int chordTone;
    private boolean isVoid;
    private Note[][] sheetMusic1 = new Note[7][16];
    private Note[][] sheetMusic2 = new Note[7][16];
    private Note[][] sheetMusic3 = new Note[7][16];
    private Note[][] sheetMusic4 = new Note[7][16];
    private Note[][] newMusic = new Note[7][16];
     private boolean isComplete = false;
    private Note n;

    public Note(int row, int col) {
        this.row = row;
        this.col = col;
        this.chordTone = row;
    }

    public Note() {
        this.isVoid = true;
    }


    public void run() {
        Scanner input = new Scanner(System.in);

    System.out.println("Welcome to the Music Generator! Every row represents a chord tone");
    System.out.println("Every column represents a 1/16th note in time.");
    this.printBoard();
    for(int i = 0; i < 7; i++)
    {
        for(int j = 0; j < 16; j++)
        {
            System.out.println("insert note? write y or n");
            String response = input.nextLine();
            if(response.equals("y"))
            {
                Note nNote = new Note(i,j);
                sheetMusic1[i][j] = nNote;
            }
            else {
                Note nNote = new Note();
                sheetMusic1[i][j] = nNote;
            }
        }
    }
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                System.out.println("insert note? write y or n");
                String response = input.nextLine();
                if(response.equals("y"))
                {
                    Note nNote = new Note(i,j);
                    sheetMusic2[i][j] = nNote;
                }
                else {
                    Note nNote = new Note();
                    sheetMusic2[i][j] = nNote;
                }
            }
        }
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                System.out.println("insert note? write y or n");
                String response = input.nextLine();
                if(response.equals("y"))
                {
                    Note nNote = new Note(i,j);
                    sheetMusic3[i][j] = nNote;
                }
                else {
                    Note nNote = new Note();
                    sheetMusic3[i][j] = nNote;
                }
            }
        }
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                System.out.println("insert note? write y or n");
                String response = input.nextLine();
                if(response.equals("y"))
                {
                    Note nNote = new Note(i,j);
                    sheetMusic4[i][j] = nNote;
                }
                else {
                    Note nNote = new Note();
                    sheetMusic4[i][j] = nNote;
                }
            }
        }

        //sets each phrase for 1,3,5,7 chord tones from sheetmusic 1,2,3,4 respectively
        //If two notes are played at the same time(col), then one phrase must shift the whole phrase by 4/16th notes (4 cols more)

        newMusic[0] = sheetMusic1[0];
        newMusic[2] = sheetMusic2[2];
        newMusic[4] = sheetMusic3[4];
        newMusic[6] = sheetMusic4[6];















        // Loop until there is a winner or no more turns

    }

        this.printBoard();
        this.isGameOver = true;

    // Determine if there was a winner
        if(!this.checkWin()) {
        System.out.println(" Game ends in a tie!");
    } else {
        this.markWinningSquares();
        if (this.turn%2 == 0) {
            this.winner = O_MARKER;
            System.out.println("   O Wins!");
        } else {
            this.winner = X_MARKER;
            System.out.println("   X Wins!");
        }
    }
}

    private void printBoard() {
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                System.out.println("_ ");
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
