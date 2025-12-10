public interface MVObserver {
    void updateTiles(Tile[] tiles);
    void updateScore(int score);
    void updateWin(boolean win);
    void updateLose(boolean lose);
}
