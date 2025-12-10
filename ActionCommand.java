import java.awt.event.InputEvent;

public interface ActionCommand {
    void act(InputEvent e, GameController controller);
}
