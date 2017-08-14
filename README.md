### A re-frame tic-tac-toe implementation

Simple tic-tac-toe as implemented during August 14th London uSwitch Clojure Dojo.

### Run application:

```
lein clean
lein figwheel dev
```

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build

To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
