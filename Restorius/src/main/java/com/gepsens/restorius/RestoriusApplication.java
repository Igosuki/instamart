package com.gepsens.restorius;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by geps on 8/15/13.
 */
public class RestoriusApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "NpkkdCWUFBFewPJQeRr9na7uOvV9xOrbjffTcJcv", "XkgYgwDuO7vG6EedaApHincZtEVW36CRbIbVbpr9");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
