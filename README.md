### Demo Generic Method Injection
Playground for https://stackoverflow.com/q/76082820/592355

- Inter scope dependencies
- Generic Beans
- (mock) ["third party classes"](/src/main/java/com/thirdparty/)
- [Sample jpa model](/src/main/java/com/stackoverflow/demogenericmj/model):
   - emp (loyee)
   - dep (artment)
   - with an (unmapped) base interface
   - [repositories](/src/main/java/com/stackoverflow/demogenericmj/repo) (with structure)
- alternative "service definitions" in
   - [auto](/src/main/java/com/stackoverflow/demogenericmj/service/auto)
   - [manual](/src/main/java/com/stackoverflow/demogenericmj/service/manual)
- [Test](/src/test/java/com/stackoverflow/demogenericmj/AllTests.java)


