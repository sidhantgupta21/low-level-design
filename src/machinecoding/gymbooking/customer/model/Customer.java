package machinecoding.gymbooking.customer.model;

public class Customer {

    public static class CustomerBuilder {
        private String name;
        private String email;
        private String mobileNum;

        public CustomerBuilder(String name) {
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

    private String name;
    private String email;
    private String mobile;

    private Customer(CustomerBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.mobile = builder.mobileNum;
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
