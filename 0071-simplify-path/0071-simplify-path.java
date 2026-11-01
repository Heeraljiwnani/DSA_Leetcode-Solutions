
import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        // Split path using slash
        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Move to parent directory
            else if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Valid directory or file name
            else {
                stack.push(part);
            }
        }

        // Construct canonical path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // If stack is empty, return root
        return result.length() == 0 ? "/" : result.toString();
    }
}
