import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestProject {


    public static void prepareTest(int[] arr) {
        String inputStr = Arrays.toString(arr);
        inputStr = "{"+inputStr.substring(1, inputStr.length()-1)+"}";
        System.out.println("Input: "+inputStr);
    }

    public static void runTestForStage1(int[] arr, List<String> expectedStrList)
            throws Exception{
        prepareTest(arr);
        List<String> strList = DigitsLetterMapping.getOneDigitArrayToString(arr);
        System.out.println(strList);
        assertEquals(expectedStrList, strList);
        System.out.println("This test case is passed.");
    }

    public static void runTestForStage2(int[] arr, List<String> expectedStrList)
            throws Exception{
        prepareTest(arr);
        List<String> strList = DigitsLetterMapping.getTwoDigitArrayToString(arr);
        System.out.println(strList);
        assertEquals(expectedStrList, strList);
        System.out.println("This test case is passed.");
    }


    public static void testForStage1()
            throws Exception{
        System.out.println("Run test for stage1:");

        int[] arr = {2,3};
        List<String> expectedStrList = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{9};
        expectedStrList = Arrays.asList("w", "x", "y", "z");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{};
        expectedStrList = Arrays.asList("");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{0};
        expectedStrList = Arrays.asList("");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{1};
        expectedStrList = Arrays.asList("");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{2,0,3};
        expectedStrList = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{2,1,3};
        expectedStrList = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        runTestForStage1(arr, expectedStrList);

        arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        expectedStrList = DigitsLetterMapping.getOneDigitArrayToString(arr);
        runTestForStage1(arr, expectedStrList);
        //Test big input data

        System.out.println("Test for stage1 finished.\n");

    }

    public static void testForStage2()
            throws Exception{
        System.out.println("Run test for stage1:");

        int[] arr = {0,1,23,0,1};
        List<String> expectedStrList = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        runTestForStage2(arr, expectedStrList);

        arr = new int[]{9};
        expectedStrList = Arrays.asList("w", "x", "y", "z");
        runTestForStage2(arr, expectedStrList);

        arr = new int[]{12,34,56,78,9,0};
        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,0};
        expectedStrList = DigitsLetterMapping.getOneDigitArrayToString(arr1);
        runTestForStage2(arr, expectedStrList);

        arr = new int[]{0,1,27,89,0};
        int[] arr2 = new int[]{0,1,2,7,8,9,0};
        expectedStrList = DigitsLetterMapping.getOneDigitArrayToString(arr2);
        runTestForStage2(arr, expectedStrList);

        System.out.println("Test for stage2 finished.\n");
    }


    public static void main(String[] args)
            throws Exception{
        testForStage1();
        testForStage2();
    }
}
