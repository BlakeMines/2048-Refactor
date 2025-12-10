import java.util.*;

public abstract class MVSubject {
    public enum MVUpdates { LOSE, WIN, SCORE, TILES, ALL }

    private final Map<MVUpdates, List<MVObserver>> observers = new HashMap<>();

    public void addObserver(MVUpdates update, MVObserver observer) {
        if (update.equals(MVUpdates.ALL)) {
            for (MVUpdates value : MVUpdates.values()) {
                List<MVObserver> list = observers.computeIfAbsent(value, k -> new ArrayList<>());
                list.add(observer);
            }
            return;
        }

        List<MVObserver> updateList =  observers.computeIfAbsent(update, k -> new ArrayList<>());
        updateList.add(observer);
    }

    public void removeObserver(MVUpdates update, MVObserver observer) {
        List<MVObserver> updateList = observers.computeIfAbsent(update, k -> new ArrayList<>());
        updateList.remove(observer);
    }
    public void notifyLose(boolean lose) {
        List<MVObserver> updateList = observers.computeIfAbsent(MVUpdates.LOSE, k -> new ArrayList<>());
        for (MVObserver observer : updateList) {
            observer.updateLose(lose);
        }
    }

    public void notifyWin(boolean win) {
        List<MVObserver> updateList = observers.computeIfAbsent(MVUpdates.WIN, k -> new ArrayList<>());
        for (MVObserver observer : updateList) {
            observer.updateWin(win);
        }
    }

    public void notifyScore(int score) {
        List<MVObserver> updateList = observers.computeIfAbsent(MVUpdates.SCORE, k -> new ArrayList<>());
        for (MVObserver observer : updateList) {
            observer.updateScore(score);
        }
    }

    public void notifyTile(Tile[] tiles) {
        List<MVObserver> updateList = observers.computeIfAbsent(MVUpdates.TILES, k -> new ArrayList<>());
        for (MVObserver observer : updateList) {
            observer.updateTiles(tiles);
        }
    }
}
