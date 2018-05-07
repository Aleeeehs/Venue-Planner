package planner.venue.venue;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicLong;

public class addStaffMenu extends AppCompatActivity implements View.OnClickListener {

    private static final String SERVER_ADDRESS = "http://files.000webhost.com/";
    private static final int RESULT_LOAD_IMAGE = 1;
    private static AtomicLong idCounter = new AtomicLong();
    ImageView profilePhoto;
    Button uploadButton;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstafflayout);

        profilePhoto = findViewById(R.id.profilePhoto);
        uploadButton = findViewById(R.id.uploadButton);
        ID = createID();

        profilePhoto.setOnClickListener(this);
        uploadButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            profilePhoto.setImageURI(selectedImage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.uploadButton:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
        }
    }

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
}
