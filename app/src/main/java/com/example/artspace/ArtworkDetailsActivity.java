
package com.example.artspace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    private TextView txtDetailTitle;
    private TextView txtDetailArtist;
    private TextView txtDetailYear;

    private Button btnVisitWebsite;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        txtDetailTitle = findViewById(R.id.txtDetailTitle);
        txtDetailArtist = findViewById(R.id.txtDetailArtist);
        txtDetailYear = findViewById(R.id.txtDetailYear);

        btnVisitWebsite = findViewById(R.id.btnVisitWebsite);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String artist = intent.getStringExtra("artist");
        String year = intent.getStringExtra("year");

        txtDetailTitle.setText(title);
        txtDetailArtist.setText("Artist: " + artist);
        txtDetailYear.setText("Year: " + year);

        btnVisitWebsite.setOnClickListener(v -> {
            Intent webIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")
            );

            startActivity(webIntent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
