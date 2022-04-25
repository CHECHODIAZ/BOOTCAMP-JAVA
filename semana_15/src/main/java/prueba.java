public class prueba {
	
	
	
	
	
	public static void fizzBuzz(int n) {
        
        	 
        	int[] listmtres = new int[n];
        	int[] listmcinco = new int[n];
        	
        	for(int j=0 ; j<n ; j++){
        		listmtres[j] = 3*j;
 
        		
        			
        	}
        	for(int k=0 ; k<n ; k++){
        		listmcinco[k] = 5*k;
        			
        	}
        	
        	for(int i=1 ; i<n ; i++){
        		
        		for(int m=1 ; m<n ; m++) {
        			if(listmtres[m]==i || listmcinco[m] == i) {
        			  for(int z=1 ; z<n ; z++) {	
        				if(listmtres[m] == listmcinco[z]) {
        					System.out.println("fizzBuzz");
        			     }
        			   } 	 
        		    }	
        				
        	     }
	         }      
       
	}

	public static void main(String[] args) {


	}

}
