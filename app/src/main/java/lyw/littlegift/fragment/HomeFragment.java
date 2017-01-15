package lyw.littlegift.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lyw.littlegift.R;
import lyw.littlegift.adapter.HomeListAdapter;
import lyw.littlegift.bean.HomeBean;
import lyw.littlegift.database.DBHelper;
import lyw.littlegift.ui.DetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private View view;
    private ListView listView;
    private List<String> items;
    private HomeListAdapter adapter;
    private List<HomeBean> infos=new ArrayList<HomeBean>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new HomeListAdapter(getActivity());
        initView();
        porPost();
        infos=DBHelper.getInstance().getAllOrder();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("title",infos.get(i).getTitle());
                intent.putExtra("subtitle",infos.get(i).getSubtitle());
                intent.putExtra("date",infos.get(i).getDate().split(" ")[0]);
                intent.putExtra("day",HomeListAdapter.porPost(infos.get(i).getDate()));
                getActivity().startActivity(intent);
            }
        });
    }

    private void porPost() {
        if(DBHelper.getInstance().getAllOrder()
                !=null){
            listView.setAdapter(adapter);
        }


    }

    private void initView() {
        listView = (ListView) view.findViewById(R.id.home_listview);
        listView.setDividerHeight(0);
    }

    @Override
    public void onResume() {
        super.onResume();
        listView.deferNotifyDataSetChanged();
    }

}
