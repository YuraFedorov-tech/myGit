
public class Radio implements ElectricConsumer{

	@Override
	public void electricityOn() {
		radioPlays();
		
	}

	private void radioPlays() {
		System.out.println("Radio on");
		
	}

}
