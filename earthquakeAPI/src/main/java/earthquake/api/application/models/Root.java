package earthquake.api.application.models;

import java.util.ArrayList;
import java.util.List;

public class Root {

	public String type;
	public Metadata metadata;
	public ArrayList<Feature> features;
	public List<Double> bbox = new ArrayList<>();

	public class Metadata {
		public long generated;
		public String url;
		public String title;
		public int status;
		public String api;
		public int count;
	}
}
