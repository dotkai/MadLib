MadLib
======
* Language: JAVA 
* Program: Eclipse
* Origin: UCI Class Project (Some files were provided by instructor, but most written by myself)
* MAIN CLASS: src/Generator.java

This program is designed to create randomly generated phrases based on information given from a file as specified
by the user.

It is possible to change the file name via the main class (Generator.java). The current default is 
set to `madlib.txt` and a total of 10 sets are created. Two other options are currently provided, however you 
are welcome to write your own files to parse.

The different text files:
* **Madlib** : A classic madlib maker. But instead of you coming up with the words, the program randomly selects them itself.
Some are funny, some may not make so much sense, but you never know.

```java
 Once upon a time, there was a sad pan who liked to hug .
```

* **Sentences** : Creates random, grammatically incorrect sentences from a given dictionary of nouns, verbs, adjectives,
and so on. They can be slightly humerous, and the length varies.

```java
The angry sofa question it and The nose and The mysterious stove as well .
```

* **Facile** : The original intend of the program was to generate a few sets of commands for the Facile programming
language. However it is not guaranteed to be functional. NL indicates what would be a new line.

```java
LET C 0 NL IF O = 4 THEN 2 NL GOTO 16 NL SUB E 18 NL DIV U 18 NL END NL GOSUB 13 NL . NL
```

* **Kral** : This is an alien language I invented with an interesting structure for writing syllables. English has
consonants and nouns, kral has jiza, blen, and lurin. I made this to assist with creatng words, since making up 
massive amounts of words can be very tedious and takes away from programming time. Spaces are not removed since
the primary purpose of the program is a grammar generator, not word maker.

```java
 d y o l e s l i o l r .
```
## Use
###Overview:
The way the program works is fairly similar to how madlibs work. You can have predefined text (such as with the 
facile example) and spaces, or holes, from which the program randomly 
selects words from a predefined dictionary. Each dictionary itself has a name, for the respective hole it will fill.

In other words, `[noun]` will point to the `noun` dictionary. The names however can be whatever desired. Parsing is 
similar to Java, or Css. Each dictionary is contained within cury-braces `{}`, the first line after contains the name
of the dictionary within brackets `[egname]`. Each item after is a member of that dictionary and takes up one line,
completed by `;`. The dictionaries members themselves can have holes, defined by other dictionary names, to pull in 
random selections from that respective dictionary as well. Note, these will keep being filled up until an "end point" is
reached, or a line without another dictionary pointer.

The first dictionary filled is the master one. The name of it is irrelevant, though useful to have for reference 
purposes. There is no set length for members in the following dictionaries. Spacing in the lines is important in 
regards to referencing other dictionaries. Meaning `[egname].` will not call `[egname]`. Thus punctuation and the
like should not be combined with such. Generally the files are written top down, but it is possible to call a dictionary
after it has been referenced instead of before.

###Example: 
You can look at the .txt files for more comprehensive examples.

```madlib
{
[example]
You can put [noun] here . ;
}

{
[noun]
anything ;
something [adjective] ;
}

{
[adjective]
awesome ;
utterly pointless ;
}
```

**Reminder**: There will be a total of 10 implimentations generated. The more selections you have in the dictionaries
the more random it will be.
 
