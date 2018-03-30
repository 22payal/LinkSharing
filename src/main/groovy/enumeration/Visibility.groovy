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

       return visibility
   }
    }

 class Demo
        {
            public static void main(String[] args) {
                String inputString = "PUBLIC"
                inputString.toUpperCase()
              String result=  convert(inputString)
                println("corresponding value is :"+result)

                println( Visibility.convertIntoEnum(inputString))
            }

             static String convert(String inputString) {
                    Visibility visibility = inputString
                    //println visibility
                    return visibility
                }

        }
