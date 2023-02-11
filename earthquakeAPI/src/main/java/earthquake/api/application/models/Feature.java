package earthquake.api.application.models;

import java.util.ArrayList;
import java.util.List;

public class Feature {

	public String type;
	public Properties properties;
	public String id;
	public Geometry geometry;

	public Properties getProperties() {
		return properties;
	}

	static class Geometry {
		public String type;
		public List<Double> coordinates = new ArrayList<>();
	}
}
