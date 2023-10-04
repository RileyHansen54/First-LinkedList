public class ItemType{

    private int value;


    public static final int GREATER = 1;
    public static final int EQUAL = 0;
    public static final int LESS = -1;

    
    public int compareTo(ItemType item){
	if(this.value > item.value) {
	    return GREATER;
	}
	else if (this.value < item.value){
	    return LESS;
	}
	else {
	    return EQUAL;
	}

    }


    public int getValue(){
	return this.value;
    }


    public void initialize(int num){
	this.value = num;
    }



    
}
