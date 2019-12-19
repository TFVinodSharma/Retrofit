package vinod.learning.com.retrofit;

import com.google.gson.annotations.SerializedName;

public class VikasApiData {

    @SerializedName("userId")
    private Integer userId;
    @SerializedName("name")
    private String name;

    public VikasApiData(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
