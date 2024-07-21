package utils;

public class Config {
    public static String WINDOW_SIZE = System.getProperty("windowSize");
    public static final boolean HEADLESS_MODE = Boolean.parseBoolean(System.getProperty("headlessMode", "false"));
    public static final boolean FULL_STEPS = Boolean.parseBoolean(System.getProperty("fullSteps","false"));
    public static final String WEB_DRIVER = System.getProperty("webDriver", "chrome");
    public static final String WEB_DRIVER_WAIT = System.getProperty("webDriverWait", "60");
    public static final String LANGUAJE = System.getProperty("language", "EN");


}
