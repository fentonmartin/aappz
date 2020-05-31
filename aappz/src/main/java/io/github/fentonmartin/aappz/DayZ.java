package io.github.fentonmartin.aappz;

import java.util.Calendar;

@SuppressWarnings({"WeakerAccess", "unused"})
public class DayZ {

    /* Static day state */
    public static final int DAY_MORNING = 1;
    public static final int DAY_AFTERNOON = 2;
    public static final int DAY_EVENING = 3;
    public static final int DAY_NIGHT = 4;

    /* Static default day state */
    private static final int DEFAULT_START_MORNING = 5;
    private static final int DEFAULT_START_AFTERNOON = 12;
    private static final int DEFAULT_START_EVENING = 17;
    private static final int DEFAULT_START_NIGHT = 20;

    /* Static greet day state */
    private static final String DAY_GREET_MORNING = "Good morning";
    private static final String DAY_GREET_AFTERNOON = "Good afternoon";
    private static final String DAY_GREET_EVENING = "Good evening";
    private static final String DAY_GREET_NIGHT = "Good night";

    /**
     * Get current day state
     * <p>
     * return static int value (DAY_MORNING, DAY_AFTERNOON, DAY_EVENING, or DAY_NIGHT)
     *
     * @return the result
     */
    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return getCurrentDay(calendar, DEFAULT_START_MORNING, DEFAULT_START_AFTERNOON, DEFAULT_START_EVENING, DEFAULT_START_NIGHT);
    }

    /**
     * Get day state from Calendar
     * <p>
     * return static int value of DAY_MORNING, DAY_AFTERNOON, DAY_EVENING, or DAY_NIGHT
     *
     * @param calendar the calendar time
     * @return the result
     */
    public static int getCurrentDay(Calendar calendar) {
        return getCurrentDay(calendar, DEFAULT_START_MORNING, DEFAULT_START_AFTERNOON, DEFAULT_START_EVENING, DEFAULT_START_NIGHT);
    }

    /**
     * Get current day state with custom 24 hours
     * <p>
     * return static int value of DAY_MORNING, DAY_AFTERNOON, DAY_EVENING, or DAY_NIGHT
     *
     * @param morning   the morning state
     * @param afternoon the afternoon state
     * @param evening   the evening state
     * @param night     the night state
     * @return the result
     */
    public static int getCurrentDay(int morning, int afternoon, int evening, int night) {
        Calendar calendar = Calendar.getInstance();
        return getCurrentDay(calendar, morning, afternoon, evening, night);
    }

    /**
     * Get current day state from Calendar with custom 24 hours
     * <p>
     * return static int value of DAY_MORNING, DAY_AFTERNOON, DAY_EVENING, or DAY_NIGHT
     *
     * @param calendar  the calendar time
     * @param morning   the morning state
     * @param afternoon the afternoon state
     * @param evening   the evening state
     * @param night     the night state
     * @return the result
     */
    public static int getCurrentDay(Calendar calendar, int morning, int afternoon, int evening, int night) {
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if (hours > morning && hours < afternoon)
            return DAY_MORNING;
        else if (hours > afternoon && hours < evening)
            return DAY_AFTERNOON;
        else if (hours > evening && hours < night)
            return DAY_EVENING;
        else
            return DAY_NIGHT;
    }

    /**
     * Get day greet from Calendar
     * <p>
     * return static String greet value of DAY_GREET_MORNING, DAY_GREET_AFTERNOON, DAY_GREET_EVENING, or DAY_GREET_NIGHT
     *
     * @param calendar the calendar time
     * @return the result
     */
    public static String getGreetDay(Calendar calendar) {
        return getGreetDay(calendar, DAY_GREET_MORNING, DAY_GREET_AFTERNOON, DAY_GREET_EVENING, DAY_GREET_NIGHT);
    }

    /**
     * Get day greet from Calendar
     * <p>
     * return static String value of custom greets
     *
     * @param calendar       the calendar time
     * @param greetMorning   the morning greet
     * @param greetAfternoon the afternoon greet
     * @param greetEvening   the evening greet
     * @param greetNight     the night greet
     * @return the result
     */
    public static String getGreetDay(Calendar calendar, String greetMorning, String greetAfternoon, String greetEvening, String greetNight) {
        switch (getCurrentDay(calendar, DEFAULT_START_MORNING, DEFAULT_START_AFTERNOON, DEFAULT_START_EVENING, DEFAULT_START_NIGHT)) {
            case DAY_MORNING:
                return greetMorning;
            case DAY_AFTERNOON:
                return greetAfternoon;
            case DAY_EVENING:
                return greetEvening;
            case DAY_NIGHT:
                return greetNight;
            default:
                return "";
        }
    }

    /**
     * Get day greet with name from Calendar
     * <p>
     * return static String greet value with name
     *
     * @param calendar the calendar time
     * @param name     the greet name
     * @return the result
     */
    public static String getGreetDay(Calendar calendar, String name) {
        return getGreetDay(calendar, DAY_GREET_MORNING, DAY_GREET_AFTERNOON, DAY_GREET_EVENING, DAY_GREET_NIGHT) + ", " + name + ".";
    }

    /**
     * Get day greet with name from Calendar
     * <p>
     * return static String value of custom greets with name
     *
     * @param calendar       the calendar time
     * @param name           the greet name
     * @param greetMorning   the morning greet
     * @param greetAfternoon the afternoon greet
     * @param greetEvening   the evening greet
     * @param greetNight     the night greet
     * @return the result
     */
    public static String getGreetDay(Calendar calendar, String name, String greetMorning, String greetAfternoon, String greetEvening, String greetNight) {
        switch (getCurrentDay(calendar, DEFAULT_START_MORNING, DEFAULT_START_AFTERNOON, DEFAULT_START_EVENING, DEFAULT_START_NIGHT)) {
            case DAY_MORNING:
                return greetMorning + ", " + name + ".";
            case DAY_AFTERNOON:
                return greetAfternoon + ", " + name + ".";
            case DAY_EVENING:
                return greetEvening + ", " + name + ".";
            case DAY_NIGHT:
                return greetNight + ", " + name + ".";
            default:
                return "";
        }
    }
}
