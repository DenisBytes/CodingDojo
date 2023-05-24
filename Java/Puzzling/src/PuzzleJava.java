import java.util.Random;
public class PuzzleJava {
    Random random = new Random();
    int roll = random.nextInt();
    void getTenRolls (){
        for (int i = 0; i < 11; i++){
            roll = random.nextInt(0,20)+1;
            System.out.println(roll);
        }
    }
    String getRandomLetter(){
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        roll = random.nextInt(0, alphabet.length);
        return alphabet[roll];
    }

    String[] getNewPassword(){
        String[] characters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
        String[] password  =new String[8];
        for (int i = 0; i< password.length ; i++){
            roll = random.nextInt(0,characters.length);
            password[i] = characters[roll];
        }
        return password;
    }

    String[] getNewPasswordSet(int length){
        String[] characters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
        String[] password  =new String[length];
        for (int i = 0; i<length ; i++){
            roll = random.nextInt(0,characters.length);
            password[i] = characters[roll];
        }
        return password;
    }

    int[] shuffleArray (int[] array){
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
