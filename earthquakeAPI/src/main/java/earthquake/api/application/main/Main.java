package earthquake.api.application.main;

import java.io.IOException;
import java.util.Scanner;

import earthquake.api.application.utils.RootUtil;

public class Main {

	public static void main(String[] args) {
		try {
			startConsole();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void startConsole() throws IOException {
		System.out.println("Please enter the country and count of days separated by ',' \n");
		Scanner userInput = new Scanner(System.in);
		String line = "";
		while (true) {
			line = userInput.nextLine();
			if (line.equalsIgnoreCase("exit")) {
				System.out.println("Console closed.");
				userInput.close();
				break;
			}
			RootUtil.printEarthQuakeEvents(line);
		}
	}
}
