package hw2.cs4330.cs.utep.edu.omok.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import hw2.cs4330.cs.utep.edu.omok.R;
import hw2.cs4330.cs.utep.edu.omok.model.ConnectFiveGame;

/**
 * Created by lucasassisrodrigues on 2/25/16.
 */
public class BoardView extends View {
    private ConnectFiveGame connectFiveGame = new ConnectFiveGame();
    private final MediaPlayer soundToken = MediaPlayer.create(getContext(), R.raw.sound_placing_token);
    private final MediaPlayer soundWin = MediaPlayer.create(getContext(), R.raw.sound_winning);

    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public BoardView(Context context) {
        super(context);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return onBoardTouch(v, event);
            }
        });
    }

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     * <p/>
     * <p/>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     * @see #View(Context, AttributeSet, int)
     */
    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return onBoardTouch(v, event);
            }
        });
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute. This constructor of View allows subclasses to use their
     * own base style when they are inflating. For example, a Button class's
     * constructor would call this version of the super class constructor and
     * supply <code>R.attr.buttonStyle</code> for <var>defStyleAttr</var>; this
     * allows the theme's button style to modify all of the base view attributes
     * (in particular its background) as well as the Button class's attributes.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     * @see #View(Context, AttributeSet)
     */
    public BoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return onBoardTouch(v, event);
            }
        });
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute or style resource. This constructor of View allows
     * subclasses to use their own base style when they are inflating.
     * <p/>
     * When determining the final value of a particular attribute, there are
     * four inputs that come into play:
     * <ol>
     * <li>Any attribute values in the given AttributeSet.
     * <li>The style resource specified in the AttributeSet (named "style").
     * <li>The default style specified by <var>defStyleAttr</var>.
     * <li>The default style specified by <var>defStyleRes</var>.
     * <li>The base values in this theme.
     * </ol>
     * <p/>
     * Each of these inputs is considered in-order, with the first listed taking
     * precedence over the following ones. In other words, if in the
     * AttributeSet you have supplied <code>&lt;Button * textColor="#ff000000"&gt;</code>
     * , then the button's text will <em>always</em> be black, regardless of
     * what is specified in any of the styles.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     * @param defStyleRes  A resource identifier of a style resource that
     *                     supplies default values for the view, used only if
     *                     defStyleAttr is 0 or can not be found in the theme. Can be 0
     *                     to not look for defaults.
     * @see #View(Context, AttributeSet, int)
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BoardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return onBoardTouch(v, event);
            }
        });
    }

    public void startNewGame(String namePlayerOne, String namePlayerTwo) {
        soundWin.reset();
        soundWin.selectTrack(R.raw.sound_winning);
        connectFiveGame.startNewGame(namePlayerOne, namePlayerTwo);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paintLine = new Paint();
        Paint paintPlayerOne = new Paint();
        Paint paintPlayerTwo = new Paint();
        Paint paintWinner = new Paint();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setBackgroundColor(getResources().getColor(R.color.colorBoard, null));
            paintLine.setColor(getResources().getColor(R.color.colorLines, null));
            paintPlayerOne.setColor(getResources().getColor(R.color.colorPlayerOne, null));
            paintPlayerTwo.setColor(getResources().getColor(R.color.colorPlayerTwo, null));
            paintWinner.setColor(getResources().getColor(R.color.colorWinner, null));
        } else {
            setBackgroundColor(getResources().getColor(R.color.colorBoard));
            paintLine.setColor(getResources().getColor(R.color.colorLines));
            paintPlayerOne.setColor(getResources().getColor(R.color.colorPlayerOne));
            paintPlayerTwo.setColor(getResources().getColor(R.color.colorPlayerTwo));
            paintWinner.setColor(getResources().getColor(R.color.colorWinner));
        }
        paintLine.setStrokeWidth(10);
        for (int i = 0; i <= getWidth(); i += getWidth() / 9) {
            canvas.drawLine(i, 0, i, getHeight(), paintLine);
        }
        for (int i = 0; i <= getHeight(); i += getHeight() / 9) {
            canvas.drawLine(0, i, getWidth(), i, paintLine);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = connectFiveGame.getBoard().getBoardMatrix()[i][j];
                if (c == 'B') {
                    canvas.drawCircle(i * getWidth() / 9, j * getHeight() / 9, 20, paintPlayerOne);
                }
                if (c == 'W') {
                    canvas.drawCircle(i * getWidth() / 9, j * getHeight() / 9, 20, paintPlayerTwo);
                }
                if (c == '!') {
                    canvas.drawCircle(i * getWidth() / 9, j * getHeight() / 9, 20, paintWinner);
                }
            }
        }

    }

    private boolean onBoardTouch(View v, MotionEvent event) {
        if (connectFiveGame.isGameStarted()) {
            int x, y;
            int stepX, stepY;
            stepX = getWidth() / 9;
            stepY = getHeight() / 9;
            x = (int) (event.getX() / stepX);
            if (event.getX() % stepX > stepX / 2) {
                x++;
            }
            y = (int) (event.getY() / stepY);
            if (event.getY() % stepY > stepY / 2) {
                y++;
            }
            if (connectFiveGame.checkValidPosition(x, y)) {
                soundToken.start();
            }
            if (connectFiveGame.placeToken(x, y)) {
                invalidate();
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage(connectFiveGame.getPlayerName() + getResources().getString(R.string.wins));
                AlertDialog dialog = builder.create();
                soundWin.start();
                dialog.show();
            }
            invalidate();
            return true;
        }
        return false;
    }

}
