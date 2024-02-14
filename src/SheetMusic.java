import java.util.ArrayList;

public class SheetMusic {
    public static ArrayList<Melody> melodyList = null;

    public void SheetMusic()
    {
        melodyList = new ArrayList<Melody>();
        for(int i = 0; i < 4; i++) {
            melodyList.add(new Melody());
            boolean[] phrase1 = new boolean[16];
            if (i == 1) {
                phrase1 = new boolean[]{false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false};
            }
            melodyList.get(i).setPhrase(i, phrase1);
        }
    }


}
