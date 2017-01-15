package lyw.littlegift.bean;

/**
 * Created by zhangxy on 2017/1/15.
 */
public class HomeBean {

    private String title;
    private String date;
    private String subtitle;
    public static final String COL_ID = "id";
    private long id;

    public long getId() {
        return id;
    }
    public void setSubtitle(String subtitle){
        this.subtitle=subtitle;
    }

    public String getSubtitle(){
        return subtitle;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
