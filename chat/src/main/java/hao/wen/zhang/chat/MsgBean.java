package hao.wen.zhang.chat;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/28 0028   上午 11:46
 * 描述说明：
 */

public class MsgBean {
    public int TYPE;
    public String msg;

    public MsgBean(int type,String msg) {
        this.msg = msg;
        this.TYPE = type;
    }
}
