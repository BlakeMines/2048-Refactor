import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;


public class MouseController extends GameController implements MouseListener,MouseMotionListener{
    private final Map<Direction, ActionCommand> commands;

    public MouseController() {
        commands = new HashMap<>();
        commands.put(Direction.ESC, new ResetCommand());
        commands.put(Direction.LEFT, new LeftCommand());
        commands.put(Direction.RIGHT, new RightCommand());
        commands.put(Direction.DOWN, new DownCommand());
        commands.put(Direction.UP, new UpCommand());
    }

    /**
        InputEvent e;
        MouseDirectionEvent me=(MouseDirectionEvent) e;
        Object code=me.getDirection();

        Direction.ESC    to reset
        Direction.LEFT
        Direction.RIGHT
        Direction.DOWN
        Direction.UP
    */

    //no need to change these
    protected void setViewListener(View view){
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
    }

    // TODO: Response

    /**
     * We used commands here since each different event requires a different handling and the command
     * decouples the event object from the controller.
     */


    @Override
    protected void action(InputEvent e) {
        MouseDirectionEvent mouseEvent = (MouseDirectionEvent)e;
        Direction code = mouseEvent.getDirection();
        if (commands.containsKey(code)) {
            ActionCommand command = commands.get(code);
            command.act(e, this);
        }
    }

    /* MouseListener  methods */
    public void mouseClicked(MouseEvent e){
        //prevX=e.getX();
        //prevY=e.getY();
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        prevX = e.getX();
        prevY = e.getY();
    }
    public void mouseReleased(MouseEvent e){}

    public void mouseDragged(MouseEvent e){
        MouseDirectionEvent ev=new MouseDirectionEvent(e,prevX,prevY);
        super.handle(ev);
    }
    public void mouseMoved(MouseEvent e){}

    private int prevX;
    private int prevY;

    private enum Direction{UP,DOWN,LEFT,RIGHT,ESC}
    private static class MouseDirectionEvent extends MouseEvent{
        public MouseDirectionEvent(MouseEvent e, int prevX, int prevY) {
            super(
                (Component)e.getSource(),
                e.getID(),
                e.getWhen(),
                e.getModifiersEx(),
                e.getX(),
                e.getY(),
                e.getClickCount(),
                e.isPopupTrigger()
            );

            if(e.getButton()==BUTTON2 || e.getClickCount()>2) {
                direction=Direction.ESC;
            } else {
                int nextX=e.getX();
                int nextY=e.getY();
                calculateDirection(prevX,prevY,nextX,nextY);
            }
        }

        private Direction direction;
        Direction getDirection(){ return direction;}
        private void calculateDirection(int prevX,int prevY, int nextX,int nextY) {
            int diffX=nextX-prevX;
            int diffY=nextY-prevY;
            if(Math.abs(diffX)>Math.abs(diffY)){
                if(diffX>0) direction=Direction.RIGHT;
                else direction=Direction.LEFT;
            }else{
                if(diffY>0) direction=Direction.UP;
                else direction=Direction.DOWN;
            }
        }
    }
}
