package lyw.littlegift.database;


import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

import java.util.List;

import lyw.littlegift.bean.HomeBean;

public class DBHelper {
	private static DBHelper instance = null;

	private DBHelper() {
	}

	public static DBHelper getInstance() {
		if (instance == null) {
			instance = new DBHelper();
		}
		// DBCreator.create().
		return instance;
	}

	/**
	 * �������� : save �������� : ����������ֵ˵����
	 */
	public void save(HomeBean info) {
		try {
			DBCreator.create().save(info);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}



	public void update(HomeBean info) {
		try {

			DBCreator.create().update(info,
					WhereBuilder.b(HomeBean.COL_ID, "=", info.getId()));
		} catch (DbException e) {
			e.printStackTrace();
		}
	}


	public HomeBean findByColumn(String colName, String colValue) {
		HomeBean info = null;

		try {
			info = DBCreator.create().findFirst(
					Selector.from(HomeBean.class)
							.where(WhereBuilder.b(colName, "=", colValue))
						);
		} catch (DbException e) {
			e.printStackTrace();
		}

		return info;
	}


	
	

	public List<HomeBean> getAllOrder() {
		List<HomeBean> list = null;
		try {
			list = DBCreator.create().findAll(HomeBean.class);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public HomeBean getLastOrder() {
		List<HomeBean> list =getAllOrder();
		HomeBean wd=null;
		if(list!=null){
			wd=list.get(0);
		}
		return wd;
	}

}
