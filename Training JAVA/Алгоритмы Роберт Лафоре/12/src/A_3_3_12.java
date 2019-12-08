
public class A_3_3_12  {

	public static void main(String[] args) {
			Human fir = new Human();
			Human sec = new Human(3, "Rrrr", "Fsrh", "dftsh");
			Human lasy = new Human(3, "asrh", "asrh");

		
		}
		public static class Human {
		    //аст (age), имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport).
			private int age;
			private String name;
			private String secondName;
			private String favoriteSport;

			public Human() {
			}
			public Human(int i, String s, String s1, String j) {
				age = i;
				name = s;
				secondName = s1;
				favoriteSport = j;
			}

			public Human(int i, String s, String s1) {
				age = i;
				name = s;
				secondName = s1;
			}
		}		
	}


