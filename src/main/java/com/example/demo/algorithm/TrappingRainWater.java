package com.example.demo.algorithm;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 14:40
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入： height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater tr = new TrappingRainWater();
        System.out.println(tr.trap(height));
    }


    public int trap(int[] height) {

        if (null == height || height.length == 0) {
            return 0;
        }

        // 存放雨水总量
        int total = 0;
        int size = height.length;

        // 存放每一个元素的左最大高度
        int[] leftMax = new int[size];
        // 左边第一个元素的左最大高度肯定等于自身高度
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            // 每一个元素的左最大高度等于前一元素的左最大高度与当前元素的高度最大值
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // 存放每一个元素的右最大高度
        int[] rightMax = new int[size];
        // 右边第一个元素的右最大高度肯定等于自身高度
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            // 每一个元素的右最大高度等于前一元素的右最大高度与当前元素的高度最大值
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            // 计算每一个元素的接水量
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;
    }



}
