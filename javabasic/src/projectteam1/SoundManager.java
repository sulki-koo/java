package projectteam1;

public class SoundManager {
    private Sound sound;

    public SoundManager() {
        sound = new Sound();
    }

    public void playStart() {
        sound.playStart();
    }

    public void playGameOver() {
        sound.playGameOver();
    }

    public void playClear() {
        sound.playClear();
    }
}
