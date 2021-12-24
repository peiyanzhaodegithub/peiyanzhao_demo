package com.example.demo.algorithm;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/9/15 11:13
 * @Description: TODO
 */
public class KuoHaoHeLi {


    //数字模拟
   /* public static void main(String[] args) {
        int l =0;
        int r = 0;

        boolean re = true;
        String str = "((*))))";

        for (char c:str.toCharArray()
             ) {
            if (c == '('){
                l++;
                r++;
            }else if (c == ')'){
                l--;
                r--;
            }else {
                l--;
                r++;
            }

            l = Math.max(0,l);

            if (l > r){
                re = false;
                break;
            }

        }
        if (!re){
            System.out.println(re);
        }else if (l == 0){
            System.out.println(re);
        }


    }*/


    //解2：双向扫描
    public static void main(String[] args) {
        String s = "(*()))";
        int l = 0, r = 0, n = s.length();
        boolean a = true;
        for (int i = 0; i < n; i++) {
            l += s.charAt(i) == ')' ? -1 : 1;
            r += s.charAt(n - i - 1) == '(' ? -1 : 1;
            if (l < 0 || r < 0) {
                a = false;
            }
        }
        if (!a){
            System.out.println(a);
        }else {
            System.out.println(a);
        }



    }





}
