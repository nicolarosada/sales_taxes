# sales_taxes
Sales taxes example project

The main class is com.nicolarosada.salestaxes.SalesTaxes.
It has to be instantiated passing the input shopping basket as String. The receipt can be retrieved as String calling getReceipt() method.

The input/output has been managed by hard coded unit tests passing Strings. It can be easily extended in order to support other interfaces as io files, command line, BufferedStreams etc.

I chose a more clean, flexible and scalable approach compare to a pure performance-oriented approach. This can be found in many parts of the code where some variables, cycles and structures could be simplified improving the performance, but reducing flexibility.
An example is the choice of the map for the storage of the tax categories. Having only 2 tax rates (the default and the exempt) I could use a set of Strings that required less memory, but if we have to add another tax rate, we would need more work to implement the features.
