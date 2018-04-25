package com.thoughtworks;

import java.util.*;
import java.util.stream.Collectors;


public class FizzBuzzGame {
    private List<String> results = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int[] specialNum = new int[3];

    public static void main(String[] args){
        new FizzBuzzGame().run();
    }
    public void run(){
        setThreeSpecialNumber();
        int count = sc.nextInt();
        start(count);
        System.out.println(getResults().toString());
    }

    /**
     * 体育老师说出3个不同的个位数
     */
    private void setThreeSpecialNumber(){
        Set<Integer> set = new HashSet<>();
        int i=0;
        while(i<3){
            int num = sc.nextInt();
            if(num>0&&num<10){
                set.add(num);
                i = set.size();
            }
        }
        specialNum = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return ;
    }

    /**
     * 通过数组对体育老师说出的3个不同的数进行赋值
     * @param arr
     */
    public void setThreeSpecialNumber(int[] arr){
        specialNum = arr;
    }

    /**
     * 根据输入的count,构造results
     * @param count
     */
    public void start(int count) {
        for (int i = 1; i < count; i++) {
            String result="";
            if(containsSpecialNum1(i)){
                result+="Fizz";
            }else if(isSpecialNum1Times(i)||isSpecialNum2Times(i)||isSpecialNum3Times(i)){
                if(isSpecialNum1Times(i)){
                    result+="Fizz";
                }
                if(isSpecialNum2Times(i)){
                    result+="Buzz";
                }
                if(isSpecialNum3Times(i)){
                    result+="Whizz";
                }
            }else{
                result+=i;
            }
            results.add(result);
        }
    }

    /**
     * 判断是否包含第一个特殊数
     * @param num
     * @return
     */
    public boolean containsSpecialNum1(int num){
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        for(char c:arr){
            if(c-'0' == specialNum[0]){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是第一个特殊数的倍数
     * @param num
     * @return
     */
    public boolean isSpecialNum1Times(int num){
        if(num%specialNum[0]==0)
            return true;
        return false;
    }

    /**
     * 判断是否是第二个特殊数的倍数
     * @param num
     * @return
     */
    public boolean isSpecialNum2Times(int num){
        if(num%specialNum[1]==0)
            return true;
        return false;
    }

    /**
     * 判断是否是第三个特殊数的倍数
     * @param num
     * @return
     */
    public boolean isSpecialNum3Times(int num){
        if(num%specialNum[2]==0)
            return true;
        return false;
    }
    public List<String> getResults() {
        return results;
    }
}


