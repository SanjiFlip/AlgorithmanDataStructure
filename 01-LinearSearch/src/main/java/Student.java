/**
 * @ClassName Student
 * @Description TODO 手动实现equals方法
 * @Author wangyi
 * @Date 2020/12/5 23:31
 * @Version 1.0.0
 **/
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }


    @Override // 重写父类的equals方法
    public boolean equals(Object student){
        //判断地址  内存中的存放地址
        if (this == student){
            return true;
        }
        //判空
        if (student == null){
            return false;
        }
        // 判断类对象是否相等
        if (this.getClass() != student.getClass()){
            return false;
        }
        Student another = (Student) student;
        return this.name.toLowerCase().equalsIgnoreCase(another.name.toLowerCase());
    }

}
