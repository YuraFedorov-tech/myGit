
import java.text.NumberFormat;
import static java.lang.System.out;


 class Account {
	String LastName;
	int Id;
	double Cost;
	
	void Display(){
		NumberFormat currency =NumberFormat.getCurrencyInstance();
		out.print("� ���������  ");
		out.print(LastName);
		out.print("  �� ����� ");
		out.print(Id);
		out.print("  �������=");
		out.println(currency.format(Cost));
	}

}
