/**
 * This class extends the Letter class and adds some additional functionality.
 * It maintains a content string, a family ID, and a related flag.
 */
public class ExtendedLetter extends Letter {
    private String content;
    private int family;
    private boolean related;
    public static final int SINGLETON = -1;

    /**
     * Constructor - Creates an ExtendedLetter with given content
     * @param s the content of the letter
     */
    public ExtendedLetter(String s) {
        super('a');  // Passing an arbitrary char to the superclass constructor
        this.content = s;
        this.related = false;
        this.family = SINGLETON;
    }

    /**
     * Constructor - Creates an ExtendedLetter with given content and family
     * @param s the content of the letter
     * @param fam the family ID of the letter
     */
    public ExtendedLetter(String s, int fam) {
        super('a');  // Passing an arbitrary char to the superclass constructor
        this.content = s;
        this.related = false;
        this.family = fam;
    }

    /**
     * Compares this letter to another object
     * @param other the object to compare with
     * @return boolean whether this letter is equal to the other object
     */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ExtendedLetter)) {
            return false;
        }
        if(((ExtendedLetter)other).family == (this.family)) {
            this.related = true;
        }
        return this.content.equals(((ExtendedLetter)other).content);
    }

    @Override
    public String toString() {
        if (this.isUnused() && this.related) {
            return "." + this.content + ".";
        } else {
            return decorator() + this.content + decorator();
        }
    }


    /**
     * Creates an array of Letters from arrays of strings and codes
     * @param content array of string contents
     * @param codes array of codes representing family IDs
     * @return array of Letters
     */

    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        for (int i = 0; i < content.length; i++) {
            if (codes == null) {
                letters[i] = new ExtendedLetter(content[i]);
            } else {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}