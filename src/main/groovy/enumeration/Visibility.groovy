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
    }

 class Demo
        {
            public static void main(String[] args) {
                convert("PUBLIC")
            }

             static int convert(String inputString) {
                    Visibility visibility = inputString
                    //println visibility
                    return visibility.value
                }

        }
