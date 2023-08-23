package pojos;

public class DummyRestApiDataPojo {


    private String employee_name;
    private Integer employee_salary;
    private  Integer getEmployee_age;
    private String profile_image;

    public DummyRestApiDataPojo() {
    }

    public DummyRestApiDataPojo(String employee_name, Integer employee_salary, Integer getEmployee_age, String prfile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.getEmployee_age = getEmployee_age;
        this.profile_image = prfile_image;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getGetEmployee_age() {
        return getEmployee_age;
    }

    public void setGetEmployee_age(Integer getEmployee_age) {
        this.getEmployee_age = getEmployee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String prfile_image) {
        this.profile_image = prfile_image;
    }

    @Override
    public String toString() {
        return "DummyRestApiDataPojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", getEmployee_age=" + getEmployee_age +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
