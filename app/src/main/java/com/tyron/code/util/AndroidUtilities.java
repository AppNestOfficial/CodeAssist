package com.tyron.code.util;
import android.util.TypedValue;
import com.tyron.code.ApplicationLoader;
import android.view.ViewGroup;
import android.view.View;

public class AndroidUtilities {
    
    public static int dp(float px) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                px, ApplicationLoader.applicationContext.getResources().getDisplayMetrics()));
    }
	
	public static int getHeight(ViewGroup viewGroup) {
		
		viewGroup.measure(View.MeasureSpec.makeMeasureSpec(-1, ViewGroup.MeasureSpec.AT_MOST),
		ViewGroup.MeasureSpec.makeMeasureSpec(-2, ViewGroup.MeasureSpec.AT_MOST));
		
		int height = 0;
		for (int i = 0; i < viewGroup.getChildCount(); i++) {
			View view = viewGroup.getChildAt(i);
			
			height += view.getMeasuredHeight();
		}
		
		return height;
	}
}
