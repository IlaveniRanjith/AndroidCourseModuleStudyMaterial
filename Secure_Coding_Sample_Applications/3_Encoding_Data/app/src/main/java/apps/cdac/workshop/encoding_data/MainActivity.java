package apps.cdac.workshop.encoding_data;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.nio.charset.StandardCharsets;
import android.util.Base64;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.et_input);
        tvOutput = findViewById(R.id.tv_output);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onEncodeClick(View view) {
        String inputString = etInput.getText().toString();
        byte[] encodeValue = Base64.encode(inputString.getBytes(), Base64.DEFAULT);
        tvOutput.setText(new String(encodeValue));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onDecodeClick(View view) {
        String input_string = tvOutput.getText().toString();
        byte[] decodeValue = Base64.decode(input_string.getBytes(), Base64.DEFAULT);
        tvOutput.setText(new String(decodeValue));
    }

}

