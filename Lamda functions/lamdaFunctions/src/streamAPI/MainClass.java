package streamAPI;

//Lambda, Lamda Method Inference,
// Stream, sorting, filter , map, collectors

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args){

        //older way to deal with interfaces or the way to deal with interfaces with many methods in it
//        Walkable obj=new WalkFast();
//        obj.walk(4);

//        Walkable obj=new Walkable() {
//            @Override
//            public int walk(int steps) {
//                return 0;
//            }
//        }

//        Walkable obj=(steps,isEnabled)->{
//            System.out.println("Walking fast "+steps+" steps");
//            return 2*steps;
//        };
//
//        Walkable obj2=(steps,isEnabled)->2*steps;
//        obj.walk(4,true);

        //stream

        List<String> fruits= List.of("Banana","Apple","kiwi","Mango");

//        Set<Integer> fruitsSet=
//                fruits
//                .stream()
//                .map(fruit->fruit.length())
//                .collect(Collectors.toSet());
//
//        System.out.println(fruitsSet);

//        Map<String,Integer> fruitsMap=
//                fruits
//                        .stream()
////                        .map(fruit->fruit.length())
//                        .collect(Collectors.toMap(
//                                fruit->fruit,
//                                fruit->fruit.length()
//                        ));
//
//        System.out.println(fruitsMap);


        Map<String,Integer> fruitsMap=
                fruits
                        .stream()
//                        .map(fruit->fruit.length())
                        .collect(Collectors.toMap(
                                fruit->fruit,
                                String::length
                        ));

        System.out.println(fruitsMap);

//
//        Stream<String> stream=fruits.stream();
//        stream.forEach((fruit)->{
//            System.out.println(fruit);
//        });

//        stream
//                .filter(fruit->fruit.length()<6)
//                .sorted()
////                .map(fruit->fruit.length())
////                .map(fruitLength->2*fruitLength)
//                .forEach(fruit-> System.out.println(fruit));

        Stream<String> stream=fruits.stream();

        stream
                .filter(fruit->fruit.length()<6)
                .sorted()
                .map(String::length)
                .map(fruitLength->2*fruitLength)
                .forEach(System.out::println);

    }
}

//Functional Interface is an interface with only 1 method/function in it and deafult methods are not counted in the process of counting methods for functional interface.
//@FunctionalInterface
interface Walkable{
    int walk(int steps,boolean isEnabled);
}

//class WalkFast implements Walkable{
//
//    @Override
//    public int walk(int steps) {
//        System.out.println("Walking fast "+steps+" steps");
//        return 2*steps;
//    }
//}