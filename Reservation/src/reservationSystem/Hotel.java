package reservationSystem;

public class Hotel {

	private static LinkedListImpl<Form> accounts = new LinkedListImpl<Form>();
	private static final String fileName = "Reservation.db";

	public Hotel() {
		load();
	}

	public void addGuest(Form acc) {
		accounts.add(acc);
	}

	public boolean save() {
		try {
			SaveLoad.save(fileName, accounts);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean load() {
		try {
			accounts = (LinkedListImpl<Form>) SaveLoad.load(fileName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void removeGuestByIndex(int index) {
		accounts.removeByIndex(index);
	}

	public void removeGuestById(Form id) {
		accounts.removeById(id);
		save();
	}

	public void printId(Form id) {
		try {
			System.out.println(accounts.findById(id).data);
		} catch (Exception e) {
			System.out.println("Invalid ID");
		}
	}

	public void display() {
		System.out.println(accounts);
	}
}
