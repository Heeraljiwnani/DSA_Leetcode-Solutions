
import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;
        int n = words.length;

        while (i < n) {

            int j = i;
            int lettersCount = 0;

            // Find maximum words that can fit in one line
            while (j < n &&
                   lettersCount + words[j].length() + (j - i) <= maxWidth) {

                lettersCount += words[j].length();
                j++;
            }

            int spaces = maxWidth - lettersCount;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            // Last line OR line with only one word
            if (j == n || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Left justify by adding remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Fully justify the line
                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int count = spacesPerGap;

                        // Give extra spaces to leftmost gaps
                        if (extraSpaces > 0) {
                            count++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < count; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            // Move to next line
            i = j;
        }

        return result;
    }
}
