package io.github.fentonmartin.aappz.util;

import java.util.Calendar;

@SuppressWarnings({"WeakerAccess", "unused"})
public class DayZ {

    /* Static day state */
    public static int DAY_MORNING = 1;
    public static int DAY_AFTERNOON = 2;
    public static int DAY_EVENING = 3;
    public static int DAY_NIGHT = 4;

    /* Static default day state */
    private static int DEFAULT_START_MORNING = 5;
    private static int DEFAULT_START_AFTERNOON = 12;
    private static int DEFAULT_START_EVENING = 17;
    private static int DEFAULT_START_NIGHT = 20;

    /**
     * Get current day state
     * <p>
     * return static int value (DAY_MORNING, DAY_AFTERNOON, DAY_EVENING, or DAY_NIGHT)
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

}
