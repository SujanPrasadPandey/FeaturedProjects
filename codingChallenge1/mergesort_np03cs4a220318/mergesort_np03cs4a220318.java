import java.util.*;
public class MergeSort {
    
        ArrayList getInput(ArrayList<Integer> al) {
        System.out.println("Enter the number of inputs:");
        Scanner in= new Scanner(System.in);
        int n= in.nextInt();
        for(int i=0;i<n;i++){
            int b= in.nextInt();
            al.add(b);
          }
          System.out.println("The unsorted ArrayList=");
          System.out.println(al);
          return al;
          }
    
    void getOutput(ArrayList<Integer> al) {
        System.out.println("The sorted ArrayList="+al);
    }
    
    
    
    void merge(ArrayList<Integer> al, int beg, int mid, int end) {
        List <Integer> alm= new ArrayList <Integer>();
        int x=0;
            int index1=beg;
            int index2=mid+1;
            while(index1<=mid && index2<=end){
                if(al.get(index1)<=al.get(index2)){
                    alm.add(al.get(index1));
                    index1++;
               }else {
                   alm.add(al.get(index2));
                   index2++;
            }
         }
         while(index1<= mid){
             alm.add(al.get(index1));
             index1++;
         }
         while(index2<=end){
             alm.add(al.get(index2));
             index2++;
         }
        
         for(int i=0;i<alm.size();beg++){
             al.set(beg, alm.get(i++));
         }
    }
    
    void sort(ArrayList<Integer> al, int beg, int end) {
        
        if(beg>=end){
            return;
  }
        int mid=beg+(end-beg)/2;
        sort(al, beg, mid);
            sort(al, mid+1, end);
            merge(al, beg, mid, end);
       }
    
    
    public static void main(String[] args) {
            MergeSort l =new MergeSort();
            System.out.println("\u000C");
            ArrayList<Integer> al= new ArrayList<Integer>();
        l.getInput(al);
        l.sort(al,0,al.size()-1);
        l.getOutput(al);
    }

}