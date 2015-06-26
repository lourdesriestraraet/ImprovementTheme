package es.raet.lourdesriestra.improvementtheme.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTV extends TextView {
	public CustomTV(Context context) {
		super(context);
		initFont(null);
	}

	private void initFont(AttributeSet attributeSet) {
		final Typeface normalFont = Font.getNormalFont();
		final Typeface boldFont = Font.getBlodFont();
		final Typeface ligthFont = Font.getLigthFont();
		if (attributeSet != null) {
			if (this.getTypeface() != null && this.getTypeface().isBold()) {
				this.setTypeface(boldFont);
			} else if (this.getTypeface() != null && this.getTypeface().isItalic()) {
				this.setTypeface(ligthFont);
			} else {
				this.setTypeface(normalFont);
			}
		} else {
			this.setTypeface(normalFont);
		}
	}

	public CustomTV(Context context, AttributeSet attrs) {
		super(context, attrs);
		initFont(attrs);
	}

	public CustomTV(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initFont(attrs);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CustomTV(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initFont(attrs);
	}

}
