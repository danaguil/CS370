package UGT_Data;

import java.util.ArrayList;

public class Customer extends User{

    private String first_name;
    private String last_name;
    private int card_number;
    private String name_on_card;
    private int exp_month;
    private int exp_year;
    private int cvv;
    private String address;
    private final ArrayList<Order> orders_list;
    private final ArrayList<Item> customer_cart;


    public Customer(String email, String username, String password, String first_name, String last_name, int card_number, String name_on_card,
                    int exp_month, int exp_year, int cvv, String address) {
        super(email, username, password);

        this.first_name = first_name;
        this.last_name = last_name;
        this.card_number = card_number;
        this.name_on_card = name_on_card;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.cvv = cvv;
        this.address = address;
        this.orders_list = new ArrayList<>();
        this.customer_cart = new ArrayList<>();
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public String getName_on_card() {
        return name_on_card;
    }

    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }

    public int getExp_month() {
        return exp_month;
    }

    public void setExp_month(int exp_month) {
        this.exp_month = exp_month;
    }

    public int getExp_year() {
        return exp_year;
    }

    public void setExp_year(int exp_year) {
        this.exp_year = exp_year;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order)
    {
        orders_list.add(order);
    }

    public void addToCart(Item item){
        customer_cart.add(item);
    }



}
