package com.example.sprint5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<String> listOfThings;
    private EditText thingEditText;
    private Button submitButton;
    private TextView listTextView;
    private static final String LIST_KEY = "list_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfThings = new ArrayList<>();
        thingEditText = findViewById(R.id.thingEditText);
        submitButton = findViewById(R.id.submitButtonNovo);
        listTextView = findViewById(R.id.listTextView);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the button is clicked, add the text to the list of things and update the UI
                String thing = thingEditText.getText().toString();
                listOfThings.add(thing);
                thingEditText.setText("");
                updateListTextView();
                if (thing.isEmpty()) {
                    Toast.makeText(Main.this, "Texto inválido, Digite alguma coisa.", Toast.LENGTH_SHORT).show();
                }
                Button submitButtonExportar_1 = findViewById(R.id.submitButtonExportar);
                submitButtonExportar_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String input = thingEditText.getText().toString();

                        if (!input.isEmpty()) {
                            listOfThings.add(input);
                            thingEditText.setText("");
                            if (listOfThings.size() == 1) {
                                submitButtonExportar_1.setVisibility(View.VISIBLE);
                            }

                        }
                    }
                    private void exportListToTextFile() {
                        StringBuilder sb = new StringBuilder();
                        for (String thing : listOfThings) {
                            sb.append(thing).append("\n");
                        }

                        try {
                            File file = new File(getExternalFilesDir(null), "list_of_things.txt");
                            FileWriter writer = new FileWriter(file);
                            writer.write(sb.toString());
                            writer.close();
                            Toast.makeText(Main.this, "List exported successfully", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(Main.this, "Failed to export list", Toast.LENGTH_SHORT).show();
                        }
                    }

                    protected void onCreate(Bundle savedInstanceState) {

                        Button submitButtonExportar_1 = findViewById(R.id.submitButtonExportar);
                        submitButtonExportar_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                exportListToTextFile();
                            }
                        });

                    }

                });

            }

        });


    }

    private void updateListTextView() {
        StringBuilder sb = new StringBuilder();
        for (String thing : listOfThings) {
            sb.append(thing).append("\n");
        }
        listTextView.setText(sb.toString());
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the list of things to the bundle when the activity is about to be destroyed
        outState.putStringArrayList(LIST_KEY, listOfThings);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {

    }
}
