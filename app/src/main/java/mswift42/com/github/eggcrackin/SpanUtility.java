package mswift42.com.github.eggcrackin;


import android.content.Context;
import android.util.DisplayMetrics;

public class SpanUtility {
    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int columns = (int) (dpWidth / 260);
        return columns;
    }
}
