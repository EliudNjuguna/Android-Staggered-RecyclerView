package rhynix.eliud.staggeredrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class InfoActivity extends AppCompatActivity {

    private static final String TAG = "InfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Log.d(TAG, "onCreate: activity started");

        getIncomingIntent();
    }

    private void getIncomingIntent() {

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){

            Log.d(TAG, "getIncomingIntent: found intent");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageName,imageUrl);
        }
    }

    private void setImage(String imageName, String imageUrl) {

        Log.d(TAG, "setImage: Setting images and names to the widgets");

        TextView name = findViewById(R.id.image_desc);
        name.setText(imageName);

        ImageView imageView = findViewById(R.id.image_info);
        Glide.with(this).asBitmap().load(imageUrl).into(imageView);
    }
}
