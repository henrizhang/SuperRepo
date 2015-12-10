/* Henry Zhang
;APCS1 pd5
;HW #43: This or That
;2015-12-8
*/

//skeleton file for class Binary

public class Binary {

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum=0;
	_binNum="0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum=n;
	_binNum=decToBin(n);//calling method to convert to binary form
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum=binToDec(s);//calling method to convert to decimal form
	_binNum=s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	return this._binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	String binOut="";
	//output
	while (n>0){
	    int rem=n%2;//remainder when divided by 2, will always be 1 or 0 
	    binOut=rem+binOut;//going upwards on the division tower to reflect the greatest power of 2 divisible by n to the 0th power of 2
	    n/=2;
	    //n is divided for the next power of 2
	}
	return binOut;
    }

    
    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
     public static String decToBinR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	 if (n==0){
	     return "0";
	 }
	 return decToBinR(n/2)+""+n%2;//building from right to left with the same algorithm from above
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	int dec=0;
	//output
	for(int i=0;i<s.length();i++){
	    dec+=Integer.parseInt(s.substring(i,i+1))*(Math.pow(2,s.length()-i-1));//for each place of s, determine the power of s and multiply by the value there to get the value of that place in decimal form
	}
	return dec;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	if (s.length()==0){
	    return 0;
	}
	return binToDecR(s.substring(1))+Integer.parseInt(s.substring(0,1))*(int)Math.pow(2,(s.length()-1));//same as above, use length to tell which place we are on and work from right to left to reflect upwards on the division tree
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	return ((this._decNum==((Binary)other)._decNum)||(((Binary)other)==this));//typecast to Binary to be able to compare instance vars 
       }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	if (this.equals(other)){
	    //calling above method
	    return 0;
	}
	if (this._decNum>((Binary)other)._decNum){
	    //typecast to Binary to be able to compare instance vars 
	    return (1);
	}
	else{
	    //only possible case then
	    return -1;
	}
    }


    //main method for testing
    public static void main( String[] args ) {
	
	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
        
    }//end main()

} //end class
