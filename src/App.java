import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by ishan on 2/26/2016.
 */
public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)throws Exception{
        //runWithUserInput();
        System.out.print("Number of tries: ");
        runWithMultipleTries(sc.nextInt());
//        for(;;){
//            int ans1 = Doors.phaseOne(2);
//            System.out.println(ans1);
//            int ans2 = Doors.phaseTwo(2);
//            System.out.println(ans2);
//            if(ans1 == 3 && ans2 == 1)
//                break;
//            System.out.println("----------------------------------");
//            for(int x : Doors.getDoor())
//                System.out.println(x);
//            TimeUnit.MILLISECONDS.sleep(500);
//            System.out.println("-----------------------NEXT---------------------");
//        }
//        System.out.println("SUCCESS!");

        /*
        for(;;){
            TimeUnit.SECONDS.sleep(1);
            System.out.println((int)(Math.random() * 1));
        }
         */
    }

    public static void runWithUserInput(){
        System.out.println("Welcome to the Monty Hall!");
        System.out.print("Here are the doors: ");
        System.out.printf("%3d%3d%3d\n", 1, 2, 3);
        System.out.println("Pick the door you think has the 1.");
        int choice;
        do{
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }while(Doors.phaseOne(choice) == 0);
        System.out.println();
        System.out.printf("The door with the 2 is: %d\n", Doors.phaseOne(choice));
        System.out.print("Pick the door you think has the 1.\n");
        do{
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }while(Doors.phaseTwo(choice) == 0);
        System.out.printf("The door you picked has a %d behind it.\n", Doors.phaseTwo(choice));
        if(Doors.phaseTwo(choice) == 1)
            System.out.println("YOU WIN!");
        else
            System.out.println("You lose.");
        System.out.print("The doors: ");
        int i = 0;
        for(int x : Doors.getDoor())
            System.out.printf("%3d -> %d", ++i, x);

    }

    public static void runWithMultipleTries(int tries){
        //Picking the same door twice
        int counter1 = 0;
        for(int i = 0; i < tries; i++){
            int rnd = (int)(Math.random() * 3);
            Doors.phaseOne(rnd);
            if(Doors.phaseTwo(rnd) == 1) counter1++;
        }

        //Picking the other door
        int counter2 = 0;
        for(int i = 0; i < tries; i++){
            int rnd = (int)(Math.random() * 3);
            if(Doors.phaseTwo(6 - (rnd + Doors.phaseOne(rnd))) == 1) counter2++;
        }

        System.out.printf("While picking the same door twice, there were %d/%d wins.\n", counter1, tries);
        System.out.printf("While picking the other door, there were %d/%d wins.", counter2, tries);
    }
}
