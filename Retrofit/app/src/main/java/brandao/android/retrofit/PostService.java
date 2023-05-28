package brandao.android.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {


    @GET("/posts")
    public Call<List<PostEntity>> list();
}
