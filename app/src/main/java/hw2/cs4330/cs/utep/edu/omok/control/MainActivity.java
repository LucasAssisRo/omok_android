package hw2.cs4330.cs.utep.edu.omok.control;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hw2.cs4330.cs.utep.edu.omok.R;
import hw2.cs4330.cs.utep.edu.omok.view.BoardView;

public class MainActivity extends AppCompatActivity {
    private BoardView boardView;
    private EditText editTextPlayerOne;
    private EditText editTextPlayerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardView = (BoardView) findViewById(R.id.boardView);
        editTextPlayerOne = (EditText) findViewById(R.id.editTextPlayerOne);
        editTextPlayerTwo = (EditText) findViewById(R.id.editTextPlayerTwo);
    }

    public void startNewGame(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String nameOne, nameTwo;
                if (editTextPlayerOne.getText() == null)
                    nameOne = getResources().getString(R.string.player_one);
                else nameOne = editTextPlayerOne.getText().toString();
                if (editTextPlayerTwo.getText() == null)
                    nameTwo = getResources().getString(R.string.player_two);
                else nameTwo = editTextPlayerTwo.getText().toString();
                editTextPlayerOne.setEnabled(false);
                editTextPlayerTwo.setEnabled(false);
                boardView.startNewGame(nameOne, nameTwo);
                boardView.invalidate();
                Toast.makeText(builder.getContext(), R.string.game_started, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(builder.getContext(), R.string.new_game_canceled, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setMessage(R.string.new_game_prompt);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
