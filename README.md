# kt-di-example

Based on ideas in...

https://www.pacoworks.com/2018/02/25/simple-dependency-injection-in-kotlin-part-1/


Goal - get the simplicity of having a clear context to represent scope, *while* getting the benefits of dependency injection (implicit wiring of a dependency to a site of use).


The patterns followed here:

  action - a simple data object containing everything needed to do some work
  action dispatcher - a function that, when given a action, will do the work for that action. The function is presented on an interface. Any dependencies required by the function are enumerated as unimplemented "val" properties on the interface.
  scope - a concrete object that implements one or many action dispatchers. As a concrete, any unresolved dependencies (val properties) must be configured in order to compile.
  command - an action that is intended to represent a user action.
  command dispatcher - an action dispatcher for a command.
