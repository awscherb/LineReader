LineReader
==========

Provides a way to traverse through every line of a text file.

Usage
-----

Use the factory method to instantiate a new `LineReader`:

    LineReader l = LineReader.factory("file_location.txt");
    
Treat a `LineReader` as if it were an `Iterator`; that is to say calling the `next()` method will traverse over every line in the text file you provided.

For example, say we have a text file that looks like this:

    Roses are red
    Violets are blue
    I like Java
    And so do you

We call the factory method and supply the location of this file as the argument:

    LineReader poem = LineReader.factory("java_poem.txt");

Calling the `next()` method would produce the string:

    Roses are red


LineReaders implements the `Iterator` interface, so no need to call the `iterator()` method. (If you do, it will just return the object which you called the method on)

    l.hasNext();
    l.next();
    l.remove();
    
and

    Iterator<String> it = l.iterator();
    it.hasNext();
    it.next();
    it.remove();
    
will produce the same results.
<hr>
*Just as a heads up:*<br>
I have yet to implement the `equals`, `toString`, and `hashCode` methods.

A Note on Performance
---------------------

~~Using text files with a relatively small (< 10^5) amount of lines, performance shouldn't be an issue. Text files with 10^6 or more lines will see a huge increase in the amount of time it takes to initialize the `LineReader`~~

Initialization is nearly instant; traversing will take a while, but is not completely unreasonable. 

