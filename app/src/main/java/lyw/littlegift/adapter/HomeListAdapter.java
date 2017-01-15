package lyw.littlegift.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lyw.littlegift.R;
import lyw.littlegift.bean.HomeBean;
import lyw.littlegift.database.DBHelper;

/**
 * Created by weizhenhua on 2016/2/19.
 */
public class HomeListAdapter extends BaseAdapter {

    private List<String> items;
    private Context context;

    private List<HomeBean> infos=new ArrayList<HomeBean>();


    public HomeListAdapter(Context context) {
        this.items = new ArrayList<>();
        this.infos= DBHelper.getInstance().getAllOrder();
        this.context = context;
    }

    public void setData(List<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_home_item, null);
            viewHolder = new ViewHolder();

            viewHolder.info = (TextView) convertView.findViewById(R.id.home_info_tv);
            viewHolder.days = (TextView) convertView.findViewById(R.id.home_days_tv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        viewHolder.info.setText("自2016年10月23日，我们在一起");
        viewHolder.info.setText(infos.get(position).getTitle());
        viewHolder.days.setText("第"+porPost(infos.get(position).getDate()) + "");

        return convertView;
    }

    static class ViewHolder {
        TextView info, days;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static  String  porPost(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long days=0;
        try {
            Date d1 = df.parse(date);
            long d2 = System.currentTimeMillis();

            long diff = d2 - d1.getTime();//这样得到的差值是微秒级别
            days = diff / (1000 * 60 * 60 * 24) + 1;



        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ""+days;
    }

}
