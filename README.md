# kt-di-example

Based on ideas in...

https://www.pacoworks.com/2018/02/25/simple-dependency-injection-in-kotlin-part-1/


Goal - get the simplicity of having a clear context to represent scope, *while* getting the benefits of dependency injection (implicit wiring of a dependency to a site of use).


The patterns followed here:

  syntax - an interface that provides an extension function for a class. Dependencies for the function may be enumerated as unimplemented "val" properties on the interface.

  action - a simple data object containing everything needed to do some work
  
  action dispatcher - a function that, when given a action, will do the work for that action. The function is presented on an interface. An action dispatcher is a particular kind of "syntax".
  
  scope - a concrete object that implements one or many action dispatchers. As a concrete, any unresolved dependencies (val properties) must be configured in order to compile.
  
  command - an action that is intended to represent a user action.
  
  command dispatcher - an action dispatcher for a command.
