package com.nowcoder.community.exam;

public class Huawei03 {
    public static void main(String[] args){
        int[] arr=new int[]{1,2,6,4,5,5,1,1};
        int l=0;
        int r=arr.length-1;
        quickSort(arr,l,r);
        int index=0;
        while(index<=r){
            System.out.println(arr[index++]);
        }


    }
    public static void quickSort(int[] arr,int l,int r){
        if (l>=r)
            return;
        /*int random=l+(int)Math.random()*(r-l+1);
        swap(arr,random,r);*/
        int[] p=partition(arr,l,r);
        quickSort(arr,l,p[0]-1);
        quickSort(arr,p[1]+1,r);
    }
    public static void swap(int[] arr,int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    public static int[] partition(int[] arr,int l,int r){
        int less=l-1;
        int more=r;
        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }
            else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }
            else
                l++;
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

}
