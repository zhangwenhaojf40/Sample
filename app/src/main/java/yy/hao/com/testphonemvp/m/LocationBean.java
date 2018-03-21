package yy.hao.com.testphonemvp.m;


/**
 * ApiUtil.class
 *
 * @author lwang
 * @date 2017/10/23.
 */
public class LocationBean {


    public String resultcode;

    public String reason;

    public Result result;

    public Integer errorCode;

    @Override
    public String toString() {
        return "LocationBean{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", errorCode=" + errorCode +
                '}';
    }
}
