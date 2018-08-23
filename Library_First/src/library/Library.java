package library;

import java.util.Scanner;


public class Library {
	public static void main(String[] args) {
		System.out.println("Welcome to library Management 1.0 ");

		// String username_administration ="Maria";
		// String username_password ="Maria";

		String[] admin_array = { "admin", "admin" };
		int numbers = 5;
		boolean[] exist_member = new boolean[numbers]; // we can have 1000 or plus , just want to try manage program //
														// when
		String[] name_member = new String[numbers]; // cap is done - there is better method for this like array list
		String[] family_member = new String[numbers]; // but have some limit for practice
		int[] age_member = new int[numbers];
		char[] gendre = new char[numbers];
		int[] id_book = new int[numbers]; // i combine book and id to know what is book that borrowed with member
		// I supposed that limited book that can borrow is 5

		home_admin(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);

	}

	private static void home_admin(String[] admin_array, boolean[] exist_member, String[] name_member,
			String[] family_member, int[] age_member, char[] gendre, int[] id_book) {

		boolean admin = true;
		while (admin) {

			Scanner input_admin = new Scanner(System.in);
			System.out.println("_____________________________________________________");
			System.out.println("plese give me user name admin:");
			String user_admin = input_admin.nextLine();
			System.out.println("plese give me password  admin:");
			String pass_admin = input_admin.nextLine();
			if (user_admin.equals(admin_array[0]) && pass_admin.equals(admin_array[1])) {
				

				home_page(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);
				
				admin = false;
			}
			System.out.println("Sorry but this username or pasword not exit ...try again...");
		}
	 
	} 

	public static void home_page(String[] admin_array, boolean[] exist_member, String[] name_member,
			String[] family_member, int[] age_member, char[] gendre, int[] id_book) {

		System.out.println("_____________________________________________________");
		System.out.println("Hi  " + admin_array[0] + "!");
		System.out.println("1-Membership managemen");
		System.out.println("2-Book management");
		System.out.println("3-Serach member or book");
		System.out.println("4-Borrowing or recieving book from member");
		System.out.println("5-Change admin user name or password");
		System.out.println("6-Exit");
		System.out.println("_____________________________________________________");
		System.out.println("please select one option between 1 to 6 :");
		boolean exit = true;
		while (exit) {
			Scanner input = new Scanner(System.in);
			int home = input.nextInt();
			switch (home) {
			case 1:
				membership_management(admin_array, exist_member, name_member, family_member, age_member, gendre,
						id_book);
				break;

			case 2:
				book_management();
				break;

			case 3:
				search();
				break;

			case 4:
				Borrowing_recieving();
				break;

			case 5:
				change_admin(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);
				break;
			case 6:
				System.out.println("Thank you ....bye ...");
				break;
			default:
				System.out.println("Gived information is not correct please choose number between 1 to 6 :");

			}
			input.close();
		}

	}

	private static void change_admin(String[] admin_array, boolean[] exist_member, String[] name_member,
			String[] family_member, int[] age_member, char[] gendre, int[] id_book) {
		boolean change = true;
		while (change) {
			Scanner input_admin = new Scanner(System.in);
			System.out.println("pleae give new username :");
			admin_array[0] = input_admin.nextLine();
			System.out.println("pleae give new password :");
			String first_pasword = input_admin.nextLine();
			System.out.println("pleae repeat new password :");
			String secound_pasword = input_admin.nextLine();
			if (first_pasword.equals(secound_pasword)) {
				admin_array[1] = first_pasword;
				System.out.println("user name and pasword changed");
				change = false;

			} else {
				System.out.println("the given password doesnt match...lets try again");
			}
		
		}

		home_admin(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);
	}

	private static void Borrowing_recieving() {
		// TODO Auto-generated method stub

	}

	private static void search() {
		// TODO Auto-generated method stub

	}

	private static void book_management() {
		// TODO Auto-generated method stub

	}

