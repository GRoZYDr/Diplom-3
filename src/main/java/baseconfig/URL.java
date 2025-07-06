package baseconfig;

public class URL {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api";

    public static String getBaseUri() {
        if (System.getProperty("host") != null) {
            return System.getProperty("host");
        } else {
            return BASE_URI;
        }
    }
}
