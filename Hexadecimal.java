/* Henry Zhang
Team Pray4Vincent
Members:
Henry Zhang, Henry Zhang
;APCS1 pd5
;HW #44: This or That or Fourteen Other Things
;2015-12-9
*/

//skeleton file for class Binary


public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF"; 


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Hexadecimal() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum=0;
	_hexNum="0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum=n;
	_hexNum=decToHex(n);//calling method to convert to binary form
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum=hexToDec(s);//calling method to convert to decimal form
	_hexNum=s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	return this._hexNum;
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
    public static String decToHex( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	String hexOut="";
	//output
	while (n>0){
	    int rem=n%16;//remainder when divided by 2, will always be 1 or 0
	    String dig=HEXDIGITS.substring(rem,rem+1);
	    hexOut=dig+hexOut;//going upwards on the division tower to reflect the greatest power of 2 divisible by n to the 0th power of 2
	    n/=16;
	    //n is divided for the next power of 2
	}
	return hexOut;
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
     public static String decToHexR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	 if (n==0){
	     return "0";
	 }
	 return decToHexR(n/16)+""+HEXDIGITS.substring(n%16,n%16+1);//building from right to left with the same algorithm from above
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
    public static int hexToDec( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	int dec=0;
	//output
	for(int i=0;i<s.length();i++){
	    dec+=HEXDIGITS.indexOf(s.substring(i,i+1))*(Math.pow(16,s.length()-i-1));//for each place of s, determine the power of s and multiply by the value there to get the value of that place in decimal form
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
    public static int hexToDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	if (s.length()==0){
	    return 0;
	}
	return hexToDecR(s.substring(1))+HEXDIGITS.indexOf(s.substring(0,1))*(int)Math.pow(16,(s.length()-1));//same as above, use length to tell which place we are on and work from right to left to reflect upwards on the division tree
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	return ((this._decNum==((Hexadecimal)other)._decNum)||(((Hexadecimal)other)==this));//typecast to Binary to be able to compare instance vars 
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
	if (this._decNum>((Hexadecimal)other)._decNum){
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

	Hexadecimal b1 = new Hexadecimal(5);
	Hexadecimal b2 = new Hexadecimal(5);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(15);

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
