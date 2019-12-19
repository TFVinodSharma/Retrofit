package vinod.learning.com.retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("Web?name=zia&pwd=qwer")
    Call<List<VikasApiData>> getData();
}
