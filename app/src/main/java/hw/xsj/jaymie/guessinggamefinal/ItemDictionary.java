package hw.xsj.jaymie.guessinggamefinal;

public class ItemDictionary {

    public static int getItemImageByGameId(int id) {
        switch (id) {
            case 0:
                return R.drawable.bulbasaur;
            case 1:
                return R.drawable.charmander;
            case 2:
                return R.drawable.eevee;
            case 3:
                return R.drawable.pikachu;
            case 4:
                return R.drawable.meowth;
            case 5:
                return R.drawable.squirtle;
            case 6:
                return R.drawable.mew;
            case 7:
                return R.drawable.magikarp;
        }

        return -1;
    }
}
