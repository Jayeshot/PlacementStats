package com.example.placementstats.HomeScreen;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.placementstats.HomeScreen.Models.CourseContentItemModel;
import com.example.placementstats.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class tempAddCourse extends AppCompatActivity {

    private EditText edt1,edt2,edt3;
    private ImageView img1;
    private Button btn1;
    private Uri imgUri;
    private DatabaseReference databaseReference;
    private String TAG="AddItem_TAG";
    private StorageReference storageReference;
    private static final int PICK_IMAGE_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_add_course);

        init();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCourse();
            }
        });
    }

    private void AddCourse() {
        final String edt1_text = edt1.getText().toString();
        final String edt2_text = edt2.getText().toString();
        final String edt3_text = edt3.getText().toString();

        final String courseId = System.currentTimeMillis()+"";
        final StorageReference reference1 = storageReference.child(getString(R.string.CourseImage)).child(courseId+""+getFileExtension(imgUri));
        reference1.putFile(imgUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference1.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        CourseContentItemModel model = new CourseContentItemModel(courseId,edt1_text,edt2_text,edt3_text,uri+"");
                                        databaseReference.child(getString(R.string.Courses)).child(edt1_text).child(courseId).setValue(model);
                                    }
                                });
                    }
                });

    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            imgUri = data.getData();
            Picasso.get().load(imgUri).into(img1);
        }

    }


    private void init() {
        edt1= findViewById(R.id.temmpAddCourse_course_name);
        edt2= findViewById(R.id.temmpAddCourse_course_detail);
        edt3= findViewById(R.id.temmpAddCourse_course_about);
        img1= findViewById(R.id.temmpAddCourse_thumbnail);
        btn1= findViewById(R.id.tempAddCourse_save);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

    }
}