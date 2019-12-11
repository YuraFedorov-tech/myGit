
public class lam1 {
public static void allSaved() {
	System.out.println("fire extinguishing all saved");
}
	public static void main(String[] args) {
		Switcher switcher = new Switcher();
		ElectricConsumer lamp = new Lamp();
		ElectricConsumer radio = new Radio();
		switcher.addElectricConsumerList(lamp);
		switcher.addElectricConsumerList(radio);

		switcher.addElectricConsumerList(new ElectricConsumer() {
			@Override
			public void electricityOn() {
				System.out.println("Fire");
			}
		});

		switcher.addElectricConsumerList(() -> System.out.println("fire extinguishing"));
		switcher.addElectricConsumerList(lam1::allSaved);
		switcher.switchOn();
	}

}
