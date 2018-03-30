package enumeration

enum Visibility {
    PRIVATE (0),PUBLIC(1)

    Visibility (int value)
    {
        this.value=value
    }

     private final int value

     int getValue() {
        value
    }

   static Visibility convertIntoEnum(String inputString) {
       inputString = inputString.toUpperCase()
       Visibility visibility = inputString

       println(visibility.value)
   }
    }
//
// class Demo
//        {
//            public static void main(String[] args) {
//                String inputString = "PUBLIC"
//                inputString.toUpperCase()
//              Integer result=  convert(inputString)
//                println("corresponding value is :"+result)
//            }
//
//             static int convert(String inputString) {
//                    Visibility visibility = inputString
//                    //println visibility
//                    return visibility.value
//                }
//
//        }
