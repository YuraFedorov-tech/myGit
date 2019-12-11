import java.util.Random;
class Proc {

	public static void main(String[] args) {
		Random myRandom= new Random();
		Account AnAccount;
		for (int i=0; i<3; i++)   {
			AnAccount=new Account();
			AnAccount.LastName=""
					+(char)(myRandom.nextInt(26)+'A')
					+(char)(myRandom.nextInt(26)+'a')
					+(char)(myRandom.nextInt(26)+'a');
			AnAccount.Id=myRandom.nextInt(10000);
			AnAccount.Cost=myRandom.nextInt(100000000);
			AnAccount.Cost=AnAccount.Cost/20;
			AnAccount.Display();
		}
		
		
		
		

	}

}
