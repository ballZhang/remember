package lyw.littlegift.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import lyw.littlegift.MainActivity;
import lyw.littlegift.R;
import lyw.littlegift.bean.HomeBean;
import lyw.littlegift.database.DBHelper;

public class AddActivity extends AppCompatActivity {

    private ImageView confirmBtn;
    private ImageView backBtn;
    private EditText mainHeader;
    private EditText lowerHeader;
    private DatePicker datePicker;
    private String pickedDay;
    private String mainHeadText;
    private String lowerHeadText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_ui);

        initView();
    }

    private void initView(){
        confirmBtn=(ImageView)findViewById(R.id.right_img);
        mainHeader=(EditText)findViewById(R.id.editText);
        lowerHeader=(EditText)findViewById(R.id.editText2);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        backBtn=(ImageView)findViewById(R.id.left_img);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day=datePicker.getDayOfMonth();
                int month=datePicker.getMonth()+1;
                int year=datePicker.getYear();
                pickedDay=year+"-"+month+"-"+day+" 00:00:00";
                mainHeadText=mainHeader.getText().toString();
                lowerHeadText=lowerHeader.getText().toString();
                HomeBean homeBean = new HomeBean();
                homeBean.setDate(pickedDay);
                homeBean.setTitle(mainHeadText);
                homeBean.setSubtitle(lowerHeadText);
                DBHelper.getInstance().save(homeBean);

                AddActivity.this.startActivity(new Intent(AddActivity.this, MainActivity.class));
                AddActivity.this.finish();
            }
        });
    }
}
