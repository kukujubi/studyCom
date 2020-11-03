package com.nowcoder.community.exam;
import java.util.*;
public class tengxun02 {
    public static class Element{
        String str;
        int count;
        public Element(String str,int count){
            this.str=str;
            this.count=count;
        }
    }
    public static class Acomp implements Comparator<Element>{//congdadaoxiao
        public int compare(Element e1,Element e2){
            if (e1.count<e2.count){
                return 1;
            }
            else if (e1.count>e2.count){
                return -1;
            }
            else {
                int index = 0;
                String s1 = e1.str;
                String s2=e2.str;
                while (index < s1.length() && index < s2.length()) {
                    char c1 = s1.charAt(index);
                    char c2 = s2.charAt(index);
                    if (c1 - '0' < c2 - '0') {
                        return -1;
                    } else if (c1 - '0' > c2 - '0') {
                        return 1;
                    } else {
                        index++;
                    }
                }
                while (index < s1.length()) {
                    return 1;
                }
                while (index < s2.length()) {
                    return -1;
                }
            }
            return 0;
        }
    }
    public static class Bcomp implements Comparator<Element>{
        public int compare(Element e1,Element e2){
            if (e1.count<e2.count){
                return -1;
            }
            else if (e1.count>e2.count){
                return 1;
            }
            else {
                int index = 0;
                String s1 = e1.str;
                String s2=e2.str;
                while (index < s1.length() && index < s2.length()) {
                    char c1 = s1.charAt(index);
                    char c2 = s2.charAt(index);
                    if (c1 - '0' < c2 - '0') {
                        return -1;
                    } else if (c1 - '0' > c2 - '0') {
                        return 1;
                    } else {
                        index++;
                    }
                }
                while (index < s1.length()) {
                    return 1;
                }
                while (index < s2.length()) {
                    return -1;
                }
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k= in.nextInt();
        ArrayList<Element> list = new ArrayList<>();
        int count=0;
        HashMap<String,Integer> map=new HashMap<>();
        String cur = in.nextLine();
        while(count<n){
            cur = in.nextLine();

            if(!map.containsKey(cur)){

                map.put(cur,1);
            }
            else{
                map.put(cur,map.get(cur)+1);
            }

            count++;
        }
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            Element element  =new Element(entry.getKey(),entry.getValue());
            list.add(element);
        }
        ArrayList<Element> list1 = new ArrayList<>(list);
        Collections.sort(list,new Acomp());
        //System.out.println();
        for(int i=0;i<k;i++){

            System.out.print(list.get(i).str+" ");
            System.out.println(list.get(i).count);
        }
        Collections.sort(list1,new Bcomp());
        for(int i=0;i<k;i++){
            System.out.print(list1.get(i).str+" ");
            System.out.println(list1.get(i).count);
        }

    }
}

