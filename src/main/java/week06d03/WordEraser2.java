package week06d03;

public class WordEraser2 {

    /*week06d03.WordEraser osztályban legyen egy eraseWord(String words, String word) metódus,
    mely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előforulását kitörli belőle.
    A words paraméterben a szavak szóközzel vannak elválasztva.
    A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel.
    (Mellőzzük a replace és replaceAll használatát)
     */

    public String eraseWord(String words, String word) {
        StringBuilder str = new StringBuilder();
        String[] splitted = words.split(" ");
        for (String item : splitted) {
            if (!item.equals(word)) {
                str.append(item + " ");
            }
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }
}
