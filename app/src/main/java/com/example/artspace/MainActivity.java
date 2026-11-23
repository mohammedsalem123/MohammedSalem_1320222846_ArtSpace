
package com.example.artspace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgArtwork;
    private TextView txtPosition, txtTitle, txtArtist;
    private Button btnPrevious, btnNext;

    private int currentIndex = 0;

    private final int[] images = {
            R.drawable.mona_lisa,
            R.drawable.starry_night,
            R.drawable.the_scream,
            R.drawable.pearl_earring,
            R.drawable.persistence_memory,
            R.drawable.the_kiss
    };

    private final String[] titles = {
            "Mona Lisa",
            "The Starry Night",
            "The Scream",
            "Girl with a Pearl Earring",
            "The Persistence of Memory",
            "The Kiss"
    };

    private final String[] artists = {
            "Leonardo da Vinci",
            "Vincent van Gogh",
            "Edvard Munch",
            "Johannes Vermeer",
            "Salvador Dali",
            "Gustav Klimt"
    };

    private final String[] years = {
            "1503",
            "1889",
            "1893",
            "1665",
            "1931",
            "1908"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgArtwork = findViewById(R.id.imgArtwork);
        txtPosition = findViewById(R.id.txtPosition);
        txtTitle = findViewById(R.id.txtTitle);
        txtArtist = findViewById(R.id.txtArtist);

        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("currentIndex", 0);
        }

        updateArtwork();

        btnNext.setOnClickListener(v -> {
            if (currentIndex < images.length - 1) {
                currentIndex++;
                updateArtwork();
            }
        });

        btnPrevious.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtwork();
            }
        });

        imgArtwork.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ArtworkDetailsActivity.class
            );

            intent.putExtra("title", titles[currentIndex]);
            intent.putExtra("artist", artists[currentIndex]);
            intent.putExtra("year", years[currentIndex]);

            startActivity(intent);
        });
    }

    private void updateArtwork() {

        imgArtwork.setImageResource(images[currentIndex]);

        txtPosition.setText(
                (currentIndex + 1) + " / " + images.length
        );

        txtTitle.setText(titles[currentIndex]);

        txtArtist.setText(
                artists[currentIndex] + " - " + years[currentIndex]
        );

        btnPrevious.setEnabled(currentIndex != 0);

        btnNext.setEnabled(currentIndex != images.length - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentIndex", currentIndex);
    }
}
