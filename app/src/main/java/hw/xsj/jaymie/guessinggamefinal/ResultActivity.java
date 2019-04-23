package hw.xsj.jaymie.guessinggamefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        title = getIntent().getStringExtra("title");

        TextView txt = (TextView)(findViewById(R.id.text_title));
        txt.setText(title);
    }
}
