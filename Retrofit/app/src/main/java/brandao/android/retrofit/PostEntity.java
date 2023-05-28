package brandao.android.retrofit;

import com.google.gson.annotations.SerializedName;

public class PostEntity {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;
}
