package accessbrowser;

import java.util.Scanner;

public class DemoAccess {

	public static void main(String[] args) {
		AccessChromeBrowser AB = new AccessChromeBrowser();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Which browser you want to use");
		System.out.println("Enter 1 for Chrome and 2 for Mozila Firefox");
		int x = sc.nextInt();
		
		AB.invokeBrowser(x);
		//AB.closeBrowser();
		

	}

}
