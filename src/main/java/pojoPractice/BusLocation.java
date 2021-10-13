
package pojoPractice;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BusLocation {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("currentTime")
    @Expose
    private Long currentTime;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("version")
    @Expose
    private Integer version;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
