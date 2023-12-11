import java.io.*;
import java.util.*;

public class SearchSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // USER MENU//

        while (true) {
            System.out.println("\n");
            System.out.println("Menu of Searching and Sorting Testbed.");
            System.out.println("\n");
            System.out.println("1) Linear searching");
            System.out.println("2) Binary searching");
            System.out.println("3) 0(n^2) type of sorting");
            System.out.println("4) 0(n*log(n)) type of sorting");
            System.out.println("5) Sorting performance\n");
            System.out.println("q/Q) Quit\n");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print(
                            "In the list there are 0, ..., 9; which value would you like to search with linear search? ");
                    int num;
                    try {
                        num = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        continue;
                    }

                    if (LinearSearch(num) == true) {
                        System.out.println("\nFound");
                    } else {
                        System.out.println("\nNot found");
                    }
                    break;
                case "2":
                    System.out.print(
                            "In the list there are 0, ..., 9; which value would you like to search with linear search? ");
                    int num2;
                    try {
                        num2 = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        continue;
                    }

                    if (BinarySearch(num2) == true) {
                        System.out.println("\nFound");
                    } else {
                        System.out.println("\nNot found");
                    }
                    break;
                case "3":
                    int[] randomArr = getRandomArray();

                    System.out.print("\nData set before selection sort:\n");
                    for (int i = 0; i < randomArr.length; i++) {
                        System.out.print(randomArr[i] + " ");
                    }

                    int[] sortedArr = selectionSort(randomArr);

                    System.out.print("\n\nData set after selection sorting:\n");
                    for (int i = 0; i < sortedArr.length; i++) {
                        System.out.print(sortedArr[i] + " ");
                    }
                    break;
                case "4":
                    System.out.println("Choice 4 not implemented");
                    break;
                case "5":
                    System.out.println("Choice 5 not implemented");
                    break;
                case "q":
                    scanner.close();
                    System.exit(0);
                    break;
                case "Q":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid, try again.");
                    break;
            }
        }
    }

    // TIER 1 - LINEAR SEARCH//
    public static boolean LinearSearch(int num) {
        boolean found = false;
        int i = 0;
        while (!found && i <= 9) {
            if (i == num) {
                return found = true;
            } else
                i++;
        }
        return found;
    }

    // TIER 2 - BINARY SEARCH//
    public static boolean BinarySearch(int num) {
        int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] > num) {
                right = mid - 1;
            }
        }
        return false;
    }

    // GET RANDOM ARRAY FOR TIER 3 AND TIER 4 USE//
    public static int[] getRandomArray() {
        int[] randomArray = new int[10];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            // Generate a random integer between -100 and 100 (inclusive)
            randomArray[i] = random.nextInt(201) - 100;
        }

        return randomArray;
    }

    // TIER 3 - SELECTION SORT //

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}