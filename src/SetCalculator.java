import java.util.*;

public class SetCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input without any space: example [x]+[y] and press enter");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replace("+", " + ").replace("*", " * ").replace("-", " - ");
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid input. Please enter in the format: [set1] operator [set2]");
                continue;
            }

            try {
                TreeSet<Integer> set1 = parseSet(parts[0]);
                TreeSet<Integer> set2 = parseSet(parts[2]);
                String operator = parts[1];

                
                switch (operator) {
                    case "+":
                        set1.addAll(set2);
                        break;
                    case "*":
                        set1.retainAll(set2);
                        break;
                    case "-":
                        set1.removeAll(set2);
                        break;
                    default:
                        System.out.println("Invalid operator. Please use +, *, or -.");
                        continue;
                }

                System.out.println(set1);
            } catch (Exception e) {
                System.out.println("Error parsing sets. Please ensure sets are in the format: [1, 2, 3]");
            }
        }
        scanner.close();
    }

    private static TreeSet<Integer> parseSet(String s) throws Exception {
        s = s.replace("[", "").replace("]", "");
        String[] parts = s.split(",");
        TreeSet<Integer> set = new TreeSet<>();
        for (String part : parts) {
            int num = Integer.parseInt(part.trim());
            if (num < 0) {
                throw new Exception("Negative integers are not allowed.");
            }
            set.add(num);
        }
        return set;
    }
}
