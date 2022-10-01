package manage;

public class Validate {
	
	public static int validateInteger(int limit) {
		int value = 0;
		boolean handled = false;
		while(!handled) {
			try {
				value = Integer.parseInt(Main.in.nextLine());
				if(0 <= value && value <= limit)
					handled = true;
			}
			catch(Exception e){
				System.out.print("Enter valid number! : ");
			}
		}
		return value;
	}
	
	public static String validateName() {
		String value = "";
		boolean handled = false;
		while(!handled) {
			try {
				value = Main.in.nextLine();
				String copy = value.replaceAll("\\s|\\d", "");
				System.out.print("copy"+copy+"copy");
				if(value.equals("")||copy.equals("")) {
					throw new Exception();
				}
				else
					handled = true;
			}
			catch(Exception e) {
				System.out.println("Enter valid name! : ");
			}
		}
		return value;
	}
}