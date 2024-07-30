public class resolvingconflicts {
    public static void main(String[] args){
        System.out.println("Bob likes triangles!");
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
}
