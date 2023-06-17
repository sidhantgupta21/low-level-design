package machinecoding.gymbooking.customer.model;

public class Customer {

    public static class CustomerBuilder {
        private int id;
        private String name;
        private String email;
        private String mobileNum;

        public CustomerBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public CustomerBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withMobile(String mobileNum) {
            this.mobileNum = mobileNum;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private int id;
    private String name;
    private String email;
    private String mobile;

    private Customer(CustomerBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.mobile = builder.mobileNum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

}
