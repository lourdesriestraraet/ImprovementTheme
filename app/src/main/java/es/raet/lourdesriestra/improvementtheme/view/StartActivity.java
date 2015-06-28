package es.raet.lourdesriestra.improvementtheme.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.R;
import es.raet.lourdesriestra.improvementtheme.utils.Connectivity;
import es.raet.lourdesriestra.improvementtheme.utils.LogC;
import es.raet.lourdesriestra.improvementtheme.view.alert.Dialog;

public class StartActivity extends Activity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar = (ProgressBar) findViewById(R.id.splash_carga_progress);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            progressBar.animate().setDuration(shortAnimTime).alpha(1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressBar.setVisibility(View.VISIBLE);
                }
            });
        }
        if (Connectivity.weAreConnect()) {
            GetInorivementDataThread getInorivementDataThread = new GetInorivementDataThread();
            getInorivementDataThread.start();
        } else {
            Dialog.show(StartActivity.this,
                    AppGeneral.getContextApp().getString(R.string.need_connection_title),
                    AppGeneral.getContextApp().getString(R.string.need_connection_description),
                    Dialog.SHOW_ERROR, true);
        }
    }

    private class GetInorivementDataThread extends Thread {
        @Override
        public void run() {
            try {
                AppGeneral.getInfoImprovement().getServerData();
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                StartActivity.this.startActivity(intent);
                StartActivity.this.finish();
            } catch (Exception e) {
                LogC.e("Error: get Server Data-> " + e);
                Dialog.show(StartActivity.this,
                        AppGeneral.getContextApp().getString(R.string.error_title),
                        AppGeneral.getContextApp().getString(R.string.error_server),
                        Dialog.SHOW_ERROR, true);
                StartActivity.this.finish();
            }
        }
    }
}
