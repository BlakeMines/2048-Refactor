import java.awt.event.InputEvent;

public class RightCommand implements ActionCommand {
    @Override
    public void act(InputEvent e, GameController controller) { controller.right(); }
}