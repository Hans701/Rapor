package com.example.rapor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.rapor.model.login.LData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String NAME = "name";
    public static final String NOMOR_INDUK = "nomor_induk";
    public static final String EMAIL = "email";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(NAME, user.getName());
        editor.putString(NOMOR_INDUK, user.getNomorInduk());
        editor.putString(EMAIL, user.getEmail());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME,null));
        user.put(NOMOR_INDUK, sharedPreferences.getString(NOMOR_INDUK,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL,null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}

