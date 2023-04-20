import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CollectionsStudy {
    @Test
    public void test() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Sasha");
        nameList.add("Dima");
        nameList.add("Tanya");
        nameList.add("Vlad");
        nameList.add("Max");
        nameList.add("Vovan");

        System.out.println(nameList.get(3));
        //Assert.assertEquals(nameList.size(),0);
//        nameList.remove(5);
//        Assert.assertEquals(nameList.size(),5);
//
//        LinkedList<String> nameLinkeListList = new LinkedList<>();
//        nameLinkeListList.add("Sasha");
//        nameLinkeListList.add("Dima");
//        nameLinkeListList.add("Tanya");
//        nameLinkeListList.add("Vlad");
//        nameLinkeListList.add("Max");
//        nameLinkeListList.add("Vovan");

    }

    @Test
    public static void test1() {

        HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");

        System.out.println(cars);
    }


}
