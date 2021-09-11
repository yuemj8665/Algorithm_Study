package practice;


public class PeopleVO {
    public String name;
    public String age;
    public String address;
    public String number;

    public void PeopleVO(String name, String age, String address, String number) {
        this.number = number;
        this.age = age;
        this.address = address;
        this.number = number;
    }

    public void ToString() {
        System.out.printf("이름 : %s, 나이 : %s, 주소 : %s, 휴대폰 번호 : %s",this.name,this.age,this.address,this.number);
    }



    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
