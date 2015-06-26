package es.raet.lourdesriestra.improvementtheme.utils;

import android.util.Log;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.BuildConfig;
import es.raet.lourdesriestra.improvementtheme.R;

/**
 * Se crea esta clase para atomatizar codigo repetido en la clase de Log
 */
public class LogC {
	private static final String CONSTRUCTOR_NOMBRE = "<init>";

	/**
	 * Log de Debug. Por defecto el TAG es el nombre de la clase desde la que se
	 * le llama, si isDebugAllApp = true se mostrara en la pantalla de logcat
	 *
	 * @param msg Mensaje que se quiere enviar
	 * @return valor devuelto por Log
	 */
	public static int d(final String msg) {
		return BuildConfig.IS_DEBUG ? Log.d(getFileName(), getMethodName() + msg) : 0;
	}

	/**
	 * Devuelve el nombre del metodo desde el que se ha llamado
	 *
	 * @return
	 */
	private static String getMethodName() {
		String name_method = Thread.currentThread().getStackTrace()[4].getMethodName();
		if (CONSTRUCTOR_NOMBRE.equalsIgnoreCase(name_method)) {
			return Thread.currentThread().getStackTrace()[4].getFileName()
					.substring(0, (Thread.currentThread().getStackTrace()[4].getFileName()).indexOf('.')) + " Constructor:: ";
		}
		return name_method + ":: ";
	}

	/**
	 * Devuelve el nombre de la clase desde la que se ha llamado
	 *
	 * @return
	 */
	private static String getFileName() {
		return AppGeneral.getContextApp().getString(R.string.app_name) + "-" + Thread.currentThread().getStackTrace()[4].getFileName()
				.substring(0, (Thread.currentThread().getStackTrace()[4].getFileName()).indexOf('.'));
	}

	/**
	 * Log debug normal de Android, si isDebugAllApp = true se mostrara en la pantalla de logcat
	 *
	 * @param TAG Etiqueta identificativa
	 * @param msg Mensaje que se quiere enviar
	 * @return valor devuelto por Log
	 */
	public static int d(final String TAG, final String msg) {
		return BuildConfig.IS_DEBUG ? Log.d(TAG, getMethodName() + msg) : 0;
	}

	/**
	 * Log error normal de Android
	 *
	 * @param TAG Etiqueta identificativa
	 * @param msg Mensaje que se quiere enviar
	 * @return
	 */
	public static int e(final String TAG, final String msg) {
		return Log.e(TAG, getMethodName() + msg);
	}

	/**
	 * Log de error. Por defecto el TAG es el nombre de la clase desde la que se
	 * le llama
	 *
	 * @param msg Mensaje que se quiere enviar
	 * @return
	 */
	public static int e(final String msg) {
		return Log.e(getFileName(), getMethodName() + msg);
	}

	/**
	 * Con este log, permitimos enviar un log para crear alarmas en el servidor.
	 *
	 * @param cod codigo de error definido en CodifosErrorEnvio
	 * @param msg que se quiere escribir en el log
	 * @param e   excepcion generada
	 * @return
	 */
	public synchronized static int e(final int cod, final String msg, final Exception e) {
		return Log.e(getFileName(), getMethodName() + msg, e);
	}

	/**
	 * Con este log, permitimos enviar un log para crear alarmas en el servidor.
	 *
	 * @param cod codigo de error definido en CodifosErrorEnvio
	 * @param msg que se quiere escribir en el log
	 * @return
	 */
	public synchronized static int e(final int cod, final String msg) {
		return Log.e(getFileName(), getMethodName() + msg);
	}

	/**
	 * Log de error. Por defecto el TAG es el nombre de la clase desde la que se
	 * le llama, e es la excepcion que se genera
	 *
	 * @param msg
	 * @param e
	 * @return
	 */
	public static int e(final String msg, final Exception e) {
		return Log.e(getFileName(), getMethodName() + msg, e);
	}

	/**
	 * Log de Debug. Por defecto el TAG es el nombre de la clase desde la que se
	 * le llama
	 *
	 * @param msg Mensaje que se quiere enviar
	 * @return
	 */
	public static int i(final String msg) {
		return Log.i(getFileName(), getMethodName() + msg);
	}

	/**
	 * Log info normal de Android
	 *
	 * @param TAG Etiqueta identificativa
	 * @param msg Mensaje que se quiere enviar
	 * @return
	 */
	public static int i(final String TAG, final String msg) {
		return Log.i(TAG, getMethodName() + msg);
	}

	/**
	 * Log de waring. Por defecto el TAG es el nombre de la clase desde la que se
	 * le llama
	 *
	 * @param msg Mensaje que se quiere enviar
	 * @return
	 */
	public static int w(final String msg) {
		return Log.w(getFileName(), getMethodName() + msg);
	}

	/**
	 * Log warning normal de Android
	 *
	 * @param TAG Etiqueta identificativa
	 * @param msg Mensaje que se quiere enviar
	 * @return
	 */
	public static int w(final String TAG, final String msg) {
		return Log.w(TAG, getMethodName() + msg);
	}


}
