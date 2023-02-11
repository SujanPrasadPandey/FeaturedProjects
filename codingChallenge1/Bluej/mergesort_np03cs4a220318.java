import java.util.Scanner;
import java.util.Arrays;

class mergesort_np03cs4a220318{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter the number of elements in array: ");
        int n=in.nextInt();
        
        int[] array=new int[n];
        
        int i;
        
        System.out.println("Enter the elements of array: ");
        for(i=0;i<n;i++){
            int x=in.nextInt();
            array[i]=x;
        }
        
        System.out.printf("%nThe given array is: ");
        for(i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        
        mergeSort(array);
        
        System.out.printf("%nThe sorted array is: ");
        for(i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    
    public static void mergeSort(int[] array){
        if(array==null){
            return;
        }
        
        if(array.length>1){
            int mid=array.length/2;
            
            int[] left=new int[mid];
            for(int i=0;i<mid;i++){
                left[i]=array[i];
            }
            
            int[] right=new int[array.length-mid];
            for(int i=mid;i<array.length;i++){
                right[i-mid]=array[i];
            }
            
            mergeSort(left);
            mergeSort(right);
            
            int i=0,j=0,k=0;
            
            while(i<left.length && j<right.length){
                if(left[i]<right[j]){
                    array[k]=left[i];
                    i++;
                }else{
                    array[k]=right[j];
                    j++;
                }
                k++;
            }
            
            while(i<left.length){
                array[k]=left[i];
                i++;
                k++;
            }
            
            while(j<right.length){
                array[k]=right[j];
                j++;
                k++;
            }
        }
    }
}