	public static void membership_management(String[] admin_array, boolean[] exist_member, String[] name_member,
			String[] family_member, int[] age_member, char[] gendre, int[] id_book) {

		boolean membership = true;
		while (membership) {
			System.out.println("1-New membership");
			System.out.println("2-Show information");
			System.out.println("3-Edit information");
			System.out.println("4-Delete memebr");
			System.out.println("5-Back home menu");

			Scanner input = new Scanner(System.in);
			String input_membership = input.nextLine();
			switch (input_membership) {
			case "1":
				// we check here if there is no space so we will have another
				if (age_member[age_member.length - 1] == 0) { // array with 2*old size and we will copy old one to
																// new one

					add_new_membership(exist_member, name_member, family_member, age_member, gendre, id_book,
							admin_array);

				} else {

					boolean[] new_exist_memeber = new boolean[exist_member.length * 2];
					String[] new_name_memeber = new String[name_member.length * 2];
					String[] new_family_memeber = new String[family_member.length * 2];
					int[] new_age_memeber = new int[age_member.length * 2];
					char[] new_gendre_memeber = new char[gendre.length * 2];
					int[] new_id_book_memeber = new int[id_book.length * 2];
					for (int j = 0; j < age_member.length; j++) {
						new_exist_memeber[j] = exist_member[j];
						name_member[j] = new_name_memeber[j];
						family_member[j] = new_family_memeber[j];
						age_member[j] = new_age_memeber[j];
						gendre[j] = new_gendre_memeber[j];

						id_book[j] = new_id_book_memeber[j];

					}
					exist_member = new_exist_memeber;
					name_member = new_name_memeber;
					family_member = new_family_memeber;
					age_member = new_age_memeber;
					gendre = new_gendre_memeber;
					id_book = new_id_book_memeber;
					add_new_membership(exist_member, name_member, family_member, age_member, gendre, id_book,
							admin_array);
				}

				break;

			case "2":
				System.out.println("please give me id");
				int show_information = input.nextInt();

				print_work(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book,
						show_information - 100);

				break;

			case "3":
				System.out.println("please give me ID of membership that you want change information:");
				int id_modification = input.nextInt();
				System.out.println("change name to new name:");
				String new_name_member = input.nextLine();
				name_member[id_modification]=new_name_member;
				System.out.println("change family name to ne family name:");
				String new_family_member=input.nextLine();
				family_member[id_modification]=new_family_member;
				System.out.println("Change gendre to new gendre:");
				char new_gendre = input.nextLine().charAt(0);
				gendre[id_modification]=new_gendre;
				System.out.println();

			case "4":

			case "5":
				home_page(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);

			default:
				System.out.println("please give a correct number between 1 to 5");
			}
			input.close();
		}
	}

	private static void add_new_membership(boolean[] exist_member, String[] name_member, String[] family_member,
			int[] age_member, char[] gendre, int[] id_book, String[] admin_array) {
		int empty_block = 0;

		System.out.println("_____________________________________________________");
		for (int i = 0; i < age_member.length; i++) {

			if (age_member[i] == 0) {
				empty_block = i;
				break;
			}
		}
		Scanner input = new Scanner(System.in);
		System.out.println("give me new name for membership:");
		name_member[empty_block] = input.nextLine();
		System.out.println("give me family name for membership:");
		family_member[empty_block] = input.next();
		System.out.println("please give me gendre f or m :");

		boolean gendre_problem = true;
		while (gendre_problem) {
			char gendre_repondre = input.next().charAt(0);
			if (gendre_repondre == 'f' || gendre_repondre == 'm') {
				gendre[empty_block] = gendre_repondre;
				gendre_problem = false;
			} else {
				System.out.println(gendre_repondre + " not in good format " + "please type f or m !");
			}

		}
		System.out.println("please give me age:");
		age_member[empty_block] = input.nextInt();

		// for (int j = 0; j < age_member.length; j++) {

		// if (age_member[j] == 0) {
		System.out.println("*****************************************************");
		String Sex;
		if (gendre[empty_block] == 'f') {
			Sex = " Miss ";
		} else {
			Sex = " Mr ";
		}

		System.out.print("ID for" + Sex + name_member[empty_block] + " " + family_member[empty_block] + " is: ");
		System.out.println((100 + empty_block));
		System.out.println("*****************************************************");
		id_book[empty_block] = empty_block + 100;
		System.out.println("print cart? (type p or b to back):");
		char print = input.next().charAt(0);
		if (print == 'p') {
			System.out.println("TAKE A PICTURE!");
			print_work(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book, empty_block);

		} else {
			membership_management(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);
		}

		input.close();
		// }

		// change }

	}

	private static void print_work(String[] admin_array, boolean[] exist_member, String[] name_member,
			String[] family_member, int[] age_member, char[] gendre, int[] id_book, int id) {

		System.out.println("show cart .......");
		System.out.println("*****************************************************");
		System.out.println("* picture         name: " + name_member[id]);
		System.out.println("* picture  family name: " + family_member[id]);
		System.out.println("* picture       gendre: " + gendre[id]);
		System.out.println("* picture         ID  : " + id_book[id]);
		System.out.println("*****************************************************");
		membership_management(admin_array, exist_member, name_member, family_member, age_member, gendre, id_book);

	}

}
