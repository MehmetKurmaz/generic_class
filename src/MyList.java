public class MyList <T>{
   private int capacity=10;
   private T[] listName=(T[])new Object[10];
public MyList(){
   T[] listName = (T[]) new Object[10];
}
public MyList(int capacity) {
   this.capacity=capacity;
   this.listName=(T[])new Object[capacity];
}
   public int size(){
      int number=0;
      for (int i = 0; i < listName.length ; i++) {
         if(listName[i]!=null){
            number++;
         }

      }
      return number;

   }
   public int getCapacity(){
      return this.capacity;
   }
   public void add(T data){

      if(this.size()==this.getCapacity())
      {
         this.capacity=capacity*2;
         T [] newListName= (T[]) new Object[capacity];
         for (int i = 0; i < listName.length ; i++) {
            newListName[i]=listName[i];
         }
         newListName[(listName.length)]=data;
         this.listName=newListName;

      }
      else{
         listName[this.size()]=data;

      }
   }

   public T get(int index){
      return this.listName[index];
   }
   public T remove(int index){

      this.listName[index]=null;
      T removed=this.listName[index];
      if(index>this.getCapacity()&&index<0){
         return null;
      }
      for (int i = index; i <this.size() ; i++) {
         this.listName[i+1]=this.listName[i];
         this.listName[i]=removed;

      }
      return removed;

   }
   public T set(int index,T data){
      this.listName[index]=data;
      T set =this.listName[index];
      return set;

   }
   @Override
   public String toString(){
      String str="";
      for (int i = 0; i <this.listName.length ; i++) {
         if(listName[i]!=null){

            str=str+this.listName[i]+"-";
         }

      }
      return str;
   }
   public int indexOf(T data){
      for (int i = 0; i <this.listName.length ; i++) {
         if(listName[i]==data){
            return i;
         }
      }
      return -1;
   }
   public int lastIndexOf(T data){
      for (int i = this.listName.length-1; i>=0; i--) {
         if(listName[i]==data){
            return i;

         }
      }
      return -1;
   }
   public boolean isEmpty(){
      int number =0;
      for (int i = 0; i < listName.length ; i++) {
         if(listName[i]==null){
            number++;
         }

      }if(number==listName.length){
         return true;
      }

      else{
         return false;
      }
   }
   public T []toArray(){
      T [] newlist= (T[]) new Object[getCapacity()];
      for (int i = 0; i <this.listName.length ; i++) {
         newlist[i]=this.listName[i];
      }
      return newlist;
   }
   public void clear(){
      for (int i = 0; i <this.listName.length ; i++) {
         this.listName[i]=null;
      }
   }
   public MyList <T> sublist(int start,int finish){
      int size=finish+1-start;
      MyList <T> myNewList =new MyList<>(size);
      int j=0;
      for (int i = start; i <=finish ; i++) {
         myNewList.add(listName[i]);
      }
      return myNewList;
   }
   public boolean contains(T data){
      if(lastIndexOf(data)!=-1&&indexOf(data)!=-1){

         return true;
      }
      else{
         return false;
      }
   }

}
