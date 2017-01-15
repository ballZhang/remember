package lyw.littlegift.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhangxy on 2017/1/15.
 */
public class TypeTextView extends TextView{
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TypeTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public TypeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }
    public TypeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public TypeTextView(Context context) {
        this(context, null);
    }


}
