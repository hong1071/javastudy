package tv;

public class TV {
	
	private int channel;		// 1 ~ 255
	private int volume;			// 0 ~ 100, power가 켜져있지 않으면 실행되지 않음.
	private boolean power;		// 
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void status() {
		
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}

	public void power(boolean on) {
		this.power = on;
	}

	public void volume(int volume) {
		if(this.power) {
			this.volume = volume;
		}
		else {
			this.volume = 0;
			System.out.println("TV 전원이 꺼져있습니다.");
		}
	}
	
	public void volume(boolean VolControl) {
		if(this.power) {
			if(VolControl) {
				volume++;
			}
			else {
				volume--;
			}
		}
		else {
			this.volume = 0;
			System.out.println("TV 전원이 꺼져있습니다.");
		}
		
	}
	
	public void channel(int channelNum) {
		if(this.power) {
			this.channel = channelNum;
		}
		else {
			this.channel = 0;
			System.out.println("TV 전원이 꺼져있습니다.");
		}
	}

	public void channel(boolean CHcontrol) {
		if(this.power) {
			if(CHcontrol) {
				channel++;
			}
			else {
				channel--;
			}
		}
		else {
			this.channel = 0;
			System.out.println("TV 전원이 꺼져있습니다.");
		}
		
	}

	

	
	
	

}
