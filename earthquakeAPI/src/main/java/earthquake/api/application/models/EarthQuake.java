package earthquake.api.application.models;

public class EarthQuake {

	private double magnitude;
	private String place;
	private Object time;

	public EarthQuake(String place, double magnitude, Object time) {
		this.time = time;
		this.place = place;
		this.magnitude = magnitude;
	}

	public double getMag() {
		return magnitude;
	}

	public String getPlace() {
		return place;
	}

	public Object getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Earth Quake Event: [" + getPlace() + "; " + getTime().toString() + "; " + getMag() + "]";
	}
}
