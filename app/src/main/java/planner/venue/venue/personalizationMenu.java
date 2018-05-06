package planner.venue.venue;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class personalizationMenu extends AppCompatActivity implements View.OnClickListener {

    private static final String SERVER_ADDRESS = "http://files.000webhost.com/";
    private static final int RESULT_LOAD_IMAGE = 1;
    private static AtomicLong idCounter = new AtomicLong();
    ImageView profilePhoto;
    Button uploadButton;
    String ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalization);

        profilePhoto = findViewById(R.id.profilePhoto);
        uploadButton = findViewById(R.id.uploadButton);
        ID = createID();

        profilePhoto.setOnClickListener(this);
        uploadButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) ;
        Uri selectedImage = data.getData();
        profilePhoto.setImageURI(selectedImage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profilePhoto:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
            case R.id.uploadButton:
                Bitmap photo = ((BitmapDrawable) profilePhoto.getDrawable()).getBitmap();
                new UploadPhoto(photo, ID);
                break;
        }
    }

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }

    private class UploadPhoto extends AsyncTask<Void, Void, Void> {
        Bitmap photo;
        String photoID;

        public UploadPhoto(Bitmap photo, String photoID)
        {
            this.photo = photo;
            this.photoID = photoID;
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);

            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("photo", encodedImage));
            dataToSend.add(new BasicNameValuePair("name", photoID));

            HttpParams httpRequestParams = getHttpRequestParams();

            HttpClient client =  new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "SavePicture.php");

            try {
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Your Profile Photo has been uploaded", Toast.LENGTH_LONG).show();
        }
    }

    private HttpParams getHttpRequestParams()
    {
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams,1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams, 1000 * 30);
        return httpRequestParams;
    }


}
