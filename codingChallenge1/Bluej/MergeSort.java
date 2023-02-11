import java.util.Scanner;
import java.util.ArrayList;

class MergeSort {
    ArrayList<Integer> array;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n = in.nextInt();
    
        MergeSort ms = new MergeSort();
        ms.array = new ArrayList<Integer>();
    
        int i;
    
        System.out.println("Enter the elements of array: ");
        for(i=0;i<n;i++){
            int x = in.nextInt();
            ms.array.add(x);
        }
    
        System.out.printf("%nThe given array is: ");
        for(i=0;i<ms.array.size();i++){
            System.out.print(ms.array.get(i)+" ");
        }
    
        ms.mergeSort();
    
        System.out.printf("%nThe sorted array is: ");
        for(i=0;i<ms.array.size();i++){
            System.out.print(ms.array.get(i)+" ");
        }
    }

    public void mergeSort(){
        if(this.array==null){
            return;
        }
        
        if(this.array.size()>1){
            int mid=this.array.size()/2;
            
            ArrayList<Integer> left = new ArrayList<Integer>();
            for(int i=0;i<mid;i++){
                left.add(this.array.get(i));
            }
            
            ArrayList<Integer> right = new ArrayList<Integer>();
            for(int i=mid;i<this.array.size();i++){
                right.add(this.array.get(i));
            }
            
            mergeSort(left);
            mergeSort(right);
            
            int i=0,j=0,k=0;
            
            while(i<left.size() && j<right.size()){
                if(left.get(i)<right.get(j)){
                    this.array.set(k, left.get(i));
                    i++;
                }else{
                    this.array.set(k, right.get(j));
                    j++;
                }
                k++;
            }
            
            while(i<left.size()){
                this.array.set(k, left.get(i));
                i++;
                k++;
            }
            
            while(j<right.size()){
                this.array.set(k, right.get(j));
                j++;
                k++;
            }
        }
    }
}
