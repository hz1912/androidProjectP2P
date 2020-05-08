package common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class MyApplication extends Application {

    public static Context context;

    public static Handler handler;

    public static Thread mainThread;

    public static int treadiId = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        this.handler = new Handler();
        this.mainThread = Thread.currentThread();
    }
}
