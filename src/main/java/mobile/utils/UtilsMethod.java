package mobile.utils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilsMethod {
    static Properties config = new Properties();

    static {
        try (InputStream input = UtilsMethod.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                log.error("Unable to find config.properties");
            }
            config.load(input);
        } catch (Exception e) {
            log.error("Failed to load configuration");
            throw new IllegalStateException();
        }
    }

    public static String getValue (String key) {
        if (key.equalsIgnoreCase("user_email")) {
            return generateDynamicEmail();
        }
        return config.getProperty(key);
    }

    public static String generateDynamicEmail() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = simpleDateFormat.format(new Date());
        return "email" + timestamp + "@test.ru";
    }
}
