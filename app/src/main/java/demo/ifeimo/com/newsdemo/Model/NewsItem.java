package demo.ifeimo.com.newsdemo.Model;

import com.google.gson.Gson;

import java.util.List;

import demo.ifeimo.com.newsdemo.data.adapter.BaseEntity;

/**
 * Created by y on 2018/3/6.
 */

public class NewsItem extends BaseEntity {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-04-07 00:00","title":"杭州一男子凌晨回家，车底下竟躺着个人，一动不动...结果也是醉了","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0407/ACDC75AF1E7C2581DE17051CB23F8B02DB190B11_size20_w500_h300.jpeg","url":"http://news.ifeng.com/a/20180407/57373609_0.shtml"},{"ctime":"2018-04-07 00:00","title":"内蒙古一高校校车下雪天只载老师拒载学生 校方：就不管","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/a/2018_14/1971cd96519cede_size180_w245_h341.png","url":"http://news.ifeng.com/a/20180407/57372064_0.shtml"},{"ctime":"2018-04-07 00:00","title":"南岳衡山景区\u201c美国游客购票加收25%关税\u201d？官方回应","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/fck/2018_14/7ff2526905a6829_w600_h800.jpg","url":"http://news.ifeng.com/a/20180407/57372430_0.shtml"},{"ctime":"2018-04-07 00:00","title":"南大文学院回应\u201c沈阳性侵事件\u201d：师德师风不符合要求","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0406/9A834F5A5883E3BE0F2EF2EF80F06A34ED436281_size63_w1080_h797.jpeg","url":"http://news.ifeng.com/a/20180407/57371233_0.shtml"},{"ctime":"2018-04-07 00:00","title":"时隔两月，美国就\u201c兵马俑展品手指被盗\u201d事件道歉","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/a/2018_14/9146a103d520361_size83_w1080_h608.jpeg","url":"http://news.ifeng.com/a/20180407/57371877_0.shtml"},{"ctime":"2018-04-07 00:00","title":"西安男子买床垫 店家得知小区名涨价600元","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/a/2018_14/23a97be88f5e66e_size98_w800_h600.jpg","url":"http://news.ifeng.com/a/20180407/57370356_0.shtml"},{"ctime":"2018-04-07 00:00","title":"黑龙江一高校门卫室贴多名前校领导照片：防进校搞颠覆","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0407/B96E2D0AAC3F16E71478D5AED520D2465B52C5CC_size129_w600_h800.jpeg","url":"http://news.ifeng.com/a/20180407/57370445_0.shtml"},{"ctime":"2018-04-07 00:00","title":"回击\u201c精日\u201d！\u201c日军军服照\u201d事件起底者祭拜抗日英灵","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0407/DC19FFFD36FE1CCC3ECB146F02B854F32E2ECAFE_size137_w600_h395.jpeg","url":"http://news.ifeng.com/a/20180407/57370595_0.shtml"},{"ctime":"2018-04-07 00:00","title":"广东惠州疑清明祭祖引发山火 过火面积300亩","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/fck/2018_14/55293b4c3fcbe80_w879_h600.jpg","url":"http://news.ifeng.com/a/20180407/57370901_0.shtml"},{"ctime":"2018-04-07 00:00","title":"2死3伤！一家5口开车回去过清明，他眼看亲人当场没了","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0407/FB90C17E1C8AC55D8F9A8AAC22F8913457359237_size63_w800_h450.jpeg","url":"http://news.ifeng.com/a/20180407/57370028_0.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public static NewsItem objectFromData(String str) {

        return new Gson().fromJson(str, NewsItem.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean extends BaseEntity{
        /**
         * ctime : 2018-04-07 00:00
         * title : 杭州一男子凌晨回家，车底下竟躺着个人，一动不动...结果也是醉了
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0407/ACDC75AF1E7C2581DE17051CB23F8B02DB190B11_size20_w500_h300.jpeg
         * url : http://news.ifeng.com/a/20180407/57373609_0.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public static NewslistBean objectFromData(String str) {

            return new Gson().fromJson(str, NewslistBean.class);
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
