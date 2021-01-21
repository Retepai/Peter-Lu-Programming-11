public class Main {

    static int []add(int x,int n, int y){

        int[] addArr= new int[x+1];// this would create a new array that is one bigger than the original

        addArr[n] = y; // this assigns the value to be added y (50) to the n (10) index position

        return addArr;// this then returns the int array addArr back
    }

    static int[]insert(int x,int in,int y){



        int[] insArr= new int[x+1];// this would create a new array that is one bigger than the original

        insArr[in]=y; // this assigns the value to be inserted y (50) to the the in (a number between 1-9) index position

        return insArr;// this then returns the int array insArr back

    }
    static int[]delete(int x){
        int[] delArr= new int[x-1];// this would create a new array that is one smaller than the original

        return delArr;// this then returns the int array delArr back
    }

    public static void main(String args[]){
        int x= 10;//original size of array
        int y= 50;// number to add/insert
        int n= 10;// index position to add the value

        /* the code below generates a number between 1-9 and assigns it to an integer, the integer indicates
         * the position to insert the value*/
        int in= (int) (Math.random() * 10);
        while (in==0||in==9){
            in= (int) (Math.random() * 10);
        }


        System.out.print("Original Array: ");

        int[] arr= new int[x];//This creates a array and sets its size as x (10)
        for(int i=0; i<arr.length;i++){ /* this for loop will loop through the index positions and print the values
         */

            arr[i]=i;//what ever the index position is the stored value would be the same number
            System.out.print(arr[i]+" ");//this prints the array on a single line

        }

        System.out.println("\n"); // creates space
        System.out.print("Add Array: ");

        int[] addArr= add(x,n,y);// this line of code calls for the add function and gives parameters x, n, y

        for(int i=0;i<addArr.length;i++){
            if(i<n){// if the current index value is smaller than the index that the value is add the code below will execute
                addArr[i]=i;/*The array will follow the original pattern until it evaluates to false*/
            }
            System.out.print(addArr[i]+" ");/* This would print all the values array and since value at n is already assigned as
            y it would print that as well */
        }
        System.out.println("\n");
        System.out.print("Insert Array: ");

        int[] insertArr= insert(x,in,y);// this line of code calls for the insert function and give the parameters x, in, y

        for(int i=0;i<insertArr.length;i++) {
            if(i<in){// This accounts for all the values before the inserted value
                insertArr[i]=i;// before the insert value the the array would follow the original pattern
            } else if(i>in){ // This accounts for all the values after the inserted value
                insertArr[i]=i-1;/* after the inserted value, the assigned value would always be ahead of the index value
                by one.So inorder to fix that, the assigned values have be smaller the the index position by one
                every time so the pattern would be the same as the original after the insert value  */
            }
            System.out.print(insertArr[i]+" ");/* this would print the array along with the assigned insert values at random
             index position between 1-9 each time*/
        }
        System.out.println("\n");
        System.out.print("Delete Array: ");
        int[] deleteArr= delete(x);// this calls for the function delete array and give parameters x
        for(int i=0; i<deleteArr.length;i++){
            deleteArr[i]=i;// This will the same as original except one one shorter
            System.out.print(arr[i]+" ");/*this would print the array one by one on a line. This time the array will
             have one less index position*/

        }
    }
}
