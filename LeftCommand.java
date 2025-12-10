import java.awt.event.InputEvent;

public class LeftCommand implements ActionCommand {
    @Override
    public void act(InputEvent e, GameController controller) { controller.left(); }
}
