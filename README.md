# Documentation

You can check the documentation [here](https://docs.locarta.co/).



# Build

1. To build this project you have to create a file `credentials.properties` in a root folder of this project and fill it according to `credentials.properties.example`.
It contains credentials to download the Locarta SDK dependency and your publisher id.

2. Command for sanity checking: `./gradlew app:test`

3. Note this project includes SDK as transitive dependency if you have conflicts with your existing dependencies,
   please set transitive to `true` and include missing dependencies separately
      
   ```
    compile("co.locarta:locarta-sdk:783.2b8ab3e-pubProd@aar") {
        transitive = true;
    }
    ```
