package lyw.littlegift.database;


import com.lidroid.xutils.DbUtils;

import lyw.littlegift.MainActivity;

public class DBCreator {
	private static final String TAG = "DBCreator";
	public static final String DB_NAME = "remember.db";
	private static final int DB_VERSION = 1;
	private static DbUtils dbUtils = null;


	@SuppressWarnings("static-access")
	public static DbUtils create() {
		if (dbUtils == null) {

			 dbUtils = DbUtils.create(MainActivity.instance, DB_NAME,
			 DB_VERSION, null);

			dbUtils.configAllowTransaction(true);
			dbUtils.configDebug(true);

		}
		return dbUtils;
	}

}
