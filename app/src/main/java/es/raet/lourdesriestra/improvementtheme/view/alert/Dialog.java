package es.raet.lourdesriestra.improvementtheme.view.alert;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.R;

public class Dialog {
    public static final int SHOW_ERROR = -1;

    public static void show(final Activity actividad, final String titulo, final String mensaje, final int accion, final boolean stopAct) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(actividad);

        alertDialogBuilder.setTitle(titulo);
        alertDialogBuilder.setMessage(mensaje);
        alertDialogBuilder.setPositiveButton(AppGeneral.getContextApp().getString(R.string.dialog_acept_button), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (accion == SHOW_ERROR) {
                    if (stopAct) {
                        actividad.finish();
                    } else {
                        dialog.cancel();
                    }
                }
            }
        });
        if (accion != SHOW_ERROR) {
            alertDialogBuilder.setNegativeButton(AppGeneral.getContextApp().getString(R.string.dialog_cancel_button), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
        }

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
