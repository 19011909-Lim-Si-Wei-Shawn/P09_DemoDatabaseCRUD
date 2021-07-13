package sg.edu.rp.c346.id19011909.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    //Creating Variable,
    TextView tvID;

    EditText etContent;

    Button btnUpdate;
    Button btnDelete;

    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //Linking Variable,
        tvID = findViewById(R.id.tvID);
        etContent = findViewById(R.id.etContent);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        //Setting Intent,
        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getID());
        etContent.setText(data.getNoteContent());

        //Setting Action,
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();

                Intent i = new Intent(EditActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getID());

                Intent i = new Intent(EditActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}