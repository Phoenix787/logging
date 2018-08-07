package reflections_in_samples;

import references.Student;

import java.lang.reflect.*;

public class App02 {
    public static void main(String[] args) {
        try {
            Class myClassObject = Class.forName("references.Student");
            int classModifiers = myClassObject.getModifiers();

            System.out.println(Modifier.isPrivate(classModifiers));
            System.out.println(Modifier.isPublic(classModifiers));

            String fullName = myClassObject.getName();
            String justName = myClassObject.getSimpleName();

            System.out.println("Full name: " + fullName);
            System.out.println("Simple name: " + justName);

            //зная класс мы можем получить информацию о пакете
            System.out.println(myClassObject.getPackage());
            //получаем информацию о суперклассе класса
            System.out.println(myClassObject.getSuperclass());

            //список интерфейсов реализуемых классом можно получить следующим образом
            Class[] interfaces = myClassObject.getInterfaces();

            /**
             * Рефлексия в Java: Конструкторы
             * С помощью Java Reflection API можно получать информацию про конструкторы классов
             * и создавать объекты во время выполнения. Это делается с помощью класса Java
             * java.lang.reflect.Constructor.
             */

            Constructor[] constructors = myClassObject.getConstructors();

            /**
             * Создание объектов с помощью конструкторов
             * Теперь получив конструкторы класса и зная их переметры, мы можем создать новый экземпляр указанного класса:
             */

            try {
                Constructor constructor = myClassObject.getConstructor();
                Student student = (Student)constructor.newInstance();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }

            /**
             * Рефлексия в Java: Поля
             * Используя рефлексию мы можем работать с полями — переменными-членами класса.
             * В этом нам помогает Java класс java.lang.reflect.Field:
             * с помощью него в рантайме мы можем устанавливать значения и получать данные с полей.
             * Каждый элемент массива содержит экземпляр public поля, объявленного в классе.
             */
            Field[] fields = myClassObject.getFields();

            for (Field field : fields) {
                System.out.println(field.getName());
            }

            //Получаем тип поля
            Field field = myClassObject.getField("name");
            Object fieldType = field.getType();

/**
 * Используя ревфлексию в Java мы можем получать информацию о методах и вызывать их в рантайме.
 * Для этого используется класс java.lang.reflect.Method:
 */

            Method[] methods = myClassObject.getMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            Method method = myClassObject.getMethod("setName", String.class);

            /**
             * Параметры метода и типы возвращаемых значений
             * Получить параметры метода можно так:
             */
            Class[] paramsMethod = method.getParameterTypes();

            //получаем тип возвращаемого значения
            Class returnParam = method.getReturnType();

            //Вызов метода с помощью Java рефлексии
            //objectToInvokeOn имеет тип Object и является объектом, для которого мы хотим вызвать метод sayHello().
            //parameterTypes — имеет тип Class[] и представляет собой параметры, которые метод принимает на вход.
            //params имеет тип Object[] и представляет собой пераметры, которые переданы методы.
            String objectToInvoke = "name";

            method.invoke(objectToInvoke, paramsMethod);

        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
