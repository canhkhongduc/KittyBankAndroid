package gamification.kitty.hackathon.kittybank.enums;

/**
 * Created by User on 4/20/2018.
 */

public enum ERestApiEndpoints {
    GET_KITTIES_ENDPOINT("api/kitty"),
    GET_FOODS_ENDPOINT("api/food"),
    POST_BUY_ITEM_BY_ID("api/food/buy"),
    GET_ITEM_STORE_ENDPOINT("api/food/store"),
    GET_KITTY_BY_ID_ENDPOINT("api/kitty"),
    POST_AUTHENTICATE("api/user/authenticate"),
    POST_UPDATE_TRANSACTION("api/transaction"),
    GET_FEED_KITTY_ENDPOINT("api/kitty/feed"),
    GET_BATH_KITTY_ENDPOINT("api/kitty/bath");

    private final String HOST_URL = "http://35.202.69.66:8081/";

    private String fullEndpoint;

    ERestApiEndpoints(String url) {
        fullEndpoint = HOST_URL + url;
    }

    public String getFullEndpoint() {
        return fullEndpoint;
    }

    public String getFullEndpointWithSpecificId(int id) {
        return getFullEndpoint() + "/" + id;
    }

    @Override
    public String toString() {
        return getFullEndpoint();
    }
}
