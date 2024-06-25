package task;

public class FirstMax {
public static void main(String[] args) {
	int a[]= {10,5,60,78,97,11,01,7,2,47};
	int max=a[0];
	for(int i=0;i<a.length;i++) {
	if(max<a[i]) {
		max=a[i];
	}
	}
	System.out.println(max);
}
}
