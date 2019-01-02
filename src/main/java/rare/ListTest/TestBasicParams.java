package rare.ListTest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wxyou
 */
public class TestBasicParams {
    public List<BasicNameValuePair> newEntry(){
        List<BasicNameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("rare1", "rare11"));
        list.add(new BasicNameValuePair("adc","rare2"));
        list.add(new BasicNameValuePair("hhh","rare3"));
        list.add(new BasicNameValuePair("dd", "rare4"));


        return list;
    }
}
