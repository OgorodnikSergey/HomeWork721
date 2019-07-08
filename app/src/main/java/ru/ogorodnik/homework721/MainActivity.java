package ru.ogorodnik.homework721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText adress;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adress = findViewById(R.id.adress);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        text = adress.getText().toString();
        if (text.equals("")) {
            Toast.makeText(this, "Вы не ввели адрес или координаты", Toast.LENGTH_LONG).show();
        } else {
            if (isBukva(text)) {
                text = "geo:?q=" + text;
            } else {
                text = "geo:" + text;
            }
            Uri uri = Uri.parse(text);
            intent.setData(uri);
            startActivity(intent);
        }
    }

    public boolean isBukva(String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}