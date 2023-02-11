import java.util.Scanner;
import java.util.ArrayList;

class re{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n=in.nextInt();
    
        ArrayList<Integer> array = new ArrayList<Integer>();
    
        int i;
    
        System.out.println("Enter the elements of array: ");
        for(i=0;i<n;i++){
            int x=in.nextInt();
            array.add(x);
        }
    
        System.out.printf("%nThe given array is: ");
        for(i=0;i<array.size();i++){
            System.out.print(array.get(i)+" ");
        }
    
        mergeSort(array);
    
        System.out.printf("%nThe sorted array is: ");
        for(i=0;i<array.size();i++){
            System.out.print(array.get(i)+" ");
        }
    }

    public static void mergeSort(ArrayList<Integer> array){
        if(array==null){
            return;
        }
        
        if(array.size()>1){
            int mid=array.size()/2;
            
            ArrayList<Integer> left = new ArrayList<Integer>();
            for(int i=0;i<mid;i++){
                left.add(array.get(i));
            }
            
            ArrayList<Integer> right = new ArrayList<Integer>();
            for(int i=mid;i<array.size();i++){
                right.add(array.get(i));
            }
            
            mergeSort(left);
            mergeSort(right);
            
            int i=0,j=0,k=0;
            
            while(i<left.size() && j<right.size()){
                if(left.get(i)<right.get(j)){
                    array.set(k, left.get(i));
                    i++;
                }else{
                    array.set(k, right.get(j));
                    j++;
                }
                k++;
            }
            
            while(i<left.size()){
                array.set(k, left.get(i));
                i++;
                k++;
            }
            
            while(j<right.size()){
                array.set(k, right.get(j));
                j++;
                k++;
            }
        }
    }
}