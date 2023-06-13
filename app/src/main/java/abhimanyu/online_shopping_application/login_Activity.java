package abhimanyu.online_shopping_application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class login_Activity extends AppCompatActivity {
    private EditText email,password;
    private Button login;
    private SQL_database sql_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sql_database = new SQL_database(getApplicationContext());
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();
                sql_database.login(new data(getEmail,getPassword));
            }
        });

    }
}