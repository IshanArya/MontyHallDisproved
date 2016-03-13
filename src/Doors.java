/**
 * Created by ishan on 2/26/2016.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Doors {
    private static int[] door = new int[3];
    private static int sel;

    public static int phaseOne(int select){
        if(select < 1 || select > 3)
            //return 0 if selection not in criteria
            return 0;

        init();
        sel = select - 1;

        int current = (int)(Math.random() * 3);
        while(current == sel)
            current = (int)(Math.random() * 3);
        sel = current + 1;
        return (current + 1);
    }
    public static int phaseTwo(int select){
        if(select < 1 || select > 3 || select == sel)
            //return 0 if selection not in criteria
            return 0;

        sel = select - 1;
        if(door[sel] == 1)
            return 1;
        else
            return 2;
    }

    public static int[] getDoor(){
        return door;
    }

    private static void init(){
        for(int i = 0; i < 3; i++)
            door[i] = 0;
        ArrayList<Byte> assign = new ArrayList<>();
        assign.addAll(Arrays.asList((byte)1, (byte)2, (byte)2));
        for(int i = 2; i >= 0; i--){
            int current = (int)(Math.random() * 3);
            while(door[current] != 0)
                current = (int)(Math.random() * 3);
            door[current] = (assign.remove((int)(Math.random() * (i + 1))));
        }
    }

}
