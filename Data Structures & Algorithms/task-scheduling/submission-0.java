class Solution {
    public int leastInterval(char[] tasks, int n) {
        // do whatever shows up the most first, so more things can be done in the meantime
        // also need to keep track of cooldowns for each thing, and subtract after each interval

        // also keep track of counts

        // first generate counts
        // iterate over counts and add to pq based on frequency

        // want to keep waiting (incrementing cpu cycles) as long as
        // there is some cooldown that is still going
        // add first thing to cooldowns first, then keep going
        // until cooldowns is empty (array)

        // need some way to decrement all cooldowns
        // once cooldown is over, add it back to pq if counts is > 0
        // need to init cooldowns to -1 since there is a difference between
        // cooldown 0, and not being in it
        int result = 0;
        int[] cooldowns = new int[26];

        for (int i = 0; i < cooldowns.length; i ++) {
            cooldowns[i] = -1;
        }

        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        Comparator<Character> comp = (a, b) -> counts[b - 'A'] - counts[a - 'A'];

        PriorityQueue<Character> pq = new PriorityQueue(comp);

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                int charInt = ((int) 'A') + i;
                pq.add((char) charInt);
            }
        }

        while (!(pq.isEmpty() && cooldownsEmpty(cooldowns))) {
            if (!pq.isEmpty()) {
                char curr = pq.remove();
                counts[curr - 'A'] --;
                if (countSum(counts) == 0) {
                    result ++;
                    break;
                }
                cooldowns[curr - 'A'] = n;
            }

            updateCooldowns(cooldowns, counts, pq);
            result ++;
        }

        return result;
    }

    private int countSum(int[] counts) {
        int result = 0;
        for (int i : counts) result += i;
        return result;
    }

    private void updateCooldowns(int[] cooldowns, int[] counts, PriorityQueue<Character> pq) {
        for (int i = 0; i < cooldowns.length; i ++) {
            if (cooldowns[i] == 0) {
                cooldowns[i] = -1;
                if (counts[i] > 0) {
                    int charInt = ((int) 'A') + i;
                    pq.add((char) charInt);
                }
            } else if (cooldowns[i] != -1) {
                cooldowns[i] --;
            }
        }
    }

    private boolean cooldownsEmpty(int[] cooldowns) {
        for (int i : cooldowns) {
            if (i != -1) return false;
        }
        return true;
    }
}
