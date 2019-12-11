import java.util.ArrayList;
import java.util.List;

public class Switcher {
	private List<ElectricConsumer> electricConsumer;

	public Switcher() {
		electricConsumer=new ArrayList<>();
	}

	public void addElectricConsumerList(ElectricConsumer listener) {
		electricConsumer.add(listener);
	}
	public void removeElectricConsumerList(ElectricConsumer listener) {
		electricConsumer.remove(listener);
	}
	
	void switchOn() {
		System.out.println("Switch On");
		//if (electricConsumer != null)
		//	electricConsumer.electricityOn();
		for(ElectricConsumer listener:electricConsumer)
			listener.electricityOn();

	}
}
