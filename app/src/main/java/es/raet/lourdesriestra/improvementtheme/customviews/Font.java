package es.raet.lourdesriestra.improvementtheme.customviews;

import android.graphics.Typeface;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;

class Font {

    protected static Typeface getNormalFont() {
        return Typeface.createFromAsset(AppGeneral.getContextApp().getAssets(), "fonts/FontR.ttf");
    }

    protected static Typeface getBlodFont() {
        return Typeface.createFromAsset(AppGeneral.getContextApp().getAssets(), "fonts/FontB.ttf");
    }

    protected static Typeface getLigthFont() {
        return Typeface.createFromAsset(AppGeneral.getContextApp().getAssets(), "fonts/FontL.ttf");
    }
}
