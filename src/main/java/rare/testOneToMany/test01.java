package rare.testOneToMany;

public class test01 {
    public static void main(String[] args) {
        Person person = new Person("rare1","18825169493");
        Car c1 = new Car("宝马",400000);
        Car c2 = new Car("宝来",100000);
        Car c3 = new Car("宝骏",800);

        person.setCars(new Car[]{c1,c2,c3});
        c1.setPerson(person);
        c2.setPerson(person);
        c3.setPerson(person);
        System.out.println(person.getInfo()+"拥有的车辆");

        for (Car str : person.getCars()) {
            System.out.println(str.getName() + "   "+ str.getPrice());
        }

        System.out.println(c1.getInfo()+" 这辆车的所属人："+c1.getPerson().getInfo());
        System.out.println(c2.getInfo()+" 这辆车的所属人："+c1.getPerson().getInfo());
        System.out.println(c3.getInfo()+" 这辆车的所属人："+c1.getPerson().getInfo());


    }
}
