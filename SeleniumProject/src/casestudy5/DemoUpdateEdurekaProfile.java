package casestudy5;

import java.util.Scanner;

public class DemoUpdateEdurekaProfile {

	public static void main(String[] args) {
		UpdateEdurekaProfile updateProfile = new UpdateEdurekaProfile();
		System.out.println("In order to improve the Profile...please provide user login details");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email ID");
		String username = sc.nextLine().toString();
		System.out.println("Enter password");
		String password = sc.nextLine().toString();
		updateProfile.invokeBrowser(username, password);

	}

}
