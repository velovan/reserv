package reservationSystem;

import java.io.Serializable;
import java.util.Scanner;

public class Form implements Serializable {
	private String name;
	private int days;
	private boolean breakfast;
	private int roomType;
	private int id;

	public Form(String name, int days, boolean breakfast, int roomType, int id) {
		this.name = name;
		this.days = days;
		this.breakfast = breakfast;
		this.roomType = roomType;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double costs() {
		return days * (roomType * 0.63) * 93;
	}

	public String roomType(int roomType) {
		switch (roomType) {
		case 1:
			return "economy";
		case 2:
			return "Super";
		case 3:
			return "VIP";
		default:
			return "invalid";
		}
	}

	@Override
	public String toString() {
		return "[ name=" + name + ", days=" + days + ", breakfast=" + breakfast + ", roomType=" + roomType(roomType)
		+ ", Price=" + costs() + "SR" + ", id=" + id + " ]" + "\n";
	}

	public boolean equals(Object other) {
		return this.id == ((Form) other).getId();
	}

	public static Form addAccount() {
		System.out.println("Enter Account Information :: ");
		System.out.print("Id: ");
		try {
			int id = input().nextInt();
			System.out.print("Name: ");
			String name = input().next();
			System.out.print("Days: ");
			int days = input().nextInt();
			System.out.print("Breakfast included?: true/false  ");
			boolean breakfast = input().nextBoolean();
			System.out.print("What is roomType?: 1/2/3  ");
			int roomType = input().nextInt();
			System.out.println();
			return new Form(name, days, breakfast, roomType, id);
		} catch (Exception e) {
			System.out.println("invalid input\n");
		}
		return null;
	}
	
	public static Form findAccount(){
		System.out.println("Enter the ID plese :: ");
		int id = input().nextInt();
		return new Form("", 0, true, 1, id);
	}
	
	private static Scanner input() {
		return new Scanner(System.in);
	}
	
}
