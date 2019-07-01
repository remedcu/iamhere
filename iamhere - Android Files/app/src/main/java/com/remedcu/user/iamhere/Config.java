package com.remedcu.user.iamhere;

/**
 * Created by user on 23-Feb-17.
 */
public class Config {
        //URL to our login.php file
        public static final String LOGIN_URL = "http://192.168.211.1/Remedcu/login.php";

        public static final String KEY_NAME = "Name";
        public static final String KEY_EMAIL = "Email";
        public static final String KEY_PASSWORD = "Password";

        //If server response is equal to this that means login is successful
        public static final String LOGIN_SUCCESS = "success";

        //Keys for Sharedpreferences
        //This would be the name of our shared preferences
        public static final String SHARED_PREF_NAME = "iamhere";

        //This would be used to store the email of current logged in user
        public static String EMAIL_SHARED_PREF = null;
//        public static final String EMAIL_SHARED_PREF = "name";

        //We will use this to store the boolean in sharedpreference to track user is loggedin or not
        public static String LOGGEDIN_SHARED_PREF = "loggedin";
    }
