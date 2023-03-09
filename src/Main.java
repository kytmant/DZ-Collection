import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию: \n 1.Добавить; 2.Показать; 3.Удалить; 4.Поиск продукта; end - завершить работу");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            try {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        addProduct(scanner, arrayList);
                        break;
                    case 2:
                        showProduct(arrayList);
                        break;
                    case 3:
                        deleteProduct(scanner, arrayList);
                        break;
                    case 4:
                        searchProduct(scanner, arrayList);
                        break;
                    default:
                        System.out.println("Введите корректную операцию!");
                        System.out.println();
                }
            } catch (RuntimeException exception) {
                System.out.println("Указана некорректная операция!");
            }
        }
    }

    private static void searchProduct(Scanner scanner, ArrayList<String> arrayList) {
        System.out.println("Введите текст для поиска:");
        String search = scanner.nextLine();
        String queryLower = search.toLowerCase();

        int i = 0;
        System.out.println("Найдено:");
        for (String s : arrayList) {
            String string = s.toLowerCase();
            if (string.contains(queryLower)) {
                System.out.println(i + 1 + ". " + arrayList.get(i));
            }
            i++;
        }
    }

    private static void deleteProduct(Scanner scanner, ArrayList<String> arrayList) {
        try {
            boolean isRemove = false;
            System.out.println("Список покупок:");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(i + 1 + ". " + arrayList.get(i));
            }
            System.out.println("Какую покупку хотите удалить? Введите название или номер покупки");
            String delete = scanner.nextLine();
            isRemove = arrayList.remove(delete);

            if (isRemove == true) {
                System.out.println("Покупка '" + delete + "' удалена. Текущий список покупок:");
            } else {
                System.out.println("Покупка '" + arrayList.get(Integer.parseInt(delete) - 1) + "' удалена. Текущий список покупок:");
                arrayList.remove(Integer.parseInt(delete) - 1);
            }
        } catch (RuntimeException exception) {
            System.out.println("Введите корректное число или название продукта!!!\n");
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + 1 + ". " + arrayList.get(i));
        }
    }

    private static void showProduct(ArrayList<String> arrayList) {
        System.out.println("Список покупок:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + 1 + ". " + arrayList.get(i));
        }
        System.out.println();
    }

    private static void addProduct(Scanner scanner, ArrayList<String> arrayList) {
        System.out.println("Какую покупку хотите добавить?");
        arrayList.add(scanner.nextLine());
        System.out.println("Итого в списке покупок: " + arrayList.size());
        System.out.println();
    }
}