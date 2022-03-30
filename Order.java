public class Order {

    int ID;
    int customer_ID;
    String status;
    String order;


    public Order(int ID, int customer_ID, String status, String order) {
        this.ID = ID;
        this.customer_ID = customer_ID;
        this.status = status;
        this.order = order;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
