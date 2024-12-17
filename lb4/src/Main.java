import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();

        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("orange");
        System.out.println("ArrayList после добавления элементов: " + arrayList);

        Collection<String> fruits = new ArrayList<>();
        fruits.add("grape");
        fruits.add("melon");
        arrayList.addAll(fruits);
        System.out.println("ArrayList после добавления всех элементов из fruits: " + arrayList);

        arrayList.clear();
        System.out.println("ArrayList после очистки: " + arrayList);

        arrayList.add("apple");
        System.out.println("ArrayList содержит 'apple': " + arrayList.contains("apple"));

        fruits.add("orange");
        System.out.println("ArrayList содержит все элементы из fruits: " + arrayList.containsAll(fruits));

        System.out.println("ArrayList пуст: " + arrayList.isEmpty());
        arrayList.add("orange");
        System.out.println(arrayList);
        ListIterator<String> iterator = arrayList.listIterator();
        System.out.print("Элементы ArrayList: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        arrayList.remove("apple");
        System.out.println("ArrayList после удаления 'apple': " + arrayList);

        arrayList.removeAll(fruits);
        System.out.println("ArrayList после удаления всех элементов, содержащихся в fruits: " + arrayList);

        // Создание коллекции TreeSet для хранения уникальных идентификаторов
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(24);
        treeSet.add(23);
        treeSet.add(30);
        System.out.println("TreeSet: " + treeSet);

        System.out.println("Первый элемент: " + treeSet.first());
        System.out.println("Последний элемент: " + treeSet.last());
        System.out.println("Наименьший элемент >= 15: " + treeSet.ceiling(15));
        System.out.println("Наибольший элемент <= 25: " + treeSet.floor(25));
        System.out.println("Наименьший элемент > 15: " + treeSet.higher(15));
        System.out.println("Наибольший элемент < 25: " + treeSet.lower(25));
        System.out.println("Извлечение и удаление первого элемента: " + treeSet.pollFirst());
        System.out.println("Извлечение и удаление последнего элемента: " + treeSet.pollLast());
        System.out.println("TreeSet после извлечения: " + treeSet);

        TreeSet<Integer> subSet = (TreeSet<Integer>) treeSet.subSet(10, 20);
        System.out.println("Поднабор от 10 до 20: " + subSet);

        TreeSet<Integer> headSet = (TreeSet<Integer>) treeSet.headSet(20);
        System.out.println("Набор элементов меньше 20: " + headSet);

        TreeSet<Integer> tailSet = (TreeSet<Integer>) treeSet.tailSet(20);
        System.out.println("Набор элементов больше или равных 20: " + tailSet);

        arrayList.add(0, "kiwi");
        System.out.println("ArrayList после добавления 'kiwi' по индексу 0: " + arrayList);

        arrayList.addAll(1, fruits);
        System.out.println("ArrayList после добавления всех элементов из fruits по индексу 1: " + arrayList);

        String elementAtIndex = arrayList.get(2);
        System.out.println("Элемент ArrayList по индексу 2: " + elementAtIndex);

        int index = arrayList.indexOf("melon");
        System.out.println("Индекс первого вхождения 'banana' в ArrayList: " + index);

        int lastIndex = arrayList.lastIndexOf("orange");
        System.out.println("Индекс последнего вхождения 'orange' в ArrayList: " + lastIndex);


        System.out.println(arrayList);
        List<String> subList = arrayList.subList(1, 3);
        System.out.println("Подсписок ArrayList с индекса 1 до индекса 3: " + subList);
    }
}
