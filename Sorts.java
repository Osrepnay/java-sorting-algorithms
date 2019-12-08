import java.util.ArrayList;
import java.util.Arrays;
public class Sorts{
	public static double[] quicksort(double[] array){
		if(array.length<=1){
			return array;
		}
		int pivotIndex=0;
		ArrayList<Double> half1=new ArrayList<Double>();
		ArrayList<Double> half2=new ArrayList<Double>();
		int half1Index=0;
		int half2Index=0;
		for(int i=1; i<array.length; i++){
			if(array[i]<=array[pivotIndex]){
				half1.add(array[i]);
			}else{
				half2.add(array[i]);
			}
		}
		double[] half1Sorted=quicksort(listToArray(half1));
		double[] half2Sorted=quicksort(listToArray(half2));
		
		for(int i=0; i<half1.size(); i++){
			half1.set(i, half1Sorted[i]);
		}
		for(int i=0; i<half2.size(); i++){
			half2.set(i, half2Sorted[i]);
		}

		ArrayList<Double> sortedArray=new ArrayList<Double>();
		for(int i=0; i<half1.size(); i++){
			sortedArray.add(half1.get(i));
		}
		sortedArray.add(array[pivotIndex]);
		for(int i=0; i<half2.size(); i++){
			sortedArray.add(half2.get(i));
		}
		return listToArray(sortedArray);
	}
	public static double[] mergesort(double[] array){
		if(array.length<=1){
			return array;
		}
		ArrayList<Double> half1=new ArrayList<Double>();
		ArrayList<Double> half2=new ArrayList<Double>();
		boolean lenOdd=(array.length%2==0) ? false : true;
		for(int i=0; i<(lenOdd ? (array.length-1)/2 : array.length/2); i++){
			half1.add(array[i]);
		}
		for(int i=(lenOdd ? (array.length-1)/2 : array.length/2); i<array.length; i++){
			half2.add(array[i]);
		}
		double[] half1Sorted=mergesort(listToArray(half1));
		double[] half2Sorted=mergesort(listToArray(half2));
		for(int i=0; i<half1Sorted.length; i++){
			half1.set(i, half1Sorted[i]);
		}
		for(int i=0; i<half2Sorted.length; i++){
			half2.set(i, half2Sorted[i]);
		}
		int half1Index=0;
		int half2Index=0;
		ArrayList<Double> sortedArray=new ArrayList<Double>();
		while(true){
			if(half1.get(half1Index)<=half2.get(half2Index)){
				sortedArray.add(half1.get(half1Index));
				half1Index++;
			}else{
				sortedArray.add(half2.get(half2Index));
				half2Index++;
			}
			if(half1Index>=half1.size()){
				for(int i=half2Index; i<half2.size(); i++){
					sortedArray.add(half2.get(i));
				}
				break;
			}else if(half2Index>=half2.size()){
				for(int i=half1Index; i<half1.size(); i++){
					sortedArray.add(half1.get(i));
				}
				break;
			}
		}
		return listToArray(sortedArray);
	}
	public static double[] combsort(double[] array){
		int gap=array.length;
		double decrease=1.3;
		boolean swapped=false;
		do{
			gap=(int)(gap/decrease);
			if(gap<=1){
				gap=1;
			}
			swapped=false;
			for(int i=gap; i<array.length; i++){
				if(array[i-gap]>array[i]){
					array=swap(array, i-gap, i);
					swapped=true;
				}
			}
		}while(swapped);
		return array;
	}
	public static double[] insertionsort(double[] array){
		if(array.length<=1){
			return array;
		}
		ArrayList<Double> sortedArray=new ArrayList<Double>();
		sortedArray.add(array[0]);
		for(int i=1; i<array.length; i++){
			if(sortedArray.get(0)>=array[i]){
				sortedArray.add(0, array[i]);
				continue;
			}else if(sortedArray.get(sortedArray.size()-1)<=array[i]){
				sortedArray.add(array[i]);
				continue;
			}
			for(int j=0; j<sortedArray.size()-1; j++){
				if(sortedArray.get(j)<=array[i]){
					if(sortedArray.get(j+1)>=array[i]){
						sortedArray.add(j+1, array[i]);
						break;
					}
				}
			}
		}
		return listToArray(sortedArray);
	}
	public static double[] selectionsort(double[] array){
		double[] sortedArray=new double[array.length];
		for(int i=array.length-1; i>=0; i--){
			int highestIndex=0;
			for(int j=0; j<i; j++){
				if(array[j]>array[highestIndex]){
					highestIndex=j;
				}
			}
			sortedArray[i]=array[highestIndex];
		}
		return sortedArray;
	}
	public static double[] bubblesort(double[] array){
		boolean swapped=false;
		do{
			swapped=false;
			for(int i=0; i<array.length-1; i++){
				if(array[i]>array[i+1]){
					array=swap(array, i, i+1);
					swapped=true;
				}
			}
		}while(swapped);
		return array;
	}
	private static double[] swap(double[] array, int index1, int index2){
		double index2Num=array[index2];
		array[index2]=array[index1];
		array[index1]=index2Num;
		return array;
	}
	private static double[] listToArray(ArrayList list){
		double[] newArray=new double[list.size()];
		for(int i=0; i<list.size(); i++){
			newArray[i]=(double)list.get(i);
		}
		return newArray;
	}
}
