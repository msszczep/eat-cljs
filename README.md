# eat-cljs 

The Edinburgh Association Thesaurus web app, written in Clojurescript.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Compiling Javascript

I found these commands useful for compiling the Javascript file on Ubuntu:

    sudo update-alternatives --config java
    Select Java 8
    lein cljsbuild once

## Running

To start a web server for the application, run:

    lein ring server

Then visit:

    http://localhost:3000/eat.html

## Credits / License

https://github.com/dariusk/ea-thesaurus

Copyleft © 2020 by Mitchell Szczepanczyk 
