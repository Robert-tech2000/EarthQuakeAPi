package earthquake.api.application.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import earthquake.api.application.models.EarthQuake;
import earthquake.api.application.models.Feature;
import earthquake.api.application.models.Properties;
import earthquake.api.application.models.Root;
import earthquake.api.application.services.EndPoint;

public class RootUtil {

	public static void printEarthQuakeEvents(String line) throws IOException {
		List<EarthQuake> earthQuakeEventsForCountry = returnEarthQuakeEventsCountry(line);
		earthQuakeEventsForCountry.forEach((n) -> System.out.println(n));
	}

	private static ArrayList<EarthQuake> returnEarthQuakeEventsCountry(String userInput) throws IOException {
		Root root = createNewRootObjectFromUserInput(userInput);
		ArrayList<Feature> features = root.getFeatures();
		ArrayList<EarthQuake> earthQuakes = new ArrayList<>();

		for (Feature feature : features) {
			Properties featureProperties = feature.getProperties();
			if (isEarthQuakeEventFromSpecifiedCountry(userInput)) {
				earthQuakes.add(new EarthQuake(featureProperties.getPlace(), featureProperties.getMag(),
						DatesUtil.convertTimeStampToDateString(featureProperties.getTime())));
			}
		}

		return earthQuakes;
	}

	private static Root createNewRootObjectFromUserInput(String userInput) throws IOException {
		ArrayList<String> queryParameters = DatesUtil.getParametersFromUserInput(userInput);
		String jsonResponse = EndPoint.getEventsJsonForDates(queryParameters.get(0), queryParameters.get(1));
		return createNewRootObjectFromJsonResponse(jsonResponse);
	}

	private static Root createNewRootObjectFromJsonResponse(String jsonResponse) {
		ObjectMapper mapper = new ObjectMapper();
		Root root = null;
		try {
			root = mapper.readValue(jsonResponse, Root.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return root;
	}

	private static boolean isEarthQuakeEventFromSpecifiedCountry(String userInput) {
		return true;
	}
}
