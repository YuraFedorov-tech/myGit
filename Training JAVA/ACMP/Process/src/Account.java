
import java.text.NumberFormat;
import static java.lang.System.out;


 class Account {
	String LastName;
	int Id;
	double Cost;
	
	void Display(){
		NumberFormat currency =NumberFormat.getCurrencyInstance();
		out.print("у господина  ");
		out.print(LastName);
		out.print("  на счету ");
		out.print(Id);
		out.print("  остаток=");
		out.println(currency.format(Cost));
	}

}
