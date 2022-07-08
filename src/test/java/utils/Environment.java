package utils;

public class Environment {
    public static final String browser = ConfigReader.getProperty("browser");
    public static final String platformName = ConfigReader.getProperty("platformName");
    public static final String deviceName = ConfigReader.getProperty("deviceName");
    public static final boolean isMobile = Boolean.parseBoolean(ConfigReader.getProperty("isMobile"));
}
