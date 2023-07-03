import java.util.List;

public class Main {

    // compilation error
//    var notLocal = "it doesn't work";
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // just declaring variable using var doesn't work as well
        // we also need an initializing expression on the right-hand side
        // otherwise, the compiler doesn't know what type to infer
//        var test;
        var num = 1;

        // this works fine
        // the inferred type of nums is Array<Int>
        var nums = new int[]{1, 2, 3};

        // there is another way to create an array with values directly in Java
        // where you can omit the new operator and the type
        // you cannot use such an array literal with var, you need to have an explicit type
        int[] nums2 = {1, 2, 3};
//        var nums2 = {1, 2, 3};

        for (Book book : Book.getBookList()) {
            book.getTitle();
        }

        for (var book : Book.getBookList()) {
            book.getTitle();
        }

        SomeReallyUglyBigTypeName ugly = new SomeReallyUglyBigTypeName();
        var notSoUgly = new SomeReallyUglyBigTypeName();

        List<SomeReallyUglyBigTypeName> uglies = List.of(ugly); // List.of() introduced in Java 9
        var uglies2 = List.of(ugly);

        // copyOf() introduced in Java 10
        // pass in a list and get back an unmodifiable copy of that list
        // similar method for Set and Map also introduced in Java 10
        var moreUglies = List.copyOf(uglies2);

        // don't do this
        // chaining methods until you get a result
        // a isn't descriptive at all
        // and also use var, so we leave the type implicit too
        // these 2 combined make the code really hard to follow, especially when using a later on
        var a = Book.getBook().getAuthors().stream().findFirst().map(String::length).orElse(0);

        // what we can do is chop up the stream into multiple steps
        // where we assign intermediate results to local vars using var and descriptive names
        // we end up with a length variable which is easy to follow
        // we are not interested in the intermediate types but in the semantics of the intermediate results
        var authors = Book.getBook().getAuthors();
        var firstAuthor = authors.stream().findFirst();
        var length = firstAuthor.map(String::length).orElse(0);


    }
}