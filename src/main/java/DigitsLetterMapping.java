import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DigitsLetterMapping {

    static public void init(Map<Integer, String> digToCh) {
        digToCh.clear();
        digToCh.put(0, "");
        digToCh.put(1, "");
        digToCh.put(2, "abc");
        digToCh.put(3, "def");
        digToCh.put(4, "ghi");
        digToCh.put(5, "jkl");
        digToCh.put(6, "mno");
        digToCh.put(7, "pqrs");
        digToCh.put(8, "tuv");
        digToCh.put(9, "wxyz");
    }

    static public List<String> getOneDigitArrayToString(int[] digArr)
            throws Exception{
        LinkedList<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder(digArr.length);
        HashMap<Integer, Integer> posMap = new HashMap<>();
        //map the digit array index to letter string index to handle special cases of digits of 0 and 1

        for (int i = 0;i<digArr.length;i++) {
            if (digArr[i]<0 || digArr[i]>9) {
                throw new Exception("Input error! At least one of the input digits is out of range.");
            } else if (digArr[i] > 1){
                posMap.put(i, sb.length());
                sb.append(" ");
            }
        }

        Map<Integer, String> digLetMap = new HashMap<>();
        init(digLetMap);

        //the following code block is a non-recursive dfs, since the length of the input array is unknown
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int ind = 0;
        while (!st.empty()) {
            if (ind>=digArr.length) {
                result.add(sb.toString());
                ind--;
                st.pop();
            } else {
                int now = st.peek();
                if ((digLetMap.get(digArr[ind]).length() == 0 && now == 0) ||
                        (digLetMap.get(digArr[ind]).length() > 0 && now < digLetMap.get(digArr[ind]).length())) {
                    if (digLetMap.get(digArr[ind]).length() > 0) {
                        sb.setCharAt(posMap.get(ind), digLetMap.get(digArr[ind]).charAt(now));
                    }
                    st.pop();
                    st.push(now+1);
                    st.push(0);
                    ind++;
                } else {
                    st.pop();
                    ind--;
                }
            }
        }

        return result;
    }

    static public void printOneDigitArrayToString(int[] digArr)
            throws Exception{
        System.out.print("Output: ");
        List<String> result = getOneDigitArrayToString(digArr);
        result.stream().forEach(p->System.out.print(p+" "));
        System.out.println();
    }

    static public List<String> getTwoDigitArrayToString(int[] digArr)
            throws Exception{
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0;i < digArr.length;i++) {
            if (digArr[i]<=9) {
                linkedList.add(digArr[i]);
            }
            else {
                linkedList.add(digArr[i] / 10);
                linkedList.add(digArr[i] % 10);
            }
        }
        int[] newDigArr = new int[linkedList.size()];
        for (int i = 0;i<linkedList.size();i++) {
            newDigArr[i] = linkedList.get(i);
        }
        return getOneDigitArrayToString(newDigArr);
    }

    static public void printTwoDigitArrayToString(int[] digArr)
            throws Exception{
        System.out.print("Output: ");
        List<String> result = getTwoDigitArrayToString(digArr);
        result.stream().forEach(p->System.out.print(p+" "));
        System.out.println();
    }

    public static void testStage1()
            throws Exception{
        int[] arr = {2,3};
        String inputStr = Arrays.toString(arr);
        inputStr = "{"+inputStr.substring(1, inputStr.length()-1)+"}";
        System.out.println("Input: "+inputStr);
        printOneDigitArrayToString(arr);
    }

    public static void testStage2()
            throws Exception{
        int[] arr = {23};
        String inputStr = Arrays.toString(arr);
        inputStr = "{"+inputStr.substring(1, inputStr.length()-1)+"}";
        System.out.println("Input: "+inputStr);
        printTwoDigitArrayToString(arr);
    }

    public static void main(String[] args)
            throws Exception{
        testStage1();
        testStage2();
    }
}
