package earthquake.api.application.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DatesUtil {

	private static final DateTimeFormatter DATEE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static ArrayList<String> getParametersFromUserInput(String line) throws NumberFormatException {
		String[] parameters = line.split(",");
		// Calculates start and end date based on Days count.
		ArrayList<String> queryParameters = calculateStartAndEndDates(Integer.parseInt(parameters[1].strip()));
		// Adds the country string to quesryParameters.
		queryParameters.add(parameters[0].strip());

		return queryParameters;
	}

	public static String convertTimeStampToDateString(Object date) {
		return date.toString();
	}

	private static ArrayList<String> calculateStartAndEndDates(int daysCount) {
		LocalDateTime now = LocalDateTime.now();
		ArrayList<String> startAndEndDate = new ArrayList<>();

		startAndEndDate.add(DATEE_FORMAT.format(now.minusDays(daysCount)));
		startAndEndDate.add(DATEE_FORMAT.format(now));

		return startAndEndDate;
	}

}
