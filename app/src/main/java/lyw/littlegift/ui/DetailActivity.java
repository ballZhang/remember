package lyw.littlegift.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import lyw.littlegift.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView backBtn;
    private ImageView deleteBtn;
    private TextView headText;
    private TextView subText;
    private TextView gapDay;
    private TextView rememberDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        backBtn=(ImageView)findViewById(R.id.cancel);
        deleteBtn=(ImageView)findViewById(R.id.delete);
        headText=(TextView)findViewById(R.id.textView1);
        subText=(TextView)findViewById(R.id.textView2);
        gapDay=(TextView)findViewById(R.id.textView3);
        rememberDay=(TextView)findViewById(R.id.textView4);
        deleteBtn.setVisibility(View.GONE);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent=getIntent();
        headText.setText( intent.getStringExtra("title"));
        subText.setText(intent.getStringExtra("subtitle"));
        rememberDay.setText( intent.getStringExtra("date"));
        gapDay.setText("第"+ intent.getStringExtra("day")+"天");
    }

}
