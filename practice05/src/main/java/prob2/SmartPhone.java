package prob2;

public class SmartPhone extends MusicPhone{

	public void execute(String function) {
		if(function.equals("음악")) {
			super.execute(function);
		}
		else if(function.equals("통화")) {
			super.execute(function);
		}
		else if(function.equals("앱")) {
			this.app();
		}
	}
	
	private void app() {
		System.out.println("앱실행");
	}
}
