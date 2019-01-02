package rare.mysqlTest;

public class Card {
    private Integer cardId;
    private String cardInfo;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    @Override
    public String toString() {
        return "cardId = "+ this.getCardId() + " cardInfo = " + this.getCardInfo();
    }
}
