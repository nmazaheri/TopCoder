package medaltable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2922&rd=5855
 */
public class MedalTable {
    private final static int MEDAL_COUNT = 3;

    public String[] generate(String[] results) {
        Map<String, Medals> data = new HashMap<>();
        for (String r : results) {
            String[] countries = r.split(" ");
            for (int i = 0; i < MEDAL_COUNT; i++) {
                String country = countries[i];
                data.putIfAbsent(country, new Medals(country));
                data.get(country).increment(i);
            }
        }
        return data.values().stream().sorted().map(Medals::toString).toArray(String[]::new);
    }

    public class Medals implements Comparable<Medals> {
        public Medals(String country) {
            this.country = country;
        }

        private String country;
        private int[] values = new int[MEDAL_COUNT];

        public void increment(int location) {
            values[location]++;
        }

        public int getValue(int i) {
            return values[i];
        }

        @Override
        public String toString() {
            return country + " " + values[0] + " " + values[1] + " " + values[2];
        }

        @Override
        public int compareTo(Medals o) {
            for (int i = 0; i < MEDAL_COUNT; i++) {
                int flag = o.getValue(i) - this.getValue(i);
                if (flag != 0) {
                    return flag;
                }
            }
            return country.compareTo(o.country);
        }
    }
}
