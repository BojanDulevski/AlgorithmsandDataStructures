
    public static int evaluate(String expr) {
        int n = expr.length();
        int currentNumber = 0;
        char lastOperator = '+';

        java.util.List<Integer> list = new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // ако е оператор ИЛИ ако е последниот карактер
            if (!Character.isDigit(c) || i == n - 1) {

                // ако последниот оператор е + → додади број
                if (lastOperator == '+') {
                    list.add(currentNumber);
                }
                // ако последниот оператор е * → множи со последниот
                else if (lastOperator == '*') {
                    int last = list.remove(list.size() - 1);
                    list.add(last * currentNumber);
                }

                // !!! важно !!! ажурирај оператор само ако е оператор
                if (c == '+' || c == '*') {
                    lastOperator = c;
                }

                currentNumber = 0;
            }
        }

        // финално собирање
        int sum = 0;
        for (int x : list) sum += x;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(evaluate(""));
        System.out.println(evaluate(""));
        System.out.println(evaluate(""));
    }
}
