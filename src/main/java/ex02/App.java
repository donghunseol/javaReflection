package ex02;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        String path = "/update-password";

        UserController con = new UserController();

        Method[] methods = con.getClass().getDeclaredMethods();
        //System.out.println(methods.length);

        for(Method method : methods){
            //System.out.println(method.getName());
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);
            // Annotation anno = method.getDeclaredAnnotation(RequestMapping.class);
            //RequestMapping rm = (RequestMapping) anno; // Annotation anno 일때 다운 캐스팅 해야한다.

            if(rm == null) continue;

            if(rm.uri().equals(path)){
                try {
                    method.invoke(con); // == con.login();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
