package Exercise.section9.ex19;

import java.util.Random;

interface GGames{
    void play();
}
interface GGamesFactory{
    GGames getGGames();
}

class IconGamesFactory implements GGamesFactory {

    @Override
    public GGames getGGames() {
        return new IconGames();
    }
}
class IconGames implements GGames {
    Random random = new Random();
    @Override
    public void play() {
        switch (random.nextInt(3)) {
            case 0:
                System.out.println("head");
                break;
            case 1:
                System.out.println("Tails");
                break;
            case 2:
                System.out.println("OnEdge");
                break;
        }
    }
}

class DiceGame implements GGames {
    Random random = new Random();
    @Override
    public void play() {
        System.out.println(random.nextInt(6)+1);
    }
}
class DiceGameFactory implements GGamesFactory{

    @Override
    public GGames getGGames() {
        return new DiceGame();
    }
}

public class Games19Demo {
    public static void playGame(GGamesFactory gamesFactory) {
        GGames g=gamesFactory.getGGames();
        g.play();
    }

    public static void main(String[] args) {
        playGame(new IconGamesFactory());
        playGame(new DiceGameFactory());
    }
}
