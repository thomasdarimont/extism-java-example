package example;

import org.extism.sdk.Plugin;
import org.extism.sdk.manifest.Manifest;
import org.extism.sdk.wasm.PathWasmSource;

import java.util.List;

public class ExtismExample {

    public static void main(String[] args) {

        var wasmPath = args.length > 0 ? args[0] : "src/main/resources/code.wasm";
        var functionName = args.length > 1 ? args[1] : "count_vowels";
        var input = args.length > 2 ? args[2] : "Hello World";

        var manifest = new Manifest(List.of(new PathWasmSource("code", wasmPath, null)));

        System.out.printf("Executing \"%s\" from \"%s\" with input \"%s\"%n", functionName, wasmPath, input);

        try (var plugin = new Plugin(manifest, false, null)) {
            var output = plugin.call(functionName, input);
            System.out.println(output);
        }
    }
}
