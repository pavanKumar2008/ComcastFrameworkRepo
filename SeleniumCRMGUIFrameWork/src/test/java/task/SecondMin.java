package task;

public class SecondMin {
public static void main(String[] args) {
	int a[]= {10,5,60,78,97,11,1,7,2,47};
	int min=a[0];
	int smin=a[0];
	for(int i=1;i<a.length-1;i++) {
		if(min>a[i]&&smin<a[i]) {
	
			smin=min;
			min=a[i];
		}
	}
	System.out.println(min);
	System.out.println(smin);
}
}
