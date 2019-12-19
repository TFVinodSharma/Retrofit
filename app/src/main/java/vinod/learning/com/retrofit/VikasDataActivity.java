package vinod.learning.com.retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VikasDataActivity extends AppCompatActivity {
    ProgressDialog progressDoalog;
TextView Txt1,Txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vikas_data);
        Txt1=findViewById(R.id.text1);
        Txt2=findViewById(R.id.text2);

        progressDoalog = new ProgressDialog(VikasDataActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstanceq().create(GetDataService.class);
        Call<List<VikasApiData>> call = service.getData();
        call.enqueue(new Callback<List<VikasApiData>>() {
            @Override
            public void onResponse(Call<List<VikasApiData>> call, Response<List<VikasApiData>> response) {
                progressDoalog.dismiss();
                VikasApiData vikasApiData = (VikasApiData) response.body();
                    Txt1.setText(vikasApiData.getUserId());
                    Txt2.setText(vikasApiData.getName());



               // generateApiData(response.body());
            }

            @Override
            public void onFailure(Call<List<VikasApiData>> call, Throwable t) {
                progressDoalog.dismiss();

                Toast.makeText(VikasDataActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }





}

