package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {

    @Override
    public void breakPassword(int sizeOfPassword) {
        char[] password = new char[sizeOfPassword];
        int currCharIndex = 0;
        if (sizeOfPassword == 0) tryOpen(password);
        guessChar(password, sizeOfPassword, currCharIndex);
    }

    public void guessChar(char[] password, int sizeOfPassword, int currCharIndex) {
        if (currCharIndex < sizeOfPassword) {
            for (char sugChar : getCharacters()) {
                password[currCharIndex] = sugChar;
                if (currCharIndex == sizeOfPassword - 1 && tryOpen(password)) return;
                if (!isOpened()) guessChar(password, sizeOfPassword, currCharIndex + 1);
            }
        }
    }
}
