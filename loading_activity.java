import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;

public class LoadingActivity extends AppCompatActivity {
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
      
        Handler hd = new Handler(){
          public void handleMessage(Message msg){
              finish();
          }
        };
        hd.sendEmptyMessageDelayed(0,3000);

    }
}
