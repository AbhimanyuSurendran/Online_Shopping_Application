package abhimanyu.online_shopping_application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;
    private Button register;
    private SQL_database sql_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sql_database = new SQL_database(getApplicationContext());

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = name.getText().toString();
                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();

                sql_database.register(new data(getName,getEmail,getPassword));
            }
        });
    }
}