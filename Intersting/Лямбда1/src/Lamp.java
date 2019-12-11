
public class Lamp implements ElectricConsumer {
	void lightOn() {
		System.out.println("Lamp on");
	}

	@Override
	public void electricityOn() {
		lightOn();

	}

}
