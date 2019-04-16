package hw.xsj.jaymie.guessinggamefinal;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private GuessingGame game;

    private BoardItem a = null, b = null;

    private int time = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new GuessingGame();

        final Handler handler = new Handler();
        Timer timer = new Timer(false);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        if (time != 0) {
                            time--;
                        }

                        ProgressBar p = (ProgressBar)findViewById(R.id.progressBar);
                        p.setProgress((int)(((float)time / 60.f) * 100.f));
                    }
                });
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void onGameBtnClick(View view) {

        // Stop if player needs to wait
        if (a != null && b != null) return;

        String name = view.getResources().getResourceName(view.getId());
        String[] items = name.split("_");

        int row = Integer.parseInt(items[1]);
        int col = Integer.parseInt(items[2]);

        int item = game.getItemAt(row, col);

        ImageButton btn = (ImageButton)view;
        btn.setImageResource(ItemDictionary.getItemImageByGameId(item));

        // Assign
        if (a == null) {
            a = new BoardItem(view.getId(), item);
        } else if (b == null) {
            b = new BoardItem(view.getId(), item);
        }

        // Check
        if (a != null && b != null) {

            final ImageButton btn_a = (ImageButton)findViewById(a.getId());
            final ImageButton btn_b = (ImageButton)findViewById(b.getId());

            // Check if they same
            if (a.getValue() == b.getValue()) {
                btn_a.setEnabled(false);
                btn_b.setEnabled(false);

                time += 2; // Add time for player
                if (time > 60) {
                    time = 60;
                }
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            synchronized (this) {
                                wait(1000);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        btn_a.setImageResource(R.drawable.unknow_small);
                                        btn_b.setImageResource(R.drawable.unknow_small);
                                    }
                                });

                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            // Reset
            a = null;
            b = null;
        }

        Log.wtf("BOARD", Integer.toString(item));
    }
}
