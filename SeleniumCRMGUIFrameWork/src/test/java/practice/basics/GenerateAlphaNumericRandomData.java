package practice.basics;

public class GenerateAlphaNumericRandomData {
	public static void main(String[] args) {
		int n=6;//upperlimit
		//choose a Character random from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create StringBuilder size of AlphaNumericString
		//StringBuilder sb=new StringBuilder(n);//faster compare to String buffer
		StringBuffer sb=new StringBuffer(n);
		
		for(int i=0;i<n;i++) {
			//generate a random number between 0 to Alphanumeric String variable length
			int index=(int)(AlphaNumericString.length()*Math.random());
			
			//add Character one by one in end of StringBuffer
			sb.append(AlphaNumericString.charAt(index));
			
	}
		System.out.println(sb);
}
}
