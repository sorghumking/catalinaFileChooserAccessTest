Minimal app demonstrating inability to access Documents, Desktop, and Downloads
dirs in macOS 10.15 "Catalina" from JFileChooser when bundled as an app. These
dirs are accessible through FileDialog, which appears to use the native macOS chooser.
The expected system dialog "CatalinaFileChooserAccessTest.app would like to access the 
[folder name] folder" does not appear in JFileChooser, thus access cannot be granted.

These dirs are accessible from both dialogs when built and run locally.

The problem manifests only when packaged as an app bundle.

### Building

- Download Ant 1.10.7 at [https://ant.apache.org/bindownload.cgi]
- Exract Ant, add [Ant root]/bin dir to your PATH if desired.
- Download JarBundler 3.3.0 JAR at [https://github.com/UltraMixer/JarBundler/releases]
- Move jarbundler-core-3.3.0.jar to the [Ant root]/lib dir.
- In CatalinaFileChooserAccessTest dir, run `ant` to build an app bundle
- Launch CatalinaFileChooserAccessTest.app