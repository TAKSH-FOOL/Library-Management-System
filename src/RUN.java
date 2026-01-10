class RUN {
   static boolean sortArray (int [] a, int i){
       if(i == a.length-1){
        return true;
       }
       if(a[i] < a[i+1]){
        return true;
       }
       return false;
    }
    public static void main(String[] args) {
        int [] a = {1,2,3,7,5};
        System.out.println(RUN.sortArray(a,0));
    }

}
