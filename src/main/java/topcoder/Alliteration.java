package topcoder;

public class Alliteration {

    public int count(String [] words) {
        int count = 0;
        char previous = getFirstCharLower(words[0]);
        boolean match = false;

        for (int i = 1; i<words.length; i++) {
            char current = getFirstCharLower(words[i]);
            System.out.println(current + " " + previous);
            if (!match && current == previous) {
                count++;
            }
            match = (current == previous);
            previous = current;
        }
        return count;
    }

    private char getFirstCharLower(String s) {
        return s.toLowerCase().charAt(0);
    }

    public static void main(String[] args) {
        Alliteration alliteration = new Alliteration();
        String [] s1 = {"He", "has", "four", "fanatic", "fantastic", "fans"};
        System.out.println(alliteration.count(s1));

        String [] s2 = {"There", "may", "be", "no", "alliteration", "in", "a", "sequence"};
        System.out.println(alliteration.count(s2));

        String [] s3 = {"Round", "the", "rugged", "rock", "the", "ragged", "rascal", "ran"};
        System.out.println(alliteration.count(s3));
    }
}
