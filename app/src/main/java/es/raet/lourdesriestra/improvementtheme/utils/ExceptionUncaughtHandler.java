package es.raet.lourdesriestra.improvementtheme.utils;

import android.content.Context;
import android.content.Intent;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUncaughtHandler implements java.lang.Thread.UncaughtExceptionHandler {
    private final Class<?> myActivityClass;
    private final Context myContext;

    public ExceptionUncaughtHandler(Context context, Class<?> c) {

        myContext = context;
        myActivityClass = c;
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        LogC.e(stackTrace.toString());
        Intent intent = new Intent(myContext, myActivityClass);
        String s = stackTrace.toString();
        LogC.e("New captured exception. It had not produced this error " + s);
        intent.putExtra("uncaughtException",
                "Exception is: " + stackTrace.toString());
        intent.putExtra("stacktrace", s);
        myContext.startActivity(intent);
        //for restarting the Activity
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}