import java.awt.event.InputEvent;

public class UpCommand implements ActionCommand {
    @Override
    public void act(InputEvent e, GameController controller) { controller.up(); }
}
