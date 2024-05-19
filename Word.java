/**
 * This class represents a Word consisting of Letters.
 * It maintains the letters in a linked list.
 */
public class Word {
    private LinearNode<Letter> firstLetter; // Head of the Linked List

    /**
     * Constructor - Creates a Word from an array of letters
     * @param letters Array of letters forming the word
     */
    public Word(Letter[] letters) {
        if (letters.length > 0) {
            firstLetter = new LinearNode<Letter>(letters[0]); // Setting the first letter
            LinearNode<Letter> current = firstLetter; // Initializing the current node
            for (int i = 1; i < letters.length; i++) {
                LinearNode<Letter> newNode = new LinearNode<Letter>(letters[i]); // Creating new node for each letter
                current.setNext(newNode); // Linking the nodes
                current = newNode;
            }
        }
    }

    /**
     * Converts the Word to a string
     * @return string representation of the word
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Word: ");
        LinearNode<Letter> current = firstLetter; // Start with the first letter
        while (current != null) {
            builder.append(current.getElement().toString()).append(" ");
            current = current.getNext();
        }
        return builder.toString();
    }

    /**
     * Compares the current word with the mystery word and labels the letters accordingly
     * @param mystery the mystery word to compare with
     * @return boolean whether the current word is identical to the mystery word
     */

    public boolean labelWord(Word mystery) {
        boolean isIdentical = true;
        boolean isUsed;
        LinearNode<Letter> thisCurrent = this.firstLetter;
        LinearNode<Letter> mysteryCurrent = mystery.firstLetter;

        while (thisCurrent != null) {
            Letter thisLetter = thisCurrent.getElement();
            mysteryCurrent = mystery.firstLetter;
            isUsed = false;
            while (mysteryCurrent != null) {
                Letter mysteryLetter = mysteryCurrent.getElement();
                if (thisLetter.equals(mysteryLetter)) {
                    thisLetter.setUsed();
                    isUsed = true;
                }
                mysteryCurrent = mysteryCurrent.getNext();
            }
            if (!isUsed) {
                thisLetter.setUnused();
            }
            thisCurrent = thisCurrent.getNext();
        }
        thisCurrent = this.firstLetter;
        mysteryCurrent = mystery.firstLetter;

        while(thisCurrent != null && mysteryCurrent != null) {
            Letter thisLetter = thisCurrent.getElement();
            Letter mysteryLetter = mysteryCurrent.getElement();
            if (!thisLetter.equals(mysteryLetter)) {
                isIdentical = false;
            }
            else {
                thisLetter.setCorrect();
            }
            thisCurrent = thisCurrent.getNext();
            mysteryCurrent = mysteryCurrent.getNext();
        }

        if (thisCurrent != null || mysteryCurrent != null) {
            isIdentical = false; // If either linked list has more elements, they can't be identical
        }
        return isIdentical;
    }

    public boolean contains(Letter letter) {
        LinearNode<Letter> current = this.firstLetter;
        while(current != null) {
            if(current.getElement().equals(letter)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}