package earthquake.api.application.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import earthquake.api.application.models.Root;
import earthquake.api.application.services.EndPoint;

public class RootUtil {

	public static Root createNewRootObjectFromUserInput(String userInput) throws IOException {
		List<String> queryParameters = DatesUtil.getParametersFromUserInput(userInput);

		String jsonResponse = EndPoint.getEventsJsonForDates("2022-01-01", "2022-01-05");
//		String jsonResponse = EndPoint.getEventsJsonForDates(queryParameters.get(0), queryParameters.get(1));
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
}
