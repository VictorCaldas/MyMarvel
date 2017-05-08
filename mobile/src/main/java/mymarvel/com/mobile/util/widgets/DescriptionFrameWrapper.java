

package mymarvel.com.mobile.util.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mymarvel.mobile.R;


public class DescriptionFrameWrapper extends LinearLayout {

    private TextView mTitle;
    private TextView mDescription;


    public DescriptionFrameWrapper(Context context) {
        super(context);
        init(context);
    }

    public DescriptionFrameWrapper(Context context, @Nullable String title, @Nullable String description) {
        super(context);
        init(context);

        if (title == null || title.isEmpty()) {
            mTitle.setText(context.getResources().getString(R.string.description));
        } else {
            mTitle.setText(title);
        }

        if (description != null && !description.isEmpty()) {
            mDescription.setText(description);
        }
    }

    private void init(Context context) {
        inflate(context, R.layout.frame_character_description, this);
        mTitle = (AppCompatTextView) findViewById(R.id.tv_title_description);
        mDescription = (AppCompatTextView) findViewById(R.id.tv_description);
    }
}
