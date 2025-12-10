import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;


public class KeyController extends GameController implements KeyListener {
    private final Map<Integer, ActionCommand> commands;

    public KeyController() {
        commands = new HashMap<>();
        commands.put(KeyEvent.VK_ESCAPE, new ResetCommand());
        commands.put(KeyEvent.VK_UP, new UpCommand());
        commands.put(KeyEvent.VK_DOWN, new DownCommand());
        commands.put(KeyEvent.VK_LEFT, new LeftCommand());
        commands.put(KeyEvent.VK_RIGHT, new RightCommand());
    }

    //no need to change these
    protected void setViewListener(View view){
    view.addKeyListener(this);
   }

    // TODO: Response
    @Override
    protected void action(InputEvent e) {
        KeyEvent keyEvent = (KeyEvent)e;
        Integer keyCode = keyEvent.getKeyCode();
        if (commands.containsKey(keyCode)) { commands.get(keyCode).act(keyEvent, this); }
    }

    /*KeyListener  methods */
    public void keyPressed(KeyEvent e) {
        super.handle(e);
    }

    public void keyReleased(KeyEvent e){} // TODO: Use this?
    public void keyTyped(KeyEvent e){} // TODO: Use this?
}