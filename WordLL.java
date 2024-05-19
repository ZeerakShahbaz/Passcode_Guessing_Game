public class WordLL {
    private Word mysteryWord; // the mystery word to be guessed
    private LinearNode<Word> history; // the history of guesses made so far

    // Constructor initializes with a given mystery word and an empty history
    public WordLL(Word mystery) {
        this.mysteryWord = mystery;
        this.history = null;
    }

    /**
     * Attempts a word guess, updates the history and returns whether the guess is correct
     * @param guess the word being guessed
     * @return boolean whether the guess is correct
     */
    public boolean tryWord(Word guess) {
        boolean isIdentical = guess.labelWord(mysteryWord);
        LinearNode<Word> node = new LinearNode<>(guess);
        node.setNext(history);
        history = node;
        return isIdentical;
    }

    // Returns a string representation of the history of guesses
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinearNode<Word> current = history;

        while (current != null) {
            builder.append(current.getElement().toString()).append("\n");
            current = current.getNext();
        }

        return builder.toString();
    }
}
