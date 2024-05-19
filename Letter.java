public class Letter {
    private char letter; // the letter represented by this instance
    private int label; // label to track the state of this letter: unused, used, or correct

    public static final int UNSET = 0;
    public static final int UNUSED = 1;
    public static final int USED = 2;
    public static final int CORRECT = 3;

    // Constructor initializes the letter with a given character and an unset label
    public Letter(char c) {
        this.letter = c;
        this.label = UNSET;
    }

    // Equality check based on the character value of the letter
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter otherLetter = (Letter) otherObject;
            return this.letter == otherLetter.letter;
        } else {
            return false;
        }
    }

    // Decorates the letter based on its label
    public String decorator() {
        switch (this.label) {
            case UNUSED:
                return "-";
            case USED:
                return "+";
            case CORRECT:
                return "!";
            default:
                return " ";
        }
    }

    // Returns a string representation of the letter with decorators
    @Override
    public String toString() {
        return decorator() + this.letter + decorator();
    }

    // Setters to update the label state of the letter
    public void setUnused() { this.label = UNUSED; }
    public void setUsed() { this.label = USED; }
    public void setCorrect() { this.label = CORRECT; }
    public boolean isUnused() { return this.label == UNUSED; }

    // Static method to create an array of Letter objects from a string
    public static Letter[] fromString(String s) {
        Letter[] letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letters[i] = new Letter(s.charAt(i));
        }
        return letters;
    }
}