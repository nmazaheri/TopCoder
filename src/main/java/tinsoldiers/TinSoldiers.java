package tinsoldiers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2910&rd=5849
 */
public class TinSoldiers {

    private Set<String> data = new HashSet<>();

    public int lineUps(int[] rankCounts) {
        data.clear();
        String lineup = getLineup(rankCounts);
        permute(lineup, 0, lineup.length()-1);
        System.out.println(data);
        return data.size();
    }

    private void permute(String str, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            addData(str);
            return;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            String s = swap(str, startIndex, i);
            permute(s, startIndex + 1, endIndex);
        }
    }

    public String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private void addData(String lineup) {
        if (data.contains(lineup) || data.contains(reverse(lineup))) {
            return;
        }
        data.add(lineup);
    }

    String getLineup(int[] rankCounts) {
        char rank = 'a' - 1;
        StringBuilder sb = new StringBuilder();

        for (int r : rankCounts) {
            rank++;
            for (int i = 0; i < r; i++) {
                sb.append(rank);
            }
        }
        return sb.toString();
    }

    String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
