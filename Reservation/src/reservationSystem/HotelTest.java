package reservationSystem;

import java.util.Scanner;

public class HotelTest {

	public static void main(String[] args) {
		Hotel guest = new Hotel();
		guest.addGuest(new Form("BINGO", 5, false, 3, 1));
		int i = menu();
		while (i > 0 && i < 5) {
			switch (i) {
			case 1: {
				guest.addGuest(Form.addAccount());
				guest.save();
				break;
			}
			case 2: {
				guest.printId(Form.findAccount());
				break;
			}
			case 3: {
				guest.removeGuestById(Form.findAccount());
				guest.save();
				break;
			}
			case 4: {
				guest.display();
				break;
			}
			}
			i = menu();
		}
		System.out.println("End program");
	}

	public static Scanner input() {
		return new Scanner(System.in);
	}

	public static int menu() {
		System.out.printf("1- for add \n2- for search \n"
			+ "3- for delete \n4- for print\n Enter any number to terminate  \n ::");
		return input().nextInt();
	}

}
