import java.awt.event.InputEvent;

public class ResetCommand implements ActionCommand {

    @Override
    public void act(InputEvent e, GameController controller) {
        controller.resetGame();
    }
}
