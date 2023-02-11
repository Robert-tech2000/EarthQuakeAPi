package earthquake.api.application.services;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

public class EndPoint {

	private static final String API_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";

	public static String getEventsJsonForDates(String startDate, String endDate) throws IOException {
		URL endpointURL = new URL(API_URL + "&starttime=" + startDate + "&endtime=" + endDate);
		String jsonResponse = IOUtils.toString(endpointURL, Charset.forName("UTF-8"));
		return jsonResponse;
	}

}
