public class Player {
    private final int MAP_DISTANCE = 40;
    private int moneyInWallet;
    private int positionOnMap;
    private final PlayersColors playerColor;
    private PlayerStatus playerStatus;
    Player(PlayersColors color) {
        //TODO: Ekonomia -> pieniądze startowe
        moneyInWallet = 100;
        positionOnMap = 0;
        playerColor = color;
        playerStatus = PlayerStatus.IN_GAME;
    }
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
    public void blockPlayer() {
        playerStatus = PlayerStatus.IN_JAIL;
    }
    public void unlockPlayer() {
        playerStatus = PlayerStatus.IN_JAIL;
    }
    public void losePlayer() {
        playerStatus = PlayerStatus.LOST;
    }
    public void playerMove(int distance) {
        positionOnMap += distance;
        if ( positionOnMap >= 40 )
            positionOnMap -= positionOnMap;
    }
    public int getPosition() {
        return positionOnMap;
    }
    public void increaseMoney(int amount) {
        moneyInWallet += amount;
    }
    public void decreaseMoney(int amount) {
        moneyInWallet -= amount;
    }
    public int getMoneyInWallet() {
        return moneyInWallet;
    }
}
