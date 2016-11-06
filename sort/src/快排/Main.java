package ¿ìÅÅ;

public class Main {

	public static void quickSort(int [] a,int left,int right){
		if(left>=right) return;
		int key = a[left];
		int i = left;
		int j = right;
		while(i<j){
			while(a[j]>=key&&i<j) j--;
			a[i]=a[j];
			while(a[i]<key&&i<j) i++;
			a[j]=a[i];
		}
		a[i]=key;
		quickSort(a, left, i-1);
		quickSort(a, i+1, right);
		
	}
	public static void merge(int [] a,int start1,int start2,int end){
		int [] temp = new int[end-start1];
		int i = start1;
		int j = start2;
		int k = 0;
		while(i<start2&&j<end){
			if(a[i]<a[j]){
				temp[k]=a[i];
				k++;
				i++;
			}else{
				temp[k]=a[j];
				k++;
				j++;
			}
		}
		while(i<start2){
			temp[k]=a[i];
			k++;
			i++;
		}
		while(j<end){
			temp[k]=a[j];
			k++;
			j++;
		}
		for(i=0;i<temp.length;i++){
			a[i+start1]=temp[i];
		}
	}
	public static void mergeSort(int [] a,int start,int end){
		if(start+1<end){
			int mid = (start+end)/2;
//			System.err.println(start+" "+mid+" "+end);
			mergeSort(a, start, mid);
			mergeSort(a, mid, end);
			merge(a, start, mid, end);
		}
	}
	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,1,22,33,213,4,2341,342134,55,341,2231,32,67867,990,987};
		quickSort(a,0, a.length-1);
		//mergeSort(a, 0, a.length);
		System.out.println(a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		int [] b = {1,2,3,4,5,1,22,33,213,4,2341,342134,55,341,2231,32,67867,990,987};
		mergeSort(b, 0, b.length);
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
	}

}
