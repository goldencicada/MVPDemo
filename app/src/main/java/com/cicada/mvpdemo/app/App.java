package com.cicada.mvpdemo.app;

import android.app.Application;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe application
 * @email gcicada@163.com
 */
public class App extends Application {

    public volatile static  App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static App getInstance(){
        if (instance == null) {
            synchronized (App.class) {
                instance = new App();
            }
        }
        return instance;
    }
}
