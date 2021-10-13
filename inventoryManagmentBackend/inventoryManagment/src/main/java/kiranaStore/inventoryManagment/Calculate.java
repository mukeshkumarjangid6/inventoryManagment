package kiranaStore.inventoryManagment;

public class Calculate {
	int a;
	int b;

	public Calculate(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int add() {
		return a + b;
	}

	public boolean isEvenNo() {
		add();
		if (add() % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}
}
