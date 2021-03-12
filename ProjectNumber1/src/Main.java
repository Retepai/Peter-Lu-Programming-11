public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) { //This for loop loops though the index positions of the array

            //This if statement below looks for a, e, i, o or u through out the iterations and if it does detect the code below it will run
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                answer++; // if the if statement turn out to be true then the answer will plus one, cause a vowel was found
            }
        }


        return answer;
    }

    //Code you problem number two here
    static int problemTwo(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {//This for loop loops though the index positions of the array

            /*This if statement below checks 3 character in the array at one and see if it equals to bob, this checks until the second last
            character
             */
            if (i < s.length() - 2 && s.substring(i, i + 3).equals("bob")) {
                answer++;// if bob was detected in the string it will add one to answer
                /*In order to stay within bounds, the last 3 character needs to be checked separately this else if
                below will check the last three character after the index is at the last character.
                 */

            } else if (i > s.length() - 2 && s.substring(s.length() - 3, s.length() - 1).equals("bob")) {
                answer++;// if the last three characters spell out bob then the answer will add one
            }
        }

        return answer;
    }


    //Code your solution to problem number 3 here
    static String problemThree(String s) {

        /* in order to get the longest substring in alphabetical order the s string has to be converted into a number array
         * then compared then get the answer from there*/


        int[] numsys = new int[s.length()]; //this creates a numerical array that is the length of the string s

        for (int i = 0; i < s.length(); i++) {//this creates a for loop that loops through all the index positions of the array
            switch (s.charAt(i)) {// this switch statement assigns a number to every single letter in the string
                case 'a': //when the character at the current index position is equal to 'a' then the corresponding number in the array is going to be one
                    numsys[i] = 1;// this assigns one to the current index position
                    break;//this breaks the switch statement to prevent errors in translating
                case 'b': // b will be converted to 2
                    numsys[i] = 2;
                    break;
                case 'c': // c will be converted to 3
                    numsys[i] = 3;
                    break;
                case 'd':// d will be converted to 4
                    numsys[i] = 4;
                    break;
                case 'e':// e will be converted to 5
                    numsys[i] = 5;
                    break;
                case 'f'://f will be converted to 6
                    numsys[i] = 6;
                    break;
                case 'g'://g will be converted to 7
                    numsys[i] = 7;
                    break;
                case 'h'://h will be converted to 8
                    numsys[i] = 8;
                    break;
                case 'i'://i will be converted to 9
                    numsys[i] = 9;
                    break;
                case 'j'://i will be converted to 10
                    numsys[i] = 10;
                    break;
                case 'k'://k will be converted to 11
                    numsys[i] = 11;
                    break;
                case 'l'://l will be converted to 12
                    numsys[i] = 12;
                    break;
                case 'm'://m will be converted to 13
                    numsys[i] = 13;
                    break;
                case 'n'://n will be converted to 14
                    numsys[i] = 14;
                    break;
                case 'o'://o will be converted to 15
                    numsys[i] = 15;
                    break;
                case 'p'://p will be converted to 16
                    numsys[i] = 16;
                    break;
                case 'q'://q will be converted to 17
                    numsys[i] = 17;
                    break;
                case 'r'://r will be converted to 18
                    numsys[i] = 18;
                    break;
                case 's'://s will be converted to 19
                    numsys[i] = 19;
                    break;
                case 't'://t will be converted to 20
                    numsys[i] = 20;
                    break;
                case 'u'://u will be converted to 21
                    numsys[i] = 21;
                    break;
                case 'v'://v will be converted to 22
                    numsys[i] = 22;
                    break;
                case 'w'://w will be converted to 23
                    numsys[i] = 23;
                    break;
                case 'x'://x will be converted to 24
                    numsys[i] = 24;
                    break;
                case 'y'://y will be converted to 25
                    numsys[i] = 25;
                    break;
                case 'z'://z will be converted to 26
                    numsys[i] = 26;
                    break;
            }
        }

        String tempstring=""; // this creates a string that the answer is going to be stored into
        int fin = 0;// This stores the length of the longest string in alphabetical order
        int temp = 0;//This stores the current length of the string in alphabetical order

        for (int j = 0; j < s.length(); j++) {// this for loop, loops through all the index position of the number array we created earlier
            //When the program loops through the index positions, it checks the number in front and behind it.
            if (j == 0) { /*if j was 0 and the system does j-1 to check the number in front a index out of bounds error would appear, so in this
                case the if j equals to 0 the program will not proceed to check anything. Instead it will just increase temp by one no matter what the letter is */
                temp++; // adds one to temp

            } else {// once the j is past the first index position the checking will begin (since now there is a number at the front to check)

                if (j == s.length() - 1 ) { //this if statement check if the current index position is the last index position, if true the following block of code will execute
                    if(numsys[j - 1] < numsys[j]) { //this nested if statement check if last number in the array is bigger than the previous
                        temp++;//if the previous number is bigger than the previous the current length of the string in alphabetical order will increase
                        if (temp > fin) {// if the current length of the array is bigger than the longest string in alphabetical order then the following code wil execute
                            fin = temp;// the longest string in alphabetical order will be replaced with the current length of the longest array
                            tempstring = s.substring(j - fin + 1, j + 1); // this code creates locates the longest string in alphabetical order and stores it
                            break;//this is the end the so code will break since there is nothing else to check
                        }
                    }

                }else if(numsys[j-1]>numsys[j]&&temp>fin){/*this check at the start if the number in front is greater than the number on the current index position and if the current length of the string in alphabet
                is longer than the previously longest string in alphabetical order*/
                    //if the else if statement evaluates to true then the the length if the string longest string in alphabetical order will temporarily be one
                    fin=1;
                    tempstring=s.substring(j-fin,j);// this will store the current longest string in alphabetical order which is currently one letter
                }else if(numsys[j-1]>numsys[j]){/* this check at the start if the number in front is greater than the number on the current index position but the current length of the string in alphabet
                    is shorter than the previously longest string in alphabetical order*/
                    temp=1; // this resets the length of the current string in alphabetical order because it is not longer than the current longest string in alphabetical order
                } else if (numsys[j] > numsys[j + 1]) {// if the number on the current index position is smaller than the number on the next index position the following code will execute
                    temp++;
                    if (temp > fin) { // if the current string is longer than the current longest string alphabetical order then teh following code will run
                        fin = temp;// the longest string in alphabetical order now get updated

                        if(fin == 1) { // if the longest string in alphabetical order's length is one then the code below will run
                            tempstring = s.substring(j - fin, j); // the finding the substring for one letter is a bit different from printing multiple so I have to separate them
                            temp = 0;// this resets the temporary
                        }else{// if the longest string in alphabetical order's length is not one (meaning that it is greater than one) then the code below will run
                            tempstring = s.substring(j - fin+1, j + 1);
                            temp = 0;
                        }
                    }
                } else if (numsys[j-1] <= numsys[j]) { // if the number in the current index position is smaller or equal to the number on the next index position then the length of the strings in alphabetical will increase by one
                    temp++;
                }
            }
        }
        s= tempstring; // this assigns the the final substring with the longest string in alphabetical order to s.
        return s;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */

    }
}
