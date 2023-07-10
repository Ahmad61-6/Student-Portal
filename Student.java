class Student {
    private String name;
    private int age;
    private String address;
    private String department;

    public Student(String name, int age, String address, String department) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.department = department;
    }

    // Getter and setter methods to access and modify the private attributes of a student
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Override the toString() method to display the student's information in a presentable way
    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nAddress: " + address + "\nDepartment: " + department + "\n";
    }
}
