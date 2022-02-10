package sv.edu.udb.lifecycleapp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifeCycleObserver implements LyfecycleObserver{
    private static final String TAG="MyLifeCycleObserver";
    private MainActivity obj;

    public MyLifeCycleObserver(MainActivity mainActivity){
        this.obj=mainActivity;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE) void onCreate(){
        Log.i(TAG,"OnCreate");
        Toast.makeText(this.obj,"OnCreate",Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START) void onStart(){
        Log.i(TAG,"OnStart");
        Toast.makeText(this.obj,"OnStart",Toast.LENGTH_SHORT).show();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) void onResume(){
        Log.i(TAG,"OnResume");
        Toast.makeText(this.obj,"OnResume",Toast.LENGTH_SHORT).show();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP) void onStop(){
        Log.i(TAG,"OnStop");
        Toast.makeText(this.obj,"OnStop",Toast.LENGTH_SHORT).show();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY) void onDestroy(){
        Log.i(TAG,"OnDestroy");
        Toast.makeText(this.obj,"OnDestroy",Toast.LENGTH_SHORT).show();
    }
}
