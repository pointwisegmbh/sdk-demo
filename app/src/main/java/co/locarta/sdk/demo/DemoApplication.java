package co.locarta.sdk.demo;

import android.app.Application;

import co.locarta.sdk.LocartaSdk;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialise SDK on App creation
        LocartaSdk.initialize(getApplicationContext());
    }
}
