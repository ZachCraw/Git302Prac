public class main {
    public static void main(String[] args) {
        // Test the leftPad method
        System.out.println(leftPad("Hello, world!", 30, ' '));
        System.out.println(leftPad("Welcome to CAB302!", 30, ' '));
        System.out.println(leftPad("This is our first project!", 30, ' '));
        printBox("Alice likes rectangles!");
        for (int i = 0; i < 5; i++) {
            System.out.println("*****************");
        }
        printBox("Bob likes triangles!");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < (4 - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 4 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static String leftPad(String str, int len, char ch) {
        // Convert `str` to a `String`
        str = String.valueOf(str);
        // `len` is the `pad`'s length now
        len = len - str.length();
        // Doesn't need to pad
        if (len <= 0) return str;
        // `ch` defaults to `' '`
        if (ch == 0) ch = ' ';
        // Convert `ch` to a `String` because it could be a number
        String chStr = String.valueOf(ch);
        // Cache common use cases
        if (ch == ' ' && len < 10) {
            StringBuilder cache = new StringBuilder();
            for (int i = 0; i < len; i++) {
                cache.append(chStr);
            }
            return cache.toString() + str;
        }
        // Initialize `pad` as an empty string
        StringBuilder pad = new StringBuilder();
        // Loop
        while (true) {
            // Add `ch` to `pad` if `len` is odd
            if ((len & 1) == 1) {
                pad.append(chStr);
            }
            // Divide `len` by 2, ditch the remainder
            len <<= 1;
            // "Double" the `ch` so this operation count grows logarithmically on `len`
            // Each time `ch` is "doubled", the `len` would need to be "doubled" too
            // Similar to finding a value in a binary search tree, hence O(log(n))
            if (len != 0) {
                chStr += chStr;
            } else {
                break;
            }
        }
        // Pad `str`!
        return pad.toString() + str;
    }

    /**
     * Print a string with a box around it, using the box-drawing characters.
     * @param str the string to be printed
     */
    public static void printBox(String str) {
        int len = str.length() + 4;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                System.out.print("╔");
            } else if (i == len - 1) {
                System.out.print("╗");
            } else {
                System.out.print("═");
            }
        }
        System.out.println();
        System.out.println("║ " + str + " ║");
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                System.out.print("╚");
            } else if (i == len - 1) {
                System.out.print("╝");
            } else {
                System.out.print("═");
            }
        }
        System.out.println();
    }
}