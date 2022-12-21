package tv;

public class TV {
	private int channel;    //1~255 -> 한칸 올리면 0, +1/+2/+3 = 1
	private int volume;		//0~100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(channel < 1) {
			channel = 255;
		}else if(channel > 255) {
			channel = 1;
		};
	}
	
	public void channel(boolean up) {
		//up & down
		if(up) {
			channel += 1;
		} else {
			channel -= 1;
		}
	}
	
	public void volume(int volume) {
		if(volume < 1) {
			volume = 100;
		}else if(volume > 100) {
			volume = 1;
		};
	}
	
	public void volume(boolean up) {
		//up & down
		if(up) {
			volume += 1;
		} else {
			volume -= 1;
		}
	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on":"off") + ", " + "channel=" + channel + ", " + "volume=" + volume + "]");
	}
}
