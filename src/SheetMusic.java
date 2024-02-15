import java.util.ArrayList;

public class SheetMusic {
    public ArrayList<Melody> melodyList = null;
    private GUIGameViewer frontEnd;
    public SheetMusic(GUIGameViewer frontEnd)
    {
        melodyList = new ArrayList<Melody>();
        this.frontEnd = frontEnd;
        for(int i = 0; i < 4; i++)
        {
            melodyList.add(new Melody(i));

            melodyList.get(i).setFrontEnd(frontEnd);
        }
        melodyList.get(0).setPhrase(0, new boolean[]{false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(0).setPhrase(2, new boolean[]{true, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(0).setPhrase(4, new boolean[]{false, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(1).setPhrase(5, new boolean[]{false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(1).setPhrase(1, new boolean[]{false, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(1).setPhrase(3, new boolean[]{true, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(2).setPhrase(2, new boolean[]{false, false, true, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(2).setPhrase(4, new boolean[]{true, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(2).setPhrase(5, new boolean[]{true, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(3).setPhrase(0, new boolean[]{false, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(3).setPhrase(6, new boolean[]{true, false, true, false, false, false, true, true, false, false, false, false, false, false, false, false});
        melodyList.get(3).setPhrase(2, new boolean[]{false, true, false, true, false, false, true, true, false, false, false, false, false, false, false, false});

    }


}
