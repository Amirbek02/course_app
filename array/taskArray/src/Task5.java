class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class Task5 {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;

        Node winner = findWinner(n, m);

        System.out.println("Номер победителя: " + winner.value);
        System.out.println("Количество монет: " + winner.value);
    }

    public static Node findWinner(int n, int m) {
        Node first = new Node(1);
        Node current = first;

        for (int i = 2; i <= n; i++) {
            current.next = new Node(i);
            current = current.next;

        }
        for(int value : first) System.out.println(value);
        current.next = first;

        while (n > 1) {
            for (int i = 0; i < m - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
            n--;
        }

        return current;
    }
}
