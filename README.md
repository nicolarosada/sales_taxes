# sales_taxes
Sales taxes example project

The main class is com.nicolarosada.salestaxes.SalesTaxes.
It has to be instantiated passing the input shopping basket as String. The receipt can be retrieved as String calling getReceipt() method.

The input/output has been managed by hard coded unit tests passing Strings. It can be easily extended in order to support other interfaces as io files, command line, BufferedStreams etc.

I chose a more clean, flexible and scalable approach compare to a pure performance-oriented approach. This can be found in many parts of the code where some variables, cycles and structures could be simplified improving the performance, but reducing flexibility.
An example is the choice of the map for the storage of the tax categories. Having only 2 tax rates (the default and the exempt) I could use a set of Strings that required less memory, but if we have to add another tax rate, we would need more work to implement the features.

I implemented a couple of structures for the recognition of the text name of the shopping baskets (the selection is hardcoded, but it could be parametrized).
Both uses a map with String as a key and the tax rate of the product as value, but with a different working mechanism.
1. One split the product name into single words. Thus, it searches if at least one of the words is present into the map and it assigns the product category accordingly.
This first method is the faster, but also the less powerful because it uses only one word as key.
2. The more complex method uses a bigger dataset of names for the books, food and drugs. Moreover, the key can be a sentence (for example "chicken wings" and not only "chicken" or "wings"). The drawback is that this approach is slower: it searches for all the possible contiguous combination of words in the map. For example, if the shopping basket name is "chicken wings" it query the map with "chicken", "wings" and "chicken wings".

The data set used into the program has been created starting from the following public data sets.<br />
Drugs: https://open.canada.ca/data/en/dataset/bf55e42a-63cb-4556-bfd8-44f26e5a36fe<br />
Food: https://www.kaggle.com/kmader/food41#meta.zip<br />
I didn't add the books array from a public repository just for a matter of time, it wouldn't add much information to the exercise.
