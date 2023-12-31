import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

    public static void main(String[] args) {
    
        SortedLinkedList list = new SortedLinkedList();
	SortedLinkedList list2 = new SortedLinkedList();
    
        if (args.length < 1) {
            System.out.println("Provide the right input file.");
            return;
        }
        
    
        try (Scanner scanner = new Scanner(new File(args[0]))) {
                
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                ItemType item = new ItemType();
                item.initialize(number);
                list.INSERT(item,0);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("not found: " + args[0]);
        }


	Scanner scanner = new Scanner(System.in);
	char command = ' ';
	System.out.println("Enter a command:");
	do {
	    System.out.print("\n>");
	    String input = scanner.nextLine();
	    if (input.length() == 0) {
		System.out.println("Wrong command");
		continue;
	    }
	    command = input.charAt(0);
	    switch (command) {
	    case 'i':
		System.out.println("Enter a number to insert:");
		int numInsert = scanner.nextInt();
		scanner.nextLine(); 
		ItemType itemToInsert = new ItemType();
		itemToInsert.initialize(numInsert);
		System.out.print("Original list: ");
		list.PRINT();
		
		list.INSERT(itemToInsert,1);
		 System.out.print("New list: ");
		 list.PRINT();
		break;
	    case 'p':
		System.out.print("The List is:");
		list.PRINT();
		break;
	    case 'n':
		list.GETNEXT();
		break;
	    case 'd':
		// delete
		System.out.println("Enter a number to delete:");
                int numDelete = scanner.nextInt();
                scanner.nextLine();
                ItemType itemToDelete = new ItemType();
                itemToDelete.initialize(numDelete);
		System.out.print("Original list: ");
                list.PRINT();
		
                list.DELETE(itemToDelete);
		System.out.print("New list: ");
		list.PRINT();
		
                break;
	    case 's':
		System.out.println("Enter a number to search:");
		int numSearch = scanner.nextInt();
		scanner.nextLine(); 
		ItemType itemToSearch = new ItemType();
		itemToSearch.initialize(numSearch);
		list.SEARCH(itemToSearch);
		
		break;
	    case 'r':
		// reset
		list.RESET();
		System.out.println("Iterator is reset");
		break;
	    case 'l':
		// length
		System.out.print("The length of the list is " + list.LENGTH());
		
		break;
	    case 'a':
                // delete alternating
                System.out.print("Original list:"); list.PRINT();
		System.out.println("New list:"); list.ALTER();
		 list.PRINT();

		break;
	    case 'm':
                // Merge
		System.out.print("Original list:");
		list.PRINT();
		
		System.out.print("Enter the length of the list:");
		int length = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		
		if(length > 0) {
		    System.out.print("Enter the numbers in the list: ");
		    String newList = scanner.nextLine();
		    
		    if(!newList.trim().isEmpty()) {
			String[] numbers = newList.split("\\s+");
			for (String number : numbers) {
			    try {
				int num = Integer.parseInt(number);
				ItemType item = new ItemType();
				item.initialize(num);
				list.INSERT(item,0);
			    } catch (NumberFormatException e) {
				System.out.println(number + " is not a valid number. Skipping...");
			    }
			}
			System.out.print("Merged list:");
			list.PRINT();
		    } else {
			System.out.println("No numbers were entered.");
		    }
		} else {
		    System.out.println("Invalid list length.");
		}
		break;
		
	    case 't':
                // Intersection
                System.out.println("Enter the length of the new list:");
		int length2 = scanner.nextInt();
		
		System.out.println("Enter the numbers:");
		for (int i = 0; i < length2; i++) {
		    int num = scanner.nextInt();
		    ItemType item = new ItemType();
                item.initialize(num);
                list2.INSERT(item,0);
		}
		
		System.out.print("list 1: ");list.PRINT();
		System.out.print("list 2: "); list2.PRINT();
		
		SortedLinkedList Duplicates = list.getIntersection(list2);
		System.out.print("Intersection of lists: "); Duplicates.PRINT();
                break;
		
	    }
	} while (command != 'q');
    }
}
