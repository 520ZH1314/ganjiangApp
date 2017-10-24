package moye.ganjiang.com.ganjiang.model.home;

import java.util.List;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/26.
 */

public class LunBoBean {

    /**
     * imgs : [{"hyperlink":"http://www.baidu.com","id":240,"title":"首页横幅4","titlepic":"http://my.ganjiangps.com/upload/1490252350355.png"},{"hyperlink":"http://www.niwodai.com/activity.mhtml?artId=5820160000006937&f&h&?intcmp=hompage_kv_1","id":81,"title":"有道智投实用宝典","titlepic":"http://my.ganjiangps.com/upload/1490151429702.jpg"},{"hyperlink":"http://www.niwodai.com/Public/Static/nwd/active/2016/12/lastyear/pc/index.html?intcmp=hompage_kv_3","id":82,"title":"以梦为马矩步方行","titlepic":"http://my.ganjiangps.com/upload/1489975686445.png"},{"hyperlink":"http://www.niwodai.com/tj2017.html?intcmp=hompage_kv_2","id":83,"title":"双赢双益","titlepic":"http://my.ganjiangps.com/upload/1489046726562.jpeg"},{"hyperlink":"http://www.baidu.com","id":262,"title":"有道智投实用宝典","titlepic":"http://my.ganjiangps.com/upload/1494492630874.jpg"}]
     * status : 1
     * Msg : 成功
     */

    private int status;
    private String Msg;
    private List<ImgsBean> imgs;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public List<ImgsBean> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgsBean> imgs) {
        this.imgs = imgs;
    }

    public static class ImgsBean {
        /**
         * hyperlink : http://www.baidu.com
         * id : 240
         * title : 首页横幅4
         * titlepic : http://my.ganjiangps.com/upload/1490252350355.png
         */

        private String hyperlink;
        private int id;
        private String title;
        private String titlepic;

        public String getHyperlink() {
            return hyperlink;
        }

        public void setHyperlink(String hyperlink) {
            this.hyperlink = hyperlink;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitlepic() {
            return titlepic;
        }

        public void setTitlepic(String titlepic) {
            this.titlepic = titlepic;
        }
    }
}
