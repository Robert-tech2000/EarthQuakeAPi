package earthquake.api.application.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatesUtil {

	private static final DateTimeFormatter DATEE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static List<String> getParametersFromUserInput(String line) throws NumberFormatException {
		String[] parameters = line.split(",");

		// Calculates start and end date based on Days count
		List<String> queryParameters = calculateStartAndEndDates(Integer.parseInt(parameters[1].strip()));

		// Add the country string to quesryParameters
		queryParameters.add(parameters[0].strip());

		return queryParameters;
	}

	private static List<String> calculateStartAndEndDates(int daysCount) {
		LocalDateTime now = LocalDateTime.now();
		List<String> startAndEndDate = new ArrayList<>();

		startAndEndDate.add(DATEE_FORMAT.format(now.minusDays(daysCount)));
		startAndEndDate.add(DATEE_FORMAT.format(now));

		return startAndEndDate;
	}

}
