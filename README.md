Minimal Java app demonstrating inability to access Documents, Desktop, and Downloads
dirs in macOS 10.15 "Catalina" from Java JFileChooser when bundled as an app. These
dirs are accessible through FileDialog, which appears to use the native macOS chooser.
The expected system dialog "CatalinaFileChooserAccessTest.app would like to access the 
[folder name] folder" does not appear in JFileChooser, thus access cannot be granted.

![demo GIF](https://github.com/sorghumking/catalinaFileChooserAccessTest/blob/master/img/chooserAccessDemo.gif)

These dirs are accessible from both dialogs when built and run locally.

The problem manifests only when packaged as an app bundle.

Tested in Java 8 and 11.

### Building

- Download Ant 1.10.7 at [https://ant.apache.org/bindownload.cgi]
- Extract Ant, add [Ant root]/bin dir to your PATH if desired.
- Download jarbundler-core-3.3.0.jar at [https://github.com/UltraMixer/JarBundler/releases]
- Move jarbundler-core-3.3.0.jar to the [Ant root]/lib dir.
- In CatalinaFileChooserAccessTest dir, run `ant` to compile and generate app bundle.
- Run non-bundled via `java`:
  * `cd classes`
  * `java org.csdco.CatalinaFileChooserAccessTest`
  * Documents/Desktop/Downloads contents are accessible in JFileChooser.
- Double-click to launch CatalinaFileChooserAccessTest.app. Documents/Desktop/Downloads contents are *not* accessible in JFileChooser.
