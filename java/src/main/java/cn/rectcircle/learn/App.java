package cn.rectcircle.learn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import cn.rectcircle.learn.pb.AddressBookProtos.Person;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // 构造一个对象
        Person john = Person.newBuilder()
                .setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .addPhones(
                Person.PhoneNumber.newBuilder()
                    .setNumber("555-4321")
                    .setType(Person.PhoneType.HOME))
                .build();
        System.out.println("构建的对象");
        System.out.println(john);
        System.out.println();

        // 序列化
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        john.writeTo(os);
        byte[] data = os.toByteArray();
        System.out.println("序列化数据字节数：" + data.length);
        System.out.println();

        // 反序列化
        Person john2 = Person.parseFrom(new ByteArrayInputStream(data));
        System.out.println("反序列化出的对象");
        System.out.println(john);
        System.out.println("反序列化出的对象与原始对象equals结果："+john2.equals(john));
        System.out.println();
    }
}
