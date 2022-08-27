/******************************************************************************
  _________    _____    .___  ___________ ___________ 
 /   _____/   /     \   |   | \__    ___/ \_   _____/   God Picker
 \_____  \   /  \ /  \  |   |   |    |     |    __)_    
 /        \ /    Y    \ |   |   |    |     |        \   ENTER to re-roll  
/_______  / \____|__  / |___|   |____|    /_______  /   'exit' to terminate
        \/          \/                            \/ 
*******************************************************************************/
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Main
{
	public static void main(String[] args) throws Exception {
	    int NUM_GODS = 122;
	    System.out.print("Loading gods.txt ... ");
	    
	    File gods_file = new File("gods.txt");
	    
	    if (gods_file.exists()) {
	        System.out.println("complete!");
	        clear();
	    } else {
	        System.out.println("FAILED (does not exist)");
	        System.exit(0);
	    }
	    
		Scanner gods_sc = new Scanner(gods_file);
		String[] gods = new String[NUM_GODS];
		int result;
		
		for (int i = 0; i < NUM_GODS; i++) {
		    gods[i] = gods_sc.nextLine();
		}
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		while (!input.equals("exit")) {
		    System.out.println("SMITE GOD PICKER (9.8)");
    		System.out.println("* NOT ACCURATE FOR IN-MATCH SELECTION MENU *\n");
    		result = 0;
    		
    		int scroll = rand.nextInt(8);
    		if (scroll == 1) {
    		    System.out.println("Scroll " + scroll + " time "); // 11
    		} else {
    		    System.out.println("Scroll " + scroll + " times");
    		}
    		result += (scroll * 11);
    		
    		int row = rand.nextInt(4) + 1;
    		System.out.println("Row " + row); // 5
    		result += ((row - 1) * 11);
    		
    		int col = rand.nextInt(11) + 1;
    		System.out.println("Column " + col + "\n"); // 8
    		result += (col - 1);
    		
    		System.out.println(gods[result] + "\n");
    		
    		input = sc.nextLine();
    		
    		clear();
		}
	}
	
	public static void clear() {
	    System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
}