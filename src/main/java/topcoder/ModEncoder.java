package topcoder;

// https://community.topcoder.com/stat?c=problem_statement&pm=61&rd=3003
public class ModEncoder {

    public String encoder(String input) {
        input = input.replace(" ", "~");
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < (input.length() - 1) % 5; i++) {
            sb.append("~");
        }
        for (int i = 5; i < input.length(); i += 6) {
            sb.insert(i, "\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
