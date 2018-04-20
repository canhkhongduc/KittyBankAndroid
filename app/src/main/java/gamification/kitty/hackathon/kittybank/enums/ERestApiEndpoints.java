package gamification.kitty.hackathon.kittybank.enums;

/**
 * Created by User on 4/20/2018.
 */

public enum ERestApiEndpoints {
    GET_KITTIES_ENDPOINT("api/kitty"),
    GET_FOODS_ENDPOINT("api/kitty"),
    GET_KITTY_BY_ID_ENDPOINT("api/kitty");

    private final String HOST_URL = "http://10.0.2.2:8081/";

    private String fullEndpoint;

    ERestApiEndpoints(String url) {
        fullEndpoint = HOST_URL + url;
    }

    public String getFullEndpoint() {
        return fullEndpoint;
    }

    @Override
    public String toString() {
        return getFullEndpoint();
    }
}
