import java.awt.event.InputEvent;

public class DownCommand implements ActionCommand {
    @Override
    public void act(InputEvent e, GameController controller) { controller.down(); }
}
