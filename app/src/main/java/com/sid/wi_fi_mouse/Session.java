package com.sid.wi_fi_mouse;

/*
  Created by Siddharth Sonawane on 14-April-2021.
  Siddharth Sonawane
 K.B.H. Polytechnic Malegaon,
 Nashik-423 205, India
 */

/*Copyright Siddharth Sonawane
 *Copyright infringement is the use of works protected by copyright law
 * without permission, infringing certain exclusive rights granted to the copyright holder,
 * such as the right to reproduce, distribute, display or perform the protected work, or to make derivative works.
 * It is a punishable offence under Copyright Act, 1957
 */


import android.content.Context;
import android.content.SharedPreferences;



public class Session {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "snow-intro-slider";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public Session(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
/*
  Created by Siddharth Sonawane on 14-April-2021.
  Siddharth Sonawane
 K.B.H. Polytechnic Malegaon,
 Nashik-423 205, India
 */
}