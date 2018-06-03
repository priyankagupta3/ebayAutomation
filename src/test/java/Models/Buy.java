package Models;

public class Buy {
    private String  getCardName;
    private String  cardNumber;
    private String  cvc;

    public String getCardName() {
        return getCardName;
    }

    public void setCardName(String getCardName) {
        this.getCardName = getCardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getcvc() {
        return cvc;
    }

    public void setcvc(String cvc) {
        this.cvc = cvc;
    }
}
