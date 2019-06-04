package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2947&rd=5855
 */
public class LoadBalancing {

    int result;

    public int minTime(int[] chunkSizes) {
        Arrays.sort(chunkSizes);

        int aTotal = 0;
        int bTotal = 0;
        for (int i = chunkSizes.length - 1; i >= 0; i--) {
            int chunk = chunkSizes[i];
            if (aTotal <= bTotal) {
                aTotal += chunk;
            } else {
                bTotal += chunk;
            }
        }
        return Math.max(aTotal, bTotal);
    }

    public int minTimeDP(int[] chunkSizes) {
        result = Integer.MAX_VALUE;
        boolean[] decisions = new boolean[chunkSizes.length];
        permute(chunkSizes, decisions, 0);
        return result;
    }

    private void permute(int[] chunkSizes, boolean[] decisions, int loc) {
        if (loc == chunkSizes.length - 1) {
            int total = calculate(chunkSizes, decisions);
            System.out.println(Arrays.toString(decisions) + " results in " + total);
            result = Math.min(total, result);
            return;
        }

        boolean[] clone = decisions.clone();
        clone[loc] = true;
        loc++;
        permute(chunkSizes, clone, loc);
        permute(chunkSizes, decisions, loc);
    }

    private int calculate(int[] data, boolean[] decisions) {
        int cpuOne = 0;
        int cpuTwo = 0;
        for (int i = 0; i < decisions.length; i++) {
            boolean decision = decisions[i];
            if (decision) {
                cpuOne += data[i];
            } else {
                cpuTwo += data[i];
            }
        }
        return Math.max(cpuOne, cpuTwo);

    }

    public int minTimeDP2(int[] chunkSizes) {
//        List<Integer> chunks = Arrays.stream(chunkSizes).boxed().collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        for (int chunk : chunkSizes) {
            stack.add(chunk);
        }
        return permute(stack, new ArrayList<>(), new ArrayList<>());
    }

    private int permute(Stack<Integer> chunks, List<Integer> cpuOne, List<Integer> cpuTwo) {
        System.out.println(cpuOne.toString() + " " + cpuTwo.toString());
        if (chunks.isEmpty()) {
//            System.out.println(cpuOne.toString() + " " + cpuTwo.toString());
            return Math.max(cpuOne.stream().mapToInt(Integer::intValue).sum(), cpuTwo.stream().mapToInt(Integer::intValue).sum());
        }
        Integer pop = chunks.pop();

        List<Integer> oldCpuOne = new ArrayList<>(cpuOne);

        cpuOne.add(pop);
        int cpuOneTotal = permute(chunks, cpuOne, cpuTwo);
        cpuTwo.add(pop);
        int cpuTwoTotal = permute(chunks, oldCpuOne, cpuTwo);
        return Math.min(cpuOneTotal, cpuTwoTotal);
    }
}
