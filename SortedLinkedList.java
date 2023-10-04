public class SortedLinkedList {
    public static final int GREATER = 1;
    public static final int EQUAL = 0;
    public static final int LESS = -1;
    
    private NodeType location;
    private NodeType predloc = null;
    private NodeType listData;
    private int index = 1;
    private boolean end;
    //creates a new sorted linked list its the main and declares the main variables I used predloc listdata and location to iterate across the list    
    public SortedLinkedList(){
	listData = null;
	location = null;
	predloc = null;
    }
    //resets the iteration of list and resets end O(1)
    public void RESET(){
	location = null;
	predloc = null;
	end = false;
    }
    //prints the list in the correct format O(n)
    public void PRINT(){
	location = listData;
	while (location != null) {
            System.out.print(location.info.getValue() + " ");
            predloc = location;
            location = location.next;
        }
        System.out.println();
    }
    //gets the next item in the list O(1)
    
    public void GETNEXT() {
        if (isEmpty()) {
	    
            System.out.println("The list is empty");
	    
        }
	if(end == false){
	    if (location == null) {
		
		location = listData;
		
	    } else {
		
		predloc = location;
		location = location.next;
	    }
	    
        if (location != null) {
            
            System.out.println(location.info.getValue());
        } else {
            end = true;
	    //System.out.println("You have reached the end of the list.");
	    
	    //return-1;
        }
	}
	else{
	    System.out.println("You have reached the end of the list.");
	    
	}
    }
    
    //returns the length of the list O(n)
    public int LENGTH() {
	
	int length = 0;
	location = listData;
	while (location != null){
	    length++;
	    location = location.next;
	}
	return length;
    }
    //Inserts a new item in the array Split into 3 cases I added a int flag so i can display text for duplicate items or to ignore it in other functions.
    public void INSERT(ItemType item, int flag) {
	if (isEmpty()) {
	    NodeType newNode = new NodeType();
	    newNode.info = item;
	    newNode.next = null;
	    listData = newNode;
	    return;
	}
	
	NodeType location = listData;
	NodeType predloc = null;
	boolean found = false;
	boolean moreToSearch = (location != null);
	while (moreToSearch && !found) {
	    if (location.info == null) {
		
		break;
	    }
	    
	    switch (item.compareTo(location.info)) {
            case GREATER:
                predloc = location;
                location = location.next;
                moreToSearch = (location != null);
                break;
            case EQUAL:
		if(flag == 1){
		    System.out.println("Sorry. You cannot insert the duplicate item");
		}
		found = true;
		
                break;
            case LESS:
                moreToSearch = false;
                break;
	    }
	}
	
	if (found) {
	    return;
    } else {
	    NodeType newNode = new NodeType();
	    newNode.info = item;
	    newNode.next = location;
	    if (predloc == null) {
            listData = newNode;
	    } else {
            predloc.next = newNode;
        }
    }
}

    // Check if the list is empty
    public boolean isEmpty() {
	return listData == null;
    }
    
    //returns index O(1)
    public int getIndex(){
	return index;
    }
    // Search function has different cases. iterates through the list if the item is greater
    boolean SEARCH(ItemType item){
	NodeType location = listData;
	NodeType predloc = null;
	boolean found = false;
	boolean moreToSearch = (location != null);
	index = 1;
	
	while(moreToSearch && !found) {

	    switch(item.compareTo(location.info)){

	    case GREATER:
		predloc = location;
		location = location.next;
		index++;
		break;
	    case EQUAL:
		found = true;
		break;
	    case LESS:
		moreToSearch = false;
		break;
	}

	}
	if(found) {
	    int foundindex = getIndex();
	    System.out.println("Item is present at index." + getIndex());
	    return true;
	}
	else{
	    System.out.println("number not found.");
	    return true;
	}
	
	
    }
    //Deletes an item from the list given from the
    public void DELETE(ItemType item) {
    NodeType location = listData;
    NodeType predloc = null;
    boolean found = false;
    while (location != null && !found) {
        if (item.compareTo(location.info) == EQUAL) {
            found = true;
        } else {
            predloc = location;
            location = location.next;
        }
    }
    if (!found) {
        System.out.println("Error Item not found");
    } else {
        if (predloc == null) {
            listData = location.next;
        } else {
            predloc.next = location.next;
        }
    }
    }
    //alternates every other node and deletes it
    public void ALTER() {
	if (isEmpty()) {
	    System.out.println("The list is empty.");
	    return;
	}
	
	location = listData;
	predloc = null;
	boolean delete = false;
	
	while (location != null) {
	    if (delete) {
		if (predloc != null) {
		    predloc.next = location.next;
		} else {
		    listData = location.next;
		}
		delete = false;
	    } else {
		predloc = location;
		delete = true;
	    }
	    location = location.next;
	}
    }
    
    // I did not createa a function for merge but the case still works I just created a string and inserted the numbers given in the string.
    
    //I made this for Intersect it uses list and list2. it creates 2 list with seperate nodes and compares them. if they are the same it creates a 3rd list and puts the values in there.
    public SortedLinkedList getIntersection(SortedLinkedList list2) {
        SortedLinkedList intersectionList = new SortedLinkedList();
        NodeType node1 = this.listData;
        NodeType node2 = list2.listData;
	
        while (node1 != null && node2 != null) {
            if (node1.info.getValue() < node2.info.getValue()) {
                node1 = node1.next;
            } else if (node1.info.getValue() > node2.info.getValue()) {
                node2 = node2.next;
            } else {
                intersectionList.INSERT(node1.info,0);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return intersectionList;
    }
}



