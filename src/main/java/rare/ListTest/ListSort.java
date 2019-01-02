package rare.ListTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {

        TestBasicParams testBasicParams = new TestBasicParams();
        List<BasicNameValuePair> list1 = testBasicParams.newEntry();

        System.out.println(list1);

        System.out.println("---------------------------------");
        LinkedList<String> linkedList = new LinkedList<>();
        for (BasicNameValuePair str : list1) {
            System.out.println(str.getName());

            System.out.println(linkedList.add(str.getName()));
        }

        System.out.println(linkedList);
        System.out.println("------------------555555---------------");

        System.out.println(getSignByList(list1, "abdjcjjdj"));

        //System.out.println(genPackageSign(list1, linkedList, "abdjcjjdj"));

       /* List<String> list = new LinkedList<>();
        list.add("dobb");
        list.add("age");
        list.add("name");
        list.add("hobb");
        list.add("rare");

        System.out.println(list);
        String signByList = getSignByList(list);
        System.out.println(signByList);*/
    }

    public static String getSignByList(List<BasicNameValuePair> list, String apiKey) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (BasicNameValuePair str : list) {
            linkedList.add(str.getName());
            System.out.println(linkedList.add(str.getName()));
        }
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        linkedList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String strKey: linkedList) {
            for (BasicNameValuePair keyStr : list) {
                if (strKey.equals(keyStr.getName())) {
                    sb.append(keyStr.getName());
                    sb.append('=');
                    sb.append(keyStr.getValue());
                    sb.append('&');
                }
            }
        }

        sb.append("key=");
        sb.append(apiKey);
        System.out.println("sing - "+sb.toString());
        return  sb.toString();
    }

    /**
     *
     * @param params
     * @param apiKey
     * @return
     */
    /*private static String genPackageSign(List<BasicNameValuePair> params, LinkedList<String> list,String apiKey) {
        StringBuilder sb = new StringBuilder();
        for (String strKey: list) {
            for (BasicNameValuePair keyStr : params) {
                if (strKey.equals(keyStr.getName())) {
                    sb.append(keyStr.getName());
                    sb.append('=');
                    sb.append(keyStr.getValue());
                    sb.append('&');
                }
            }
        }

        *//*for (int i = 0; i < params.size(); i++) {
            sb.append(params.get(i).getName());
            sb.append('=');
            sb.append(params.get(i).getValue());
            sb.append('&');
        }*//*
        sb.append("key=");
        sb.append(apiKey);
        System.out.println("sing - "+sb.toString());
        //String packageSign = MD5Util.MD5Encode(sb.toString(),"utf-8").toUpperCase();
        return sb.toString();
    }*/
}
