package rare.mysqlTest;

public class User {
    private int id;
    private String name;
    private Integer age;
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String str = "name="+ getName() + " age = "+ getAge() + " id = "+ getId();
        if (card != null) {
            str += " cardId = "+ card.getCardId()+ " cardInfo = "+ card.getCardInfo();
        }
        return   str;
    }
}
