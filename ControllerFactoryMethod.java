// TODO: Review this solution
public class ControllerFactoryMethod {
    public static GameController makeController(String type) {
        if (type.toLowerCase().contains("mouse")) {
            return new MouseController();
        }
        return new KeyController();
    }
}
