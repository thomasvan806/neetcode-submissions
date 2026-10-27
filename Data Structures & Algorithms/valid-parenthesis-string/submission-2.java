class Solution {
    public boolean checkValidString(String s) {
        // keep track of how many starLeft, starRight, and starEmpty we have used
        // when considering curr char
        // if star, do most optimal thing now
        // if positive, do starRight
        // if negative, do starLeft
        // if 0, do starEmpty
        // if left, increment count
        // if right either replace starRight with starEmpty, or
        // replace starEmpty with starLeft
        // check if starLeft > 0, and decrement, incrementing starEmpty, then subtract total
        int total = 0;
        int starLeft = 0;
        int starEmpty = 0;
        int starRight = 0;

        for (int i = 0; i < s.length(); i ++) {
            char currChar = s.charAt(i);

            if (currChar == '(') {
                total ++;
            } else if (currChar == ')') {
                total --;
                if (total < 0) {
                    if (starRight > 0) {
                        starRight --;
                        starEmpty ++;
                        total ++;
                    } else if (starEmpty > 0) {
                        starEmpty --;
                        starLeft ++;
                        total ++;
                    } else {
                        return false;
                    }
                }
            } else {
                if (total > 0) {
                    total --;
                    starRight ++;
                } else {
                    starEmpty ++;
                }
            }
        }

        return total == 0;
    }
}
