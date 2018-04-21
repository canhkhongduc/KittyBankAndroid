package gamification.kitty.hackathon.kittybank.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import gamification.kitty.hackathon.kittybank.entity.User;

/**
 * Created by User on 4/20/2018.
 */

public class Utils {
    /**
     * Encode parameters as a map to byte[] with custom encoding type
     *
     * @param params - A map contains key and value pairs
     * @param paramsEncoding - An encoding type
     * @return - an array of byte form of the passed map
     */
    public static byte[] encodeParams(Map<String, String> params, String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }
    public static void saveUserToSharedPreferences(Context context, User user){
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor preferenceEditor = preference.edit();
        preferenceEditor.putInt("userId", user.getId());
        preferenceEditor.putString("accountNumber", user.getAccountNumber());
        preferenceEditor.putString("fullName", user.getFullName());
        preferenceEditor.apply();

    }
    public static User getUserFromSharedPreference(Context context){
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(context);
        int id = preference.getInt("userId", 0);
        String accountNumber = preference.getString("accountNumber", null);
        String fullName = preference.getString("fullName", null);
        User user = new User();
        user.setId(id);
        user.setFullName(fullName);
        user.setAccountNumber(accountNumber);
        return user;
    }

}